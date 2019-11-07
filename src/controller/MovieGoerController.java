package controller;
import java.util.ArrayList;
import database.MovieGoerDB;
import model.MovieGoer;
public class MovieGoerController{

    private static ArrayList<MovieGoer> listMovieGoer = new ArrayList<MovieGoer>();

    public static void readDB(){
        listMovieGoer = MovieGoerDB.readData();
    }

    public static boolean create(MovieGoer goer){
        if(checkExist(goer.getEmail())){
            return false;
        }
        listMovieGoer.add(goer);
        MovieGoerDB.saveData(listMovieGoer);
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
                MovieGoerDB.saveData(listMovieGoer);
                return true;
            }
        }
        return false;
    }

    public static boolean update(MovieGoer goer){
        for(int i = 0; i < listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(goer.getEmail())){
                listMovieGoer.set(i, goer);
                MovieGoerDB.saveData(listMovieGoer);
                return true;
            }
        }
        return false;
    }

    public static void displayAll(){
        for(int i = 0; i< listMovieGoer.size(); i++){
            System.out.println("Email: "+ listMovieGoer.get(i).getEmail());
            System.out.println("Name: " + listMovieGoer.get(i).getName());
            System.out.println("Age: "+ listMovieGoer.get(i).getAge());
            System.out.println("Mobile: "+ listMovieGoer.get(i).getMobile());
            System.out.println("\n");
        }
    }

    public static void displayByID(String Email){
        for(int i = 0; i< listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(Email)){
                System.out.println("Email: "+ listMovieGoer.get(i).getEmail());
                System.out.println("Name: " + listMovieGoer.get(i).getName());
                System.out.println("Age: "+ listMovieGoer.get(i).getAge());
                System.out.println("Mobile: "+ listMovieGoer.get(i).getMobile());
                System.out.println("\n");
                return;
            }
        }
    }
}