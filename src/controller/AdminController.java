package controller;

import database.HistoryBookingDB;
import database.MovieDB;
import model.Admin;
import database.AdminDB;
import model.Booking;
import model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdminController {
    private static ArrayList<Admin> AdminList;
    private static ArrayList<Booking> BookingList;
    private static ArrayList MovieList;
    private static AdminDB db = new AdminDB();
    private static HistoryBookingDB histDB = new HistoryBookingDB();
    private static MovieDB movieDB = new MovieDB();
    private static MovieController movieController = new MovieController();

    public AdminController(){
        this.AdminList = db.readData();
        this.BookingList = histDB.readData();
        this.MovieList = movieDB.readData();
    }

    public static boolean IsAuthentication(String username, String password){
        boolean authenticate = false;
        for (int i = 0; i < AdminList.size(); i++){
            Admin ad = AdminList.get(i);
            if (username.equals(ad.getUsername()) && password.equals(ad.getPassword())){
                authenticate = true;
                break;
            }
        }
        if (!authenticate){
            System.out.println("You are not an admin yet! Please re-enter your choice");
        }
        return authenticate;
    }
    public static void AddMovie(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID: ");
        int movieID = sc.nextInt();
        if (checkExist(movieID)){
            System.out.println("The movieID have existed in the database!");
            return;
        }
        else{
            System.out.println("Name: ");
            String nameInput = sc.nextLine();
            sc.nextLine();

            System.out.println("Category: ");
            String category = sc.nextLine();
            sc.nextLine();

            System.out.println("Description: ");
            String description = sc.nextLine();
            sc.nextLine();

            System.out.println("Director: ");
            String director = sc.nextLine();
            sc.nextLine();

            System.out.println("Cast: ");
            String cast = sc.nextLine();
            sc.nextLine();

            System.out.println("Restriction: ");
            int restriction = sc.nextInt();

            System.out.println("Start date: ");
            String startDate = sc.next();

            System.out.println("End date: ");
            String endDate = sc.next();
            MovieList.add(new Movie(nameInput,
                                movieID, category,
                                description,
                                director,
                                cast,
                                restriction,
                                0,
                                startDate,
                                endDate
                                ));
            MovieDB.saveData(MovieList);
            System.out.println("The film added sucessfully!");
        }
    }

    private static boolean checkExist(int movieID) {
        for (int i = 0; i < MovieList.size(); i++){
            if (((Movie)MovieList.get(i)).getID() == movieID){
                return true;
            }
        }
        return false;
    }

    public static void TopFiveMovieRankByRatings(){
        Collections.sort(MovieList, new MovieController.SortByRating());
        int movieID = 0;
        while (movieID < Math.min(5, MovieList.size())){
            System.out.println("ID: "+ ((Movie)MovieList.get(movieID)).getID());
            System.out.println("Name: " + ((Movie)MovieList.get(movieID)).getName());
            System.out.println("Category: "+ ((Movie)MovieList.get(movieID)).getCategory() );
            System.out.println("Description: "+ ((Movie)MovieList.get(movieID)).getDescription() );
            System.out.println("Director: "+ ((Movie)MovieList.get(movieID)).getDirector() );
            System.out.println("Cast: "+ ((Movie)MovieList.get(movieID)).getCast() );
            System.out.println("Restriction: "+ ((Movie)MovieList.get(movieID)).getRestriction() );
            System.out.println("Overall Rating: "+ ((Movie)MovieList.get(movieID)).getOverallRating() );
            System.out.println("Start Date: "+ ((Movie)MovieList.get(movieID)).getStartDate());
            System.out.println("End Date: "+ ((Movie)MovieList.get(movieID)).getEndDate());
            System.out.println("\n");
             movieID++;
        }
    }
    public static void TopFiveMovieRankByTicketsSale(){

    }

    public void DeleteMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Movie ID: ");
        int movieID = sc.nextInt();
        for (int i = 0; i < MovieList.size(); i++){
            if (((Movie)MovieList.get(i)).getID() == movieID){
                MovieList.remove(i);
                MovieDB.saveData(MovieList);
                System.out.println("The film is successfully removed in the database!");
                return;
            }
        }
        System.out.println("The film is not existed in our database!");
    }
}
