package Interface;
import controller.MovieController;
import controller.ReviewController;

import java.util.Scanner;

public class ReviewInterface {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        MovieController.readDB();
        ReviewController.readDB();
        boolean stop = false;
        while(!stop){
            try{
                System.out.println();
                System.out.println("Please input your choice to continue: ");
                System.out.println("1. Add your own review for a Movie: ");
                System.out.println("2. View all reviews with a specific Movie: ");
                System.out.println("3. Exit");
                char choice = sc.next().charAt(0);
                switch (choice){
                    case '1':
                        AddReview();
                        break;
                    case '2':
                        RetrieveReview();
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
            MovieController.saveDB();
            ReviewController.saveDB();
        }
    }

    private static void RetrieveReview() {
        System.out.println("Enter Movie ID: ");
        int movieID = sc.nextInt();
        if (MovieController.checkExist(movieID)){
            ReviewController.RetrieveAllReview(movieID);
        }
        else{
            System.out.println("The movie ID is not existed in the database!");
        }
    }

    private static void AddReview() {
        System.out.println("Enter Movie ID: ");
        int movieID = sc.nextInt();
        if (MovieController.checkExist(movieID)){
            System.out.println("Enter your email: ");
            String email = sc.next();
            System.out.println("Enter your comment: ");
            String comment = sc.next();
            ReviewController.AddReview(email, movieID, comment);
        }
        else{
            System.out.println("The movie ID is not existed in the database!");
        }
    }
}
