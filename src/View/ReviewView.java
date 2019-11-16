package View;
import controller.MovieController;
import controller.ReviewController;
import model.Email;
import model.Review;

import java.util.Scanner;

/**
 * Represent all related Review console display
 * @author Tran Anh Tai
 */
public class ReviewView {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) { // local testing
        view();
    }

    /**
     * main interface for review
     */
    public static void view() {
        boolean stop = false;
        while(!stop){
            try{
                System.out.println();
                System.out.println("Please input your choice to continue: ");
                System.out.println("1. Add your own review for a Movie: ");
                System.out.println("2. View all reviews with a specific Movie: ");
                System.out.println("3. Back");
                char choice = sc.next().charAt(0);
                switch (choice){
                    case '1':
                        addReview();
                        break;
                    case '2':
                        displayReview();
                        break;
                    case '3':
                        stop = true;
                        break;
                    default:
                        System.out.println("Please enter a valid choice!");
                        break;
                }
            }
            catch (Exception e){
                System.out.println("Please enter a valid choice!");
            }
        }
    }

    /**
     * display all reviews for a movie ID
     */
    private static void displayReview() {
        MovieController.displayAll();
        System.out.println("Enter Movie ID: ");
        int movieID = sc.nextInt();
        sc.nextLine();
        if (MovieController.checkExist(movieID)){
            ReviewController.display(movieID);
        }
        else{
            System.out.println("The movie ID is not existed in the database!");
        }
    }

    /**
     * create new review for a movieID
     */
    private static void addReview() {
        MovieController.displayAll();
        System.out.println("Enter Movie ID: ");
        int movieID = sc.nextInt();
        sc.nextLine();
        if (MovieController.checkExist(movieID)){
            System.out.println("Enter your email: ");
            String email = sc.nextLine();
            if (Email.validateEmail(email)){
                System.out.println("Enter your comment: ");
                String comment = sc.next();
                Review review = new Review(movieID, email, comment);
                ReviewController.create(review);
            }
            else{
                System.out.println("Your email is in invalid format!");
            }
        }
        else{
            System.out.println("The movie ID is not existed in the database!");
        }
    }
}
