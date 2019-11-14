package moblima;
import controller.*;
import Interface.*;

import java.util.Scanner;

public class MOBLIMA{
    static Scanner sc = new Scanner(System.in);
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
                   UserInterface();
                    break;
                default:
                    System.out.println("Please enter valid choice!");
                    break;
            }
        }
        saveData();
    }

    public static void readData(){
        MovieController.readDB();
        MovieGoerController.readDB();
        CinemaController.readDB();
        CineplexController.readDB();
        SeatController.readDB();
        ShowtimeController.readDB();
        HistoryController.readDB();
        HolidayController.readDB();
    }

    public static void saveData(){
        MovieController.saveDB();
        MovieGoerController.saveDB();
        CinemaController.saveDB();
        CineplexController.saveDB();
        SeatController.saveDB();
        ShowtimeController.saveDB();
        HistoryController.saveDB();
        HolidayController.readDB();
    }
    public static void UserInterface(){
        boolean process = true;
        while (process){
            System.out.println("Welcome you to user regime!");
            System.out.println("1.For Rating");
            System.out.println("2.For Review");
            System.out.println("3.For Booking");
            System.out.println("4.For Food and Drink order");
            System.out.println("Enter your choice: ");
            char op = sc.next().charAt(0);
            switch (op){
                case '1':
                    RatingInterface.view();
                    break;
                case '2':
                    ReviewInterface.view();
                    break;
                case '3':
                    BookingInterface.view();
                    break;
                case '4':
                    ComboInterface.view();
                    break;
                default:
                    System.out.println("Please enter valid choice!");
                    break;
            }
        }
    }
}
