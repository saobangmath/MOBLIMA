package Interface;

import controller.*;
import Interface.*;

import java.util.Scanner;

/**
 * Represents all related User console display
 * @author Phung Minh Khanh
 */
public class UserInterface {
    private static Scanner sc = new Scanner(System.in);

    /**
     * main interface for the viewers
     */
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
                        BookingInterface.view();
                        break;
                    case 2:
                        MovieController.displayAll();
                        break;
                    case 3:
                        AvailabilityInterface.view();
                        break;
                    case 4:
                        ReviewInterface.view();
                        break;
                    case 5:
                        RatingInterface.view();
                        break;
                    case 6:
                        MovieController.topFiveByTicket();
                        break;
                    case 7:
                        HistoryInterface.view();
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