package controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import database.MovieDB;
import model.Movie;

/**
 * movie controller
 * @author Phung Minh Khanh
 */
public class MovieController{

    private static ArrayList<Movie> listMovies = new ArrayList<Movie>();

    /**
     * retrieve all movies details in the database and put tn the listMovies
     */
    public static void readDB(){

        listMovies = MovieDB.readData();
    }

    /**
     * save back the listMovies Array list to the database text file
     */
    public static void saveDB(){

        MovieDB.saveData(listMovies);
    }

    /**
     *
     * @param movie
     * @return if create a new movie is successful
     */
    public static boolean create(Movie movie){
        if(checkExist(movie.getID())){
            return false;
        }
        listMovies.add(movie);
        MovieDB.saveData(listMovies);
        return true;
    }

    /**
     *
     * @param ID
     * @return a Movie with specific ID in the database
     */
    public static Movie read(int ID){
        for(int i = 0; i < listMovies.size(); i++){
            if(listMovies.get(i).getID() == ID){
                return listMovies.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @param ID
     * @return if a movie Id is existed in the database
     */
    public static boolean checkExist(int ID){
        for(int i = 0; i < listMovies.size(); i++){
            if(listMovies.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param ID
     * @return if we could delete a  movie with specific ID in the database
     */
    public static boolean delete(int ID){
        for(int i = 0; i < listMovies.size(); i++){
            if(listMovies.get(i).getID() == ID){
                listMovies.remove(i);
                MovieDB.saveData(listMovies);
                return true;
            }
        }
        return false;
    }

    /**
     * update a movie details
     * @param movie
     * @return
     */
    public static boolean update(Movie movie){
        for(int i = 0; i < listMovies.size(); i++){
            if(listMovies.get(i).getID() == movie.getID()){
                movie.setOverallRating(listMovies.get(i).getOverallRating());
                listMovies.set(i, movie);
                MovieDB.saveData(listMovies);
                return true;
            }
        }
        return false;
    }

    /**
     * display all available movie
     */
    public static void displayAll(){
        System.out.println("All available movies:");
        for(int i = 0; i< listMovies.size(); i++){
            output(listMovies.get(i));
        }
    }

    /**
     * displau a movie details with specific ID
     * @param ID
     */
    public static void displayByID(int ID){
        for(int i = 0; i< listMovies.size(); i++){
            if(listMovies.get(i).getID() == ID){
                output(listMovies.get(i));
                return;
            }
        }
    }

    /**
     * display the detail of a Movie object
     * @param movie
     */
    public static void output(Movie movie){
        System.out.println("ID: "+ movie.getID());
        System.out.println("Name: " + movie.getName());
        System.out.println("Category: "+ movie.getCategory() );
        System.out.println("Description: "+ movie.getDescription() );
        System.out.println("Director: "+ movie.getDirector() );
        System.out.println("Cast: "+ movie.getCast() );
        System.out.println("Restriction: "+ movie.getRestriction() );
        System.out.println("Duration: "+ movie.getDuration() );
        System.out.println("Overall Rating: "+ movie.getOverallRating() );
        System.out.println("Start Date: "+ movie.getStartDate());
        System.out.println("End Date: "+ movie.getEndDate());
        System.out.println("Preview Date: "+ movie.getPreviewDate());
        if(movie.getStatusMovie() == 3){
            System.out.println("Status: End of showing");
        }
        else if(movie.getStatusMovie() == 2){
            System.out.println("Status: Now showing");
        }
        else if(movie.getStatusMovie() == 1){
            System.out.println("Status: Preview");
        }
        else if(movie.getStatusMovie() == 0){
            System.out.println("Status: Upcoming");
        }
        System.out.print("\n");
    }

    /**
     * sorting by Rating class
     */
    public static class SortByRating implements Comparator<Movie> {
        @Override
        public int compare(Movie x, Movie y) {
            float x_rate = x.getOverallRating();
            float y_rate = y.getOverallRating();

            if (x_rate > y_rate){
                return -1;
            }
            else if (x_rate < y_rate){
                return 1;
            }
            else{
                return 0;
            }
        }
    }

    /**
     * sorting by Tickets class
     */
    public static class SortByTicket implements Comparator<Movie>{
        @Override
        public int compare(Movie x, Movie y) {
            int x_tickets = HistoryController.getTicket(x.getID());
            int y_tickets = HistoryController.getTicket(y.getID());
            if (x_tickets > y_tickets){
                return -1;
            }
            else if (x_tickets < y_tickets){
                return 1;
            }
            else{
                return 0;
            }
        }
    }

    /**
     * display top 5 movies by rating
     */
    public static void topFiveByRating(){
        ArrayList<Movie> all_movies = new ArrayList<>();

        for (int i = 0; i < listMovies.size(); i++){
            all_movies.add(listMovies.get(i));
        }

        Collections.sort(all_movies, new SortByRating());
        int index = 0;

        while(index < Math.min(5, listMovies.size())){
            output(all_movies.get(index));
            ++index;
        }
    }

    /**
     * display top 5 movies by tickets sales
     */
    public static void topFiveByTicket(){
        ArrayList<Movie> all_movie = new ArrayList<>();

        for(int i = 0; i < listMovies.size(); i++){
            all_movie.add(listMovies.get(i));
        }

        Collections.sort(all_movie, new SortByTicket());
        int index = 0;

        while (index < Math.min(5, listMovies.size())){
            output(all_movie.get(index));
            ++index;
        }
    }

}