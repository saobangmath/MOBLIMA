package controller;

import database.RatingDB;
import controller.MovieController;
import model.Movie;
import model.Rating;

import java.util.ArrayList;

/**
 * Represents all operations related to Rating object
 * @author Tran Anh Tai
 */
public class RatingController {
    private static ArrayList RatingList;

    /**
     * read all ratings, movies databases to RatingList for internal operations
     */
    public static void readDB(){
        RatingList = RatingDB.readData();
    }

    /**
     * saving back to Rating and Movie databases by overriding the databases files with RatingList and MovieList
     */
    public static void saveDB(){
        RatingDB.saveData(RatingList);
    }

    /**
     * get overall rating of a movie ID
     * @param movieID
     * @return this movieID overall rating
     */
    public static float get(int movieID){
        if(MovieController.checkExist(movieID)){
            return MovieController.read(movieID).getOverallRating();
        }
        return -1;
    }

    /**
     * create a new rating
     * @param rate
     */
    public static void create(Rating rate){
        RatingList.add(rate); // TODO the real email is taken in the UserInterface
        updateOverallRating(rate.getMovieID(), rate.getRating());
        System.out.println("Your rating for the film is successfully added!");
    }

    /**
     * update overall rating of a movieID with a new rating added
     * @param movieID
     * @param new_rate
     */
    public static void updateOverallRating(int movieID, float new_rate){
        if (MovieController.checkExist(movieID)){
            Movie movie = MovieController.read(movieID);
            float ratingSum = 0;
            float rating_count = 0;
            for (int j = 0; j < RatingList.size();j++){
                Rating rating = (Rating)RatingList.get(j);
                if (rating.getMovieID() == movieID){
                    ratingSum += rating.getRating();
                    rating_count ++;
                }
            }
            float updated_rating = (ratingSum) / (rating_count);
            updated_rating = Math.round(updated_rating * 10f) / 10f;
            System.out.println(updated_rating);
            movie.setOverallRating(updated_rating);
        }
        else{
            System.out.println("The Movie is not existed in the database!");
        }
    }

    /**
     * display all rating details for a movie ID
     * @param movieID
     */
    public static void display(int movieID){
        boolean existed = false;
        for (int i = 0; i < RatingList.size(); i++){
            Rating rating = (Rating)RatingList.get(i);
            if (rating.getMovieID() == movieID){
                existed = true;
                System.out.println("User " + rating.getEmail() + " has rate the Movie " + MovieController.read(movieID).getName() 
                                    + " with rating: " + rating.getRating());
            }
        }
        if (!existed){
            System.out.println("There is no rating for this movie!");
        }
    }
}
