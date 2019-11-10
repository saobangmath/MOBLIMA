package controller;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import database.MovieDB;
import model.Movie;
public class MovieController{

    private static ArrayList<Movie> listMovies = new ArrayList<Movie>();

    public static void readDB(){
        listMovies = MovieDB.readData();
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
        for(int i = 0; i< listMovies.size(); i++){
            System.out.println("ID: "+ listMovies.get(i).getID());
            System.out.println("Name: " + listMovies.get(i).getName());
            System.out.println("Category: "+ listMovies.get(i).getCategory() );
            System.out.println("Description: "+ listMovies.get(i).getDescription() );
            System.out.println("Director: "+ listMovies.get(i).getDirector() );
            System.out.println("Cast: "+ listMovies.get(i).getCast() );
            System.out.println("Restriction: "+ listMovies.get(i).getRestriction() );
            System.out.println("Overall Rating: "+ listMovies.get(i).getOverallRating() );
            System.out.println("Start Dtae: "+ listMovies.get(i).getStartDate());
            System.out.println("End Date: "+ listMovies.get(i).getEndDate());
            System.out.println("\n");
        }
    }

    public static void displayByID(int ID){
        for(int i = 0; i< listMovies.size(); i++){
            if(listMovies.get(i).getID() == ID){
                System.out.println("ID: "+ listMovies.get(i).getID());
                System.out.println("Name: " + listMovies.get(i).getName());
                System.out.println("Category: "+ listMovies.get(i).getCategory() );
                System.out.println("Description: "+ listMovies.get(i).getDescription() );
                System.out.println("Director: "+ listMovies.get(i).getDirector() );
                System.out.println("Cast: "+ listMovies.get(i).getCast() );
                System.out.println("Restriction: "+ listMovies.get(i).getRestriction() );
                System.out.println("Overall Rating: "+ listMovies.get(i).getOverallRating() );
                System.out.println("Start Dtae: "+ listMovies.get(i).getStartDate());
                System.out.println("End Date: "+ listMovies.get(i).getEndDate());
                System.out.println("\n");
                return;
            }
        }
    }

    public static class SortByRating implements Comparator<Movie> {
        @Override
        public int compare(Movie x, Movie y) {
            return (x.getOverallRating() >= y.getOverallRating())  ? 0 : 1;
        }
    }

    public static class SortByTicket implements Comparator<Movie>{ //TODO Finish!

        @Override
        public int compare(Movie x, Movie y) {
            return 1;
        }
    }

    public static void DisplayByTopFiveByRating(){
        ArrayList<Movie> All_movies = new ArrayList<>();
        for (int i = 0; i < listMovies.size(); i++){
            All_movies.add(listMovies.get(i));
        }
        Collections.sort(All_movies, new SortByRating());
        int Movie_ID = 0;
        while(Movie_ID < Math.min(5, listMovies.size())){
            ++Movie_ID;
            displayByID(Movie_ID);
        }
    }

    public static void  DisplayByTopFiveByTicketSale(){
        ArrayList<Movie> All_Movie = new ArrayList<>();
        for(int i = 0; i < listMovies.size(); i++){
            All_Movie.add(listMovies.get(i));
        }
        // TODO add overall rating to the class movie -> return this class

    }
}