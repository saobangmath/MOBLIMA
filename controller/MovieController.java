package controller;
import java.util.ArrayList;
import database.MovieDB;
import model.Movie;
public class MovieController{

    private static ArrayList<Movie> listMovies = new ArrayList<Movie>();

    public static void readDB(){
        listMovies = MovieDB.readData();
    }

    public static void saveDB(){
        MovieDB.saveData(listMovies);
    }
    
    public static boolean create(Movie movie){
        if(checkExist(movie.getID())){
            return false;
        }
        listMovies.add(movie);
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
}