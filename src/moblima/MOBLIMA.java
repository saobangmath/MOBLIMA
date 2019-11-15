package moblima;
import controller.*;
import Interface.*;

import java.util.Scanner;

/**
 * @author Phung Minh Khanh
 */
public class MOBLIMA{
    static Scanner sc = new Scanner(System.in);

    /**
     * main interface to run the program
     * @param args
     */
    public static void main(String[] args) {
        readData();
        //AvailabilityInterface.view();
        boolean process = true;
        while(process){
            System.out.println("Welcome to MOBLIMA!");
            System.out.println("1.Admin");
            System.out.println("2.Moviegoer");
            System.out.println("Enter your choice: ");
            char choice = sc.next().charAt(0);
            switch (choice){
                case '1':
                    AdminInterface.view();
                    break;
                case '2':
                   UserInterface.view();
                    break;
                default:
                    System.out.println("Please enter valid choice!");
                    break;
            }
        }
        saveData();
    }

    /**
     * read all database
     */
    public static void readData(){
        AdminController.readDB();
        RatingController.readDB();
        ComboController.readDB();
        ReviewController.readDB();
        MovieController.readDB();
        MovieGoerController.readDB();
        CinemaController.readDB();
        CineplexController.readDB();
        SeatController.readDB();
        ShowtimeController.readDB();
        HistoryController.readDB();
        HolidayController.readDB();
    }

    /**
     * save back to all database
     */
    public static void saveData(){
        AdminController.saveDB();
        ReviewController.saveDB();
        ComboController.saveDB();
        RatingController.saveDB();
        MovieController.saveDB();
        MovieGoerController.saveDB();
        CinemaController.saveDB();
        CineplexController.saveDB();
        SeatController.saveDB();
        ShowtimeController.saveDB();
        HistoryController.saveDB();
        HolidayController.saveDB();
    }
}
