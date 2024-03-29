package View;

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
public class RatingView {
    static Scanner sc =  new Scanner(System.in);

    /**
     * main View for displaying all Rating related operations
     */
    public static void view() {
        boolean stop =  false;
        while (!stop){
            try{
                System.out.println();
                System.out.println("Please input your choice to continue: ");
                System.out.println("1. Add your own rating (0 - 5):");
                System.out.println("2. View all ratings with a specific Movie: ");
                System.out.println("3. View average rating for a Movie: ");
                System.out.println("4. Back");
                System.out.println("Enter your choice: ");
                char choice = sc.nextLine().charAt(0);
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
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid rating!");
            }
        }
    }

    /**
     * create a new rating
     */
    public static void create(){
        MovieController.displayAll();
        System.out.println("Enter the Movie ID: ");
        int movieID = sc.nextInt();
        sc.nextLine();
        if (MovieController.checkExist(movieID)){
            System.out.println("Enter your email: ");
            String email = sc.nextLine();
            if (Email.validateEmail(email)){
                System.out.println("Enter your rating: ");
                String rating = sc.nextLine();
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
        MovieController.displayAll();
        System.out.println("Enter the Movie ID: ");
        int movieID = sc.nextInt();
        sc.nextLine();
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
        MovieController.displayAll();
        System.out.println("Enter the Movie ID: ");
        int movieID = sc.nextInt();
        sc.nextLine();
        float average = RatingController.get(movieID);
        if (average == -1){
            System.out.println("There is no rating for the Movie yet!");
        }
        else{
            System.out.println("Average rating for movie : " + MovieController.read(movieID).getName() + " is: " + average);
        }
    }
}
