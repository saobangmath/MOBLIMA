package Interface;

import model.Admin;
import model.Cinema;
import model.Cineplex;
import model.Movie;
import controller.AdminController;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminInterface {
    public static void main(String[] args) {
        Initialization();
        boolean stop = false;
        AdminController adminController = new AdminController();
        DisplayInterface displayInterface = new DisplayInterface();
        Scanner sc = new Scanner(System.in);
        // authentication
        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();
        if (adminController.IsAuthentication(username, password)){
            while (!stop){
                try{
                    displayInterface.AdminInstructionDisplay();
                    int choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            adminController.SystemConfiguration();
                            break;
                        case 2:
                            adminController.DisplayTopFiveMovieRankByRatings();
                            break;
                        case 3:
                            adminController.DisplayTopFiveMovieRankByTicketsSale();
                            break;
                        case 4:
                            adminController.ViewHistoryBooking();
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

    // database set up
    private static void Initialization() {
        // admin set up
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(new Admin("Tran Anh Tai", "tai123", "Tai", "tai@gmail.com"));
        admins.add(new Admin("Phung Minh Khanh", "khanh123", "Khanh", "khanh@gmail.com"));
        admins.add(new Admin("Rich", "rich123", "Rich","rich@gmail.com"));
        admins.add(new Admin("Ryan", "ryan123", "Ryan", "ryan@gmail.com"));
        // cineplex set up - up to 3 for testing
        ArrayList<Cineplex> cineplexes = new ArrayList<>();
        cineplexes.add(new Cineplex(1, "X", new ArrayList<Cinema>()));
        cineplexes.add(new Cineplex(2, "Y", new ArrayList<Cinema>()));
        cineplexes.add(new Cineplex(3, "Z", new ArrayList<Cinema>()));
        // adding movie for testing
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Film A", "desc", "A"));
        movies.add(new Movie(2, "Film B", "desc", "B"));
        movies.add(new Movie(3, "Film C", "desc", "C"));
        movies.add(new Movie(4, "Film D", "desc", "D"));
        // set up admins database
        try{
            FileOutputStream fileout = new FileOutputStream("admin.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(admins);
            out.close();
        }
        catch (IOException e){
            System.out.println("Set up Admin database Error!");
        }
        // set up cineplexes database
        try{
            FileOutputStream fileout = new FileOutputStream("cineplexes.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(cineplexes);
            out.close();
        }
        catch (IOException e){
            System.out.println("Set up Cineplexes database Error!");
        }
        // set up movies database
        try{
            FileOutputStream fileout = new FileOutputStream("movies.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(movies);
            out.close();
        }
        catch (IOException e){
            System.out.println("Set up Movie database Error!");
        }
    }
}
