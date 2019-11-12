package controller;

import database.ReviewDB;
import model.Review;

import java.util.ArrayList;

public class ReviewController{
    private static ArrayList ReviewList;

    public static void readDB() {
        ReviewList = ReviewDB.readData();
    }

    public static void saveDB(){
        ReviewDB.saveData(ReviewList);
    }

    public static void AddReview(String email, int movieID, String comment){
        Review review = new Review(movieID, email,comment);
        ReviewList.add(review);
        ReviewDB.saveData(ReviewList);
        System.out.println("Thanks for your kind review!");
    }

    public static void RetrieveAllReview(int movieID){
        boolean existed = false;
        for (int i = 0; i < ReviewList.size(); i++){
            Review review = (Review) ReviewList.get(i);
            if (review.getMovieID() == movieID){
                System.out.println("User: " + review.getEmail() + " has review: " + review.getComment() + " for the Movie with ID: "+ review.getMovieID());
                existed = true;
            }
        }
        if (!existed){
            System.out.println("The movieID has not received any reviews!");
        }
    }
}
