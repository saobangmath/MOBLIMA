package controller;

import database.RatingDB;
import model.Rating;

import java.util.ArrayList;
import java.util.Scanner;

public class RatingController {
    private static RatingDB db = new RatingDB();
    private static Scanner sc = new Scanner(System.in);
    public static MovieController movieController = new MovieController();
    private static ArrayList RatingList;

    public RatingController(){
        RatingList = db.readData();
        movieController.readDB();
    }

    public static void getAverageRatingByID(){
        System.out.println("Enter the MovieID: ");
        int MovieID = sc.nextInt();
        int count = 0;
        float total = 0;
        for (int i = 0; i < RatingList.size(); i++){
            Rating MovieRating = (Rating) RatingList.get(i);
            if (MovieRating.getMovieID() == MovieID){
                count ++;
                total = total + MovieRating.getRating();
            }
        }
        float average = (count != 0) ? (total / count) : - 1;
        if (total != 0){
            System.out.println("Movie with MovieID: " + MovieID + " has average rating equals to: " + average);
        }
        else{
            System.out.println("This Movie has no feedback previously!");
        }
    }

    public static void AddRating(){
        System.out.println("Enter the MovieID: ");
        int MovieID = sc.nextInt();
        if (movieController.checkExist(MovieID)){
            System.out.println("Enter your own rating: ");
            float rating = sc.nextFloat();
            RatingList.add(new Rating(MovieID, "dshdjsd@gmail.com", rating)); // TODO the real email is taken in the UserInterface
            try{
                db.saveData(RatingList);
            }
            catch (Exception e){
                System.out.println("Exception > " + e.getMessage());
            }
            System.out.println("Your rating for the film is successfully added!");
        }
        else{
            System.out.println("There is no movie with such ID in the database!");
        }
    }

    public static void ViewMovieRatingByID(){
        System.out.println("Enter the MovieID: ");
        int MovieID = sc.nextInt();
        boolean existed = false;
        for (int i = 0; i < RatingList.size(); i++){
            Rating rating = (Rating)RatingList.get(i);
            if (rating.getMovieID() == MovieID){
                existed = true;
                System.out.println("User: " + rating.getEmail() + " has rate the Movie with ID " + MovieID + " with rating: " + rating.getRating());
            }
        }
        if (!existed){
            System.out.println("There is no movie with such ID in the database!");
        }
    }
}
