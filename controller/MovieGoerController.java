package controller;
import java.util.ArrayList;
import database.MovieGoerDB;
import model.MovieGoer;
public class MovieGoerController{

    private static ArrayList<MovieGoer> listMovieGoer = new ArrayList<MovieGoer>();

    public static void readDB(){
        listMovieGoer = MovieGoerDB.readData();
    }

    public static void saveDB(){
        MovieGoerDB.saveData(listMovieGoer);
    }
    
    public static boolean create(MovieGoer goer){
        if(checkExist(goer.getEmail())){
            return false;
        }
        listMovieGoer.add(goer);
        return true;
    }

    public static MovieGoer read(String email){
        for(int i = 0; i < listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(email)){
                return listMovieGoer.get(i);
            }
        }   
        return null;   
    }

    public static boolean checkExist(String email){
        for(int i = 0; i < listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public static boolean delete(String email){
        for(int i = 0; i < listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(email)){
                listMovieGoer.remove(i);
                return true;
            }
        }   
        return false;   
    }

    public static boolean update(MovieGoer goer){
        for(int i = 0; i < listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(goer.getEmail())){
                listMovieGoer.set(i, goer);
                return true;
            }
        }   
        return false;           
    }

    public static void addRewardPoint(float earnedPoint, String email){
        float rewardPoint;
        for(int i = 0; i < listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(email)){
                MovieGoer movieGoer = listMovieGoer.get(i);
                rewardPoint = movieGoer.getRewardPoint() + earnedPoint;
                movieGoer.setRewardPoint(rewardPoint);
                listMovieGoer.set(i, movieGoer);
                return;
            }
        }   
    }

    public static void displayAll(){
        for(int i = 0; i< listMovieGoer.size(); i++){
            output(listMovieGoer.get(i));
        }
    }

    public static void displayByID(String Email){
        for(int i = 0; i< listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(Email)){
                output(listMovieGoer.get(i));
                return;
            }
        }
    }

    public static void output(MovieGoer movieGoer){
        System.out.println("Email: "+ movieGoer.getEmail());
        System.out.println("Name: " + movieGoer.getName());
        System.out.println("Age: "+ movieGoer.getAge());
        System.out.println("Mobile: "+ movieGoer.getMobile());
        System.out.println("Reward point: "+ movieGoer.getRewardPoint());
        System.out.print("\n");
    }
}