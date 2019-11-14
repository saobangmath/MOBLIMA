package Interface;

import controller.ComboController;
import controller.HistoryController;
import controller.MovieController;
import database.HistoryDB;
import model.*;
import controller.AdminController;

import javax.management.openmbean.InvalidKeyException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents all related Admin console display
 * @author Tran Anh Tai
 */
public class AdminInterface {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        view();
    }

    /**
     * admin main interface
     */
    public static void view(){
        AdminController.readDB();
        MovieController.readDB();
        HistoryController.readDB();
        ComboController.readDB();

        boolean stop = false;
        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();
        if (AdminController.isAuthenticate(username, password)){
            while (!stop){
                try{
                    System.out.println("Please input your choice to continue: ");
                    System.out.println("1. Add new Movie");
                    System.out.println("2. Delete existing Movie");
                    System.out.println("3. DisPlay top 5 Movie rank by Ratings: ");
                    System.out.println("4. Display top 5 Movie rank by Viewers: ");
                    System.out.println("5. View history booking: ");
                    System.out.println("6. View all food and drink transactions: ");
                    System.out.println("7. Exit");
                    System.out.print("Your choice: ");
                    char choice = sc.next().charAt(0);
                    switch (choice){
                        case '1':
                            createMovie();
                            break;
                        case '2':
                            deleteMovie();
                            break;
                        case '3':
                            topFiveByRating();
                            break;
                        case '4':
                            topFiveByTicket();
                            break;
                        case '5':
                            viewHistory();
                            break;
                        case '6':
                            viewFDOrder();
                            break;
                        case '7':
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
        HistoryController.saveDB();
        ComboController.saveDB();
    }

    /**
     * creating new movie
     */
    public static void createMovie(){
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

            Movie movie = new Movie(nameInput, movieID, category,
                    description, director, cast, restriction,0,
                    startDate, endDate, previewDate, duration);

            AdminController.addMovie(movie);
        }
        else{
            System.out.println("The movie is existed in the database!");
        }
    }

    /**
     * deleting movie
     */
    public static void deleteMovie(){
        System.out.println("Enter movie ID to delete: ");
        int movieID = sc.nextInt();
        AdminController.deleteMovie(movieID);
    }

    /**
     * display top 5 movie by rating
     */
    public static void topFiveByRating(){
        AdminController.topFiveByRating();
    }

    /**
     * display top 5 movies by tickets sales
     */
    public static void topFiveByTicket(){

        AdminController.topFiveByTicket();
    }

    /**
     * view all history booking transactions details
     */
    public static void viewHistory(){
        ArrayList<History> histories = HistoryDB.readData();
        for (History history : histories){
            System.out.println("User: " + history.getEmail() +
                               " has booked: " + history.getNoTicket() +
                               " tickets for the Movie with ID: " + history.getID() +
                               " on: " + history.getTransactionDate() +
                               " at: " + history.getTransactionTime() );

        }
        System.out.println();
    }

    /**
     * view all food and drink order of all users
     */
    private static void viewFDOrder() {
        ComboController.displayAll();
    }
}
