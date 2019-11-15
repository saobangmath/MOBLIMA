package controller;

import database.ReviewDB;
import model.Review;

import java.util.ArrayList;

/**
 * Represents all operations related to the Review object
 * @author Tran Anh Tai
 */
public class ReviewController{
    private static ArrayList ReviewList;

    /**
     * store the review database to a ReviewList for internal operations
     */
    public static void readDB() {
        ReviewList = ReviewDB.readData();
    }

    /**
     * save back to the Review database with a ReviewList overriding such database file
     */
    public static void saveDB(){
        ReviewDB.saveData(ReviewList);
    }

    /**
     * create a new review
     * @param review
     */
    public static void create(Review review){
        ReviewList.add(review);
        ReviewDB.saveData(ReviewList);
        System.out.println("Thanks for your kind review!");
    }

    /**
     * display all review details for a movieID
     * @param movieID
     */
    public static void display(int movieID){
        boolean existed = false;
        for (int i = 0; i < ReviewList.size(); i++){
            Review review = (Review) ReviewList.get(i);
            if (review.getMovieID() == movieID){
                System.out.println("User " + review.getEmail() + " has review:" + review.getComment() + " for the Movie "+ MovieController.read(review.getMovieID()).getName());
                existed = true;
            }
        }
        if (!existed){
            System.out.println("The movieID has not received any reviews!");
        }
    }
}
