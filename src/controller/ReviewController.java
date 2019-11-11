package controller;

import database.ReviewDB;
import model.Review;

import java.util.ArrayList;
import java.util.Scanner;

public class ReviewController{
    private static ReviewDB db = new ReviewDB();
    private static ArrayList ReviewList;
    private static Scanner sc = new Scanner(System.in);
    private static MovieController movieController = new MovieController();

    public ReviewController(){
        ReviewList = db.readData();
        movieController.readDB();
    }

    public static void AddReview(String email){
        System.out.println("Please enter the movie ID: ");
        int movieID = sc.nextInt();
        if (movieController.checkExist(movieID)){
            System.out.println("Please enter your own review: ");
            String comment = sc.next();
            Review review = new Review(movieID, email,comment);
            ReviewList.add(review);
            db.saveData(ReviewList);
            System.out.println("Thanks for your kind review!");
        }
        else{
            System.out.println("The movie ID is not existed in the database!");
        }
    }

    public static void RetrieveAllReview(){
        System.out.println("Please enter the movie ID: ");
        int movieID = sc.nextInt();
        boolean existed = false;
        if (movieController.checkExist(movieID)){
            for (int i = 0; i < ReviewList.size(); i++){
                Review review = (Review) ReviewList.get(i);
                if (review.getMovieID() == movieID){
                    System.out.println("User: " + review.getEmail() + " has review: " + review.getComment() + " for the movie with ID: "+ review.getMovieID());
                    existed = true;
                }
            }
            if (!existed){
                System.out.println("The movieID has not revieved any reviews!");
            }
        }
        else{
            System.out.println("The movie ID is not exist in the database!");
        }
    }
}
