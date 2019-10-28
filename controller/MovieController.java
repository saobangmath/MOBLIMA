package controller;
import java.util.ArrayList;
import database.MovieDB;
import model.Movie;
public class MovieController{

    private ArrayList<Movie> listMovies = new ArrayList<Movie>();
    private MovieDB db = new MovieDB();

    public MovieController(){
        listMovies = db.readData();
    }
    
    public boolean createMovie(Movie movie){
        if(checkExistMovie(movie.getID())){
            return false;
        }
        this.listMovies.add(movie);
        this.db.saveData(this.listMovies);
        return true;
    }

    public boolean checkExistMovie(int ID){
        for(int i = 0; i < this.listMovies.size(); i++){
            if(this.listMovies.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

    public boolean deleteMovie(int ID){
        for(int i = 0; i < this.listMovies.size(); i++){
            if(this.listMovies.get(i).getID() == ID){
                this.listMovies.remove(i);
                this.db.saveData(this.listMovies);
                return true;
            }
        }   
        return false;   
    }

    public boolean updateMovie(Movie movie){
        for(int i = 0; i < this.listMovies.size(); i++){
             if(this.listMovies.get(i).getID() == movie.getID()){
                movie.setOverallRating(this.listMovies.get(i).getOverallRating());
                this.listMovies.set(i, movie);
                this.db.saveData(this.listMovies);
                return true;
            }
        }   
        return false;           
    }

    public void displayMovie(){
        for(int i = 0; i< this.listMovies.size(); i++){
            System.out.println("ID: "+ this.listMovies.get(i).getID());
            System.out.println("Name: " + this.listMovies.get(i).getName());
            System.out.println("Category: "+ this.listMovies.get(i).getCategory() );
            System.out.println("Description: "+ this.listMovies.get(i).getDescription() );
            System.out.println("Director: "+ this.listMovies.get(i).getDirector() );
            System.out.println("Cast: "+ this.listMovies.get(i).getCast() );
            System.out.println("Restriction: "+ this.listMovies.get(i).getRestriction() );
            System.out.println("Overall Rating: "+ this.listMovies.get(i).getOverallRating() );
            System.out.println("\n");
        }
    }
}