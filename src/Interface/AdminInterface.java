package Interface;

import controller.BookingController;
import controller.MovieController;
import model.*;
import controller.AdminController;

import javax.management.openmbean.InvalidKeyException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminInterface {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        AdminController.readDB();
        MovieController.readDB();
        boolean stop = false;
        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();
        if (AdminController.IsAuthentication(username, password)){
            while (!stop){
                try{
                    System.out.println("Please input your choice to continue: ");
                    System.out.println("1. Add new Movie");
                    System.out.println("2. Delete existing Movie");
                    System.out.println("3. DisPlay top 5 Movie rank by Ratings: ");
                    System.out.println("4. Display top 5 Movie rank by Viewers: ");
                    System.out.println("5. View history booking: ");
                    System.out.println("6. Exit");
                    System.out.print("Your choice: ");
                    char choice = sc.next().charAt(0);
                    switch (choice){
                        case '1':
                            AddMovie();
                            break;
                        case '2':
                            DeleteMovie();
                            break;
                        case '3':
                            TopFiveMovieRankByRatings();
                            break;
                        case '4':
                            TopFiveMovieRankByTicketsSale();
                            break;
                        case '5':
                            ViewHistoryBooking();
                            break;
                        case '6':
                            stop = true;
                            break;
                        default:
                            System.out.println("Please enter valid choice!");
                    }
                }
                catch(Exception e){
                    System.out.println("Exception > " + e.getMessage());
                    sc.nextLine(); // flush the nextline character!
                }
            }
        }
        MovieController.saveDB();
        AdminController.saveDB();
    }

    public static void AddMovie(){
        System.out.println("Please enter movie ID: ");
        int movieID = sc.nextInt();
        if (!MovieController.checkExist(movieID)){
            System.out.println("Name: ");
            String nameInput = sc.next();

            System.out.println("Category: ");
            String category = sc.next();

            System.out.println("Description: ");
            String description = sc.next();

            System.out.println("Director: ");
            String director = sc.next();

            System.out.println("Cast: ");
            String cast = sc.next();

            System.out.println("Restriction: ");
            int restriction = sc.nextInt();

            System.out.println("Start date (dd/MM/yyyy): ");
            String startDate = sc.next();
            if(!Movie.validateDate(startDate)){
                throw new InvalidKeyException("Invalid date input (dd/MM/yyyy)");
            }
            System.out.print("\n");

            System.out.print("End date (dd/MM/yyyy): ");
            String endDate = sc.next();
            if(!Movie.validateDate(endDate)){
                throw new InvalidKeyException("Invalid date input (dd/MM/yyyy)");
            }
            System.out.print("\n");

            System.out.print("Preview date (dd/MM/yyyy): ");
            String previewDate = sc.next();
            if(!Movie.validateDate(previewDate)){
                throw new InvalidKeyException("Invalid date input (dd/MM/yyyy)");
            }
            System.out.print("\n");

            System.out.println("Duration: ");
            int duration = sc.nextInt();
            System.out.println("\n");

            AdminController.AddMovie(nameInput, movieID, category, description, director, cast, restriction, startDate, endDate, previewDate, duration);
        }
        else{
            System.out.println("The movie is existed in the database!");
        }
    }

    public static void DeleteMovie(){
        System.out.println("Enter movie ID to delete: ");
        int movieID = sc.nextInt();
        AdminController.DeleteMovie(movieID);
    }

    public static void TopFiveMovieRankByRatings(){
        AdminController.TopFiveMovieRankByRatings();
    }

    public static void TopFiveMovieRankByTicketsSale(){

        AdminController.TopFiveMovieRankByTicketsSale();
    }

    public static void ViewHistoryBooking(){
        ArrayList<Booking> BookingList = BookingController.getAllBooking();
        for (int i = 0; i < BookingList.size(); i++){
            Booking booking = BookingList.get(i);
            System.out.println(" User: " + booking.getUserEmail()
                    + " has booked movieID " + booking.getMovieID()
                    + " at cinelex: " + booking.getCinelexID()
                    + " on: " + booking.getDate());
        }
    }
}
