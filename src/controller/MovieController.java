package controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import database.HistoryDB;
import database.MovieDB;
import model.History;
import model.Movie;

public class MovieController{

    private static ArrayList<Movie> listMovies = new ArrayList<Movie>();
    private static ArrayList<History> listHistory = new ArrayList<>();

    public static void readDB(){

        listMovies = MovieDB.readData();
        listHistory = HistoryDB.readData();
    }

    public static void saveDB(){

        MovieDB.saveData(listMovies);
        HistoryDB.saveData(listHistory);
    }

    public static boolean create(Movie movie){
        if(checkExist(movie.getID())){
            return false;
        }
        listMovies.add(movie);
        MovieDB.saveData(listMovies);
        return true;
    }

    public static Movie read(int ID){
        for(int i = 0; i < listMovies.size(); i++){
            if(listMovies.get(i).getID() == ID){
                return listMovies.get(i);
            }
        }
        return null;
    }

    public static boolean checkExist(int ID){
        for(int i = 0; i < listMovies.size(); i++){
            if(listMovies.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

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

    public static void displayAll(){
        System.out.println("All available movies:");
        for(int i = 0; i< listMovies.size(); i++){
            output(listMovies.get(i));
        }
    }

    public static void displayByID(int ID){
        for(int i = 0; i< listMovies.size(); i++){
            if(listMovies.get(i).getID() == ID){
                output(listMovies.get(i));
                return;
            }
        }
    }

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
        System.out.print("\n");
    }

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

    public static int getTicket(int movieID){
        int ticket = 0;
        for (int i = 0; i < listHistory.size(); i++){
            History history = listHistory.get(i);
            if (history.getID() == movieID){
                ticket = ticket + history.getNoTicket();
            }
        }
        return ticket;
    }

    public static class SortByTicket implements Comparator<Movie>{
        @Override
        public int compare(Movie x, Movie y) {
            int x_tickets = getTicket(x.getID());
            int y_tickets = getTicket(y.getID());
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