package Interface;

import controller.MovieController;
import controller.RatingController;
import model.Email;
import model.Rating;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents all related Rating console display
 * @author Tran Anh Tai
 */
public class RatingInterface {
    static Scanner sc =  new Scanner(System.in);

    public static void main(String[] args) { //local testing
        view();
    }

    /**
     * main interface for rating
     */
    public static void view() {
        MovieController.readDB();
        RatingController.readDB();
        boolean stop =  false;
        while (!stop){
            try{
                System.out.println();
                System.out.println("Please input your choice to continue: ");
                System.out.println("1. Add your own rating (0 - 5):");
                System.out.println("2. View all ratings with a specific Movie: ");
                System.out.println("3. View average rating for a Movie: ");
                System.out.println("4. Exit");
                System.out.println("Enter your choice: ");
                char choice = sc.next().charAt(0);
                switch (choice){
                    case '1':
                        create();
                        break;
                    case '2':
                        display();
                        break;
                    case '3':
                        display_overall_rating();
                        break;
                    case '4':
                        stop = true;
                        break;
                    default:
                        System.out.println("Please enter a valid choice!");
                        break;
                }
            }
            catch (Exception e){
                System.out.println("Please enter a valid rating!");
            }
        }
        MovieController.saveDB();
        RatingController.saveDB();
    }

    /**
     * create new rating
     */
    public static void create(){
        System.out.println("Enter the Movie ID: ");
        int movieID = sc.nextInt();
        if (MovieController.checkExist(movieID)){
            System.out.println("Enter your email: ");
            String email = sc.next();
            if (Email.validateEmail(email)){
                System.out.println("Enter your rating: ");
                String rating = sc.next();
                try{
                    float rating_value = Float.parseFloat(rating);
                    if (rating_value > 0 && rating_value <= 5){
                        Rating rate = new Rating(movieID, email, rating_value);
                        RatingController.create(rate);
                    }
                    else{
                        System.out.println("Rating should be between (0, 5)!");
                    }
                }
                catch (InputMismatchException e){
                    System.out.println("Please enter valid input!");
                }
            }
            else{
                System.out.println("The email input is not legal!");
            }
        }
        else{
            System.out.println("The Movie is not existed in the database!");
        }
    }

    /**
     * display all ratings for movieID
     */
    private static void display() {
        System.out.println("Enter the Movie ID: ");
        int movieID = sc.nextInt();
        if (MovieController.checkExist(movieID)){
            RatingController.display(movieID);
        }
        else{
            System.out.println("The Movie is not existed in the database!");
        }
    }

    /**
     * display overall rating for a movieID
     */
    private static void display_overall_rating() {
        System.out.println("Enter the Movie ID: ");
        int movieID = sc.nextInt();
        float average = RatingController.get(movieID);
        if (average == -1){
            System.out.println("There is no rating for the Movie yet!");
        }
        else{
            System.out.println("Average rating for the Movie with movieID : " + movieID + " is: " + average);
        }
    }
}
