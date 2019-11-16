package controller;
import java.util.ArrayList;
import database.MovieGoerDB;
import model.MovieGoer;

/**
 * moviegoer controller
 * @author Phung Minh Khanh
 */
public class MovieGoerController{

    private static ArrayList<MovieGoer> listMovieGoer = new ArrayList<MovieGoer>();

    /**
     * read all moviegoer details and put it to a listMoviegoer ArrayList
     */
    public static void readDB(){
        listMovieGoer = MovieGoerDB.readData();
    }

    /**
     * save the listMoviegoer back to the database text file
     */
    public static void saveDB(){
        MovieGoerDB.saveData(listMovieGoer);
    }

    /**
     *
     * @param goer
     * @return if a moviegoer is successfully created
     */
    public static boolean create(MovieGoer goer){
        if(checkExist(goer.getEmail())){
            return false;
        }
        listMovieGoer.add(goer);
        return true;
    }

    /**
     *
     * @param email
     * @return the Moviegoer with a specific email
     */
    public static MovieGoer read(String email){
        for(int i = 0; i < listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(email)){
                return listMovieGoer.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @param email
     * @return if a moviegoer existed by checking email
     */
    public static boolean checkExist(String email){
        for(int i = 0; i < listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param email
     * @return if could delete a moviegoer in the database with specific email
     */
    public static boolean delete(String email){
        for(int i = 0; i < listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(email)){
                listMovieGoer.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * update a moviegoer details
     * @param goer
     * @return
     */
    public static boolean update(MovieGoer goer){
        for(int i = 0; i < listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(goer.getEmail())){
                listMovieGoer.set(i, goer);
                return true;
            }
        }
        return false;
    }

    /**
     * add a rewardPoint to a Moviegoer point
     * @param earnedPoint
     * @param email
     */
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

    /**
     * display all moviegoers details
     */
    public static void displayAll(){
        for(int i = 0; i< listMovieGoer.size(); i++){
            output(listMovieGoer.get(i));
        }
    }

    /**
     * display moviegoer with specific email
     * @param Email
     */
    public static void displayByID(String Email){
        for(int i = 0; i< listMovieGoer.size(); i++){
            if(listMovieGoer.get(i).getEmail().equals(Email)){
                output(listMovieGoer.get(i));
                return;
            }
        }
    }

    /**
     * display a movie goer details
     * @param movieGoer
     */
    public static void output(MovieGoer movieGoer){
        System.out.println("Email: "+ movieGoer.getEmail());
        System.out.println("Name: " + movieGoer.getName());
        System.out.println("Age: "+ movieGoer.getAge());
        System.out.println("Mobile: "+ movieGoer.getMobile());
        System.out.println("Reward point: "+ movieGoer.getRewardPoint());
        System.out.print("\n");
    }
}