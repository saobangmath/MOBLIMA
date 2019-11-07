package Interface;

import controller.BookingController;
import model.*;
import controller.AdminController;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminInterface {
    public static void main(String[] args) {
        boolean stop = false;
        AdminController adminController = new AdminController();
        Scanner sc = new Scanner(System.in);
        // authentication
        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();
        if (adminController.IsAuthentication(username, password)){
            while (!stop){
                try{
                    System.out.println("Please input your choice to continue: ");
                    System.out.println("1. System Configuration");
                    System.out.println("2. DisPlay top 5 movie rank by Ratings: ");
                    System.out.println("3. Display top 5 movie rank by Viewers: ");
                    System.out.println("4. View history booking: ");
                    System.out.println("5. Exit");
                    System.out.print("Your choice: ");
                    int choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            adminController.AddMovie();
                            break;
                        case 2:
                            adminController.TopFiveMovieRankByRatings();
                            break;
                        case 3:
                            adminController.TopFiveMovieRankByTicketsSale();
                            break;
                        case 4:
                            ViewHistoryBooking();
                            break;
                        case 5:
                            stop = true;
                            break;
                        default:
                            System.out.println("Please enter valid choice!");
                    }
                }
                catch(Exception e){
                    System.out.println("Please enter valid choice");
                    sc.nextLine(); // flush the nextline character!
                }
            }
        }
    }

    public static void ViewHistoryBooking(){
        BookingController bookingController = new BookingController();
        ArrayList<Booking> BookingList = bookingController.getAllBooking();
        for (int i = 0; i < BookingList.size(); i++){
            Booking booking = BookingList.get(i);
            System.out.println(" User: " + booking.getUserEmail()
                    + " has booked movieID " + booking.getMovieID()
                    + " at cinelex: " + booking.getCinelexID()
                    + " on: " + booking.getDate());
        }
    }
}
