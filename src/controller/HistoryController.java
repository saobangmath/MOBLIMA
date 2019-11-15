package controller;
import java.util.ArrayList;
import database.HistoryDB;
import model.*;
import controller.*;

/**
 * contains all operations related to the History movie Booking
 * @author Phung Minh Khanh
 */
public class HistoryController{

    private static ArrayList<History> listHistory = new ArrayList<History>();

    /**
     * retrieve all History in the database, then put it in an internal ArrayList
     */
    public static void readDB(){
        listHistory = HistoryDB.readData();
    }

    /**
     *save back the listHistory Arraylist to the History text file
     */
    public static void saveDB(){
        HistoryDB.saveData(listHistory);
    }

    /**
     * create a new history in the database if not existed
     * @param History
     * @return a boolean
     */
    public static boolean create(History History){
        if(checkExist(History.getID())){
            return false;
        }
        listHistory.add(History);
        return true;
    }

    /**
     *
     * @param ID
     * @return a history object with specific ID
     */
    public static History read(int ID){
        for(int i = 0; i < listHistory.size(); i++){
            if(listHistory.get(i).getID() == ID){
                return listHistory.get(i);
            }
        }
        return null;
    }

    /**
     * check if a history with specific ID existed in the Database
     * @param ID
     * @return a boolean
     */
    public static boolean checkExist(double ID){
        for(int i = 0; i < listHistory.size(); i++){
            if(listHistory.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

    /**
     * delete a historu booking with specific ID
     * @param ID
     * @return
     */
    public static boolean delete(int ID){
        for(int i = 0; i < listHistory.size(); i++){
            if(listHistory.get(i).getID() == ID){
                listHistory.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * update the detail of a history booking
     * @param History
     * @return
     */
    public static boolean update(History History){
        for(int i = 0; i < listHistory.size(); i++){
            if(listHistory.get(i).getID() == History.getID()){
                listHistory.set(i, History);
                return true;
            }
        }
        return false;
    }

    /**
     *display all history booking
     */
    public static void displayAll(){
        for(int i = 0; i< listHistory.size(); i++){
            output(listHistory.get(i));
        }
    }

    /**
     * display all history booking of a  user with specific email
     * @param email
     */
    public static void displayByEmail(String email){
        int exist = 0;
        for(int i = 0; i< listHistory.size(); i++){
            if(listHistory.get(i).getEmail().equals(email)){
                output(listHistory.get(i));
                exist = 1;
            }
        }
        if(exist == 0){
            System.out.println("You haven't done any bookings before");
        }

    }

    /**
     * print out the detail of  a history booking
     * @param history
     */
    public static void output(History history){
        Showtime showtime = ShowtimeController.read(history.getShowtimeId());
        Movie movie = MovieController.read(showtime.getMovieId());
        Cinema cinema = CinemaController.read(showtime.getCinemaId());
        Cineplex cineplex = CineplexController.read(showtime.getCineplexId());
        Combo combo = ComboController.read(history.getID());
        String seatDisplay = "";
        for(int j = 0; j < history.getSeatCol().size(); j ++){
            seatDisplay = seatDisplay + String.valueOf(history.getSeatRow().get(j)) + String.valueOf(history.getSeatCol().get(j)) + " ";
        }
        System.out.println("Email: " + history.getEmail());
        System.out.println("Movie: "+ movie.getName());
        System.out.println("Start time: " + showtime.getStartTime());
        System.out.println("End time: " + showtime.getEndTime());
        System.out.println("Cinema: " + cinema.getName());
        System.out.println("Cineplex: " + cineplex.getName());
        System.out.println("Seat: "+ seatDisplay);
        System.out.println("No ticket: " + history.getNoTicket());
        System.out.println("Popcorn: " + combo.getPopcorn());
        System.out.println("Drink: " + combo.getDrink());
        System.out.println("Price: " + history.getPrice());
        System.out.println("Transaction time: " + history.getTransactionTime());
        System.out.println("Transaction date: " + history.getTransactionDate());
        System.out.println("Transaction ID: " + String.valueOf(history.getID()));
        System.out.print("\n");
    }

    /**
     *
     * @param movieID
     * @return total number of tickets have sold for a Movie
     */
    public static int getTicket(int movieID){
        int ticket = 0;
        for (int i = 0; i < listHistory.size(); i++){
            History history = listHistory.get(i);
            if (history.getID() == movieID){
                ticket = ticket + history.getNoTicket();
            }
        }
        return ticket;
    }
}