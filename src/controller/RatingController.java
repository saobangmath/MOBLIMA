package controller;

import database.MovieDB;
import database.RatingDB;
import model.Movie;
import model.Rating;

import java.util.ArrayList;

/**
 * Represents all operations related to Rating object
 * @author Tran Anh Tai
 */
public class RatingController {
    private static ArrayList RatingList, MovieList;

    /**
     * read all ratings, movies databases to RatingList and MovieList respectively for internal operations
     */
    public static void readDB(){
        RatingList = RatingDB.readData();
        MovieList = MovieDB.readData();
    }

    /**
     * saving back to Rating and Movie databases by overriding the databases files with RatingList and MovieList
     */
    public static void saveDB(){
        RatingDB.saveData(RatingList);
        MovieDB.saveData(MovieList);
    }

    /**
     * get overall rating of a movie ID
     * @param movieID
     * @return this movieID overall rating
     */
    public static float get(int movieID){
        for (int i = 0; i < MovieList.size(); i++){
            Movie movie = (Movie) MovieList.get(i);
            if (movie.getID() == movieID){
                return movie.getOverallRating();
            }
        }
        return -1;
    }

    /**
     * create a new rating
     * @param rate
     */
    public static void create(Rating rate){
        RatingList.add(rate); // TODO the real email is taken in the UserInterface
        update(rate.getMovieID(), rate.getRating());
        try{
            saveDB();
        }
        catch (Exception e){
            System.out.println("Exception > " + e.getMessage());
        }
        System.out.println("Your rating for the film is successfully added!");
    }

    /**
     * update overall rating of a movieID with a new rating added
     * @param movieID
     * @param new_rate
     */
    public static void update(int movieID, float new_rate){
        if (MovieController.checkExist(movieID)){
            ArrayList alw = new ArrayList();
            for (int i = 0; i < MovieList.size(); i++){
                Movie movie = (Movie)MovieList.get(i);
                if (movie.getID() == movieID){
                    int rating_count = 0;
                    for (int j = 0; j < RatingList.size();j++){
                        Rating rating = (Rating)RatingList.get(j);
                        if (rating.getMovieID() == movieID){
                            ++rating_count;
                        }
                    }
                    System.out.println(rating_count);
                    float updated_rating = ((rating_count - 1) * movie.getOverallRating() + new_rate) / (rating_count);
                    movie.setOverallRating(updated_rating);
                }
                alw.add(movie);
            }
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
                System.out.println("User: " + rating.getEmail() + " has rate the Movie with ID " + movieID + " with rating: " + rating.getRating());
            }
        }
        if (!existed){
            System.out.println("There is no Movie with such ID in the database!");
        }
    }
}
