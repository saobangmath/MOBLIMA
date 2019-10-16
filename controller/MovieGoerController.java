package controller;
import java.util.List;
import java.util.ArrayList;
import database.MovieGoerDB;
import model.MovieGoer;
public class MovieGoerController{

    private ArrayList<MovieGoer> listMovieGoer = new ArrayList<MovieGoer>();
    private MovieGoerDB db = new MovieGoerDB();

    public MovieGoerController(){
        listMovieGoer = db.readData();
    }
    
    public boolean createMovieGoer(MovieGoer goer){
        if(checkExistMovieGoer(goer.getEmail())){
            return false;
        }
        this.listMovieGoer.add(goer);
        this.db.saveData(this.listMovieGoer);
        return true;
    }

    public boolean checkExistMovieGoer(String email){
        for(int i = 0; i < this.listMovieGoer.size(); i++){
            if(this.listMovieGoer.get(i).getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public boolean deleteMovieGoer(String email){
        for(int i = 0; i < this.listMovieGoer.size(); i++){
            if(this.listMovieGoer.get(i).getEmail().equals(email)){
                this.listMovieGoer.remove(i);
                this.db.saveData(this.listMovieGoer);
                return true;
            }
        }   
        return false;   
    }

    public boolean updateMovieGoer(MovieGoer goer){
        for(int i = 0; i < this.listMovieGoer.size(); i++){
            if(this.listMovieGoer.get(i).getEmail().equals(goer.getEmail())){
                this.listMovieGoer.set(i, goer);
                this.db.saveData(this.listMovieGoer);
                return true;
            }
        }   
        return false;           
    }

    public void displayMovieGoer(){
        for(int i = 0; i< this.listMovieGoer.size(); i++){
            System.out.println("Email: "+ this.listMovieGoer.get(i).getEmail());
            System.out.println("Name: " + this.listMovieGoer.get(i).getName());
            System.out.println("Age: "+ this.listMovieGoer.get(i).getAge());
            System.out.println("Mobile: "+ this.listMovieGoer.get(i).getMobile());
            System.out.println("\n");
        }
    }
}