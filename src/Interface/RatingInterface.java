package Interface;

import controller.MovieController;
import controller.RatingController;
import model.Email;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RatingInterface {
    static Scanner sc =  new Scanner(System.in);
    public static void main(String[] args) {
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
                        CreateRating();
                        break;
                    case '2':
                        ViewRating();
                        break;
                    case '3':
                        GetOverallRating();
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


    public static void CreateRating(){
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
                        RatingController.CreateRating(movieID, rating_value, email);
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

    private static void ViewRating() {
        System.out.println("Enter the Movie ID: ");
        int movieID = sc.nextInt();
        if (MovieController.checkExist(movieID)){
            RatingController.DisplayRating(movieID);
        }
        else{
            System.out.println("The Movie is not existed in the database!");
        }
    }

    private static void GetOverallRating() {
        System.out.println("Enter the Movie ID: ");
        int movieID = sc.nextInt();
        float average = RatingController.GetOverall(movieID);
        if (average == -1){
            System.out.println("There is no rating for the Movie yet!");
        }
        else{
            System.out.println("Average rating for the Movie with movieID : " + movieID + " is: " + average);
        }
    }
}
