package controller;

import database.MovieDB;
import database.RatingDB;
import model.Movie;
import model.Rating;

import java.util.ArrayList;

public class RatingController {
    private static ArrayList RatingList, MovieList;

    public static void readDB(){
        RatingList = RatingDB.readData();
        MovieList = MovieDB.readData();
    }

    public static void saveDB(){
        RatingDB.saveData(RatingList);
        MovieDB.saveData(MovieList);
    }

    public static float GetOverall(int movieID){
        for (int i = 0; i < MovieList.size(); i++){
            Movie movie = (Movie) MovieList.get(i);
            if (movie.getID() == movieID){
                return movie.getOverallRating();
            }
        }
        return -1;
    }

    public static void CreateRating(int movieID, float rating, String email){
        RatingList.add(new Rating(movieID, email, rating)); // TODO the real email is taken in the UserInterface
        UpdateOverallRating(movieID, rating);
        try{
            saveDB();
        }
        catch (Exception e){
            System.out.println("Exception > " + e.getMessage());
        }
        System.out.println("Your rating for the film is successfully added!");
    }


    public static void UpdateOverallRating(int movieID, float new_rate){
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
    public static void DisplayRating(int movieID){
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
