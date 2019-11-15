package Interface;

import controller.*;
import Interface.*;

import javax.management.openmbean.InvalidKeyException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents all related Admin console display
 * @author Tran Anh Tai
 */
public class AdminInterface {
    private static Scanner sc = new Scanner(System.in);

    /**
     * main interface
     */
    public static void view(){
        boolean stop = false;
        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();
        if (AdminController.isAuthenticate(username, password)){
            while (!stop){
                try{
                    System.out.println("Please input your choice to continue: ");
                    System.out.println("1. Movie configuration");
                    System.out.println("2. Cineplex configuration");
                    System.out.println("3. Cinema configuration");
                    System.out.println("4. Showtime configuration");
                    System.out.println("5. Holiday configuration");
                    System.out.println("6. Display top 5 movies by rating ");
                    System.out.println("7. Display top 5 movies by ticket");
                    System.out.println("8. Back");
                    System.out.print("Your choice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice){
                        case 1:
                            MovieInterface.view();;
                            break;
                        case 2:
                            CineplexInterface.view();
                            break;
                        case 3:
                            CinemaInterface.view();
                            break;
                        case 4:
                            ShowtimeInterface.view();;
                            break;
                        case 5:
                            HolidayInterface.view();;
                            break;
                        case 6:
                            MovieController.topFiveByRating();;
                            break;
                        case 7:
                            MovieController.topFiveByTicket();;
                            break;
                        case 8:
                            stop = true;
                            break;
                        default:
                            System.out.println("Please enter valid choice!");
                    }
                }
                catch(Exception e){
                    System.out.println("Exception > " + e.getMessage());
                }
            }
        }
    }

}