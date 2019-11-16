package View;

import controller.*;
import View.*;

import java.util.Scanner;

/**
 * Represents all related User console display
 * @author 
 */
public class UserView {
    private static Scanner sc = new Scanner(System.in);
    public static void view(){
        boolean stop = false;
        while (!stop){
            try{
                System.out.println("Please input your choice to continue: ");
                System.out.println("1. Book movie");
                System.out.println("2. View all movies");
                System.out.println("3. Check seat availability");
                System.out.println("4. Reviews");
                System.out.println("5. Ratings");
                System.out.println("6. Display top 5 Movie rank by Viewers: ");
                System.out.println("7. View history booking: ");
                System.out.println("8. Back");
                System.out.print("Your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case 1:
                        BookingView.view();;
                        break;
                    case 2:
                        MovieController.displayAll();;
                        break;
                    case 3:
                        AvailabilityView.view();
                        break;
                    case 4:
                        ReviewView.view();;
                        break;
                    case 5:
                        RatingView.view();;
                        break;
                    case 6:
                        MovieController.topFiveByRating();
                        break;
                    case 7:
                        HistoryView.view();;
                        break;
                    case 8:
                        stop = true;
                        break;
                    default:
                        System.out.println("Please enter valid choice!");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Exception > " + e.getMessage());
            }
        }
    }

}
