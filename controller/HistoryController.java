package controller;
import java.util.ArrayList;
import database.HistoryDB;
import model.*;
import controller.*;
public class HistoryController{

    private static ArrayList<History> listHistory = new ArrayList<History>();

    public static void readDB(){
        listHistory = HistoryDB.readData();
    }

    public static void saveDB(){
        HistoryDB.saveData(listHistory);
    }
    
    public static boolean create(History History){
        if(checkExist(History.getID())){
            return false;
        }
        listHistory.add(History);
        return true;
    }

    public static History read(double ID){
        for(int i = 0; i < listHistory.size(); i++){
            if(listHistory.get(i).getID() == ID){
                return listHistory.get(i);
            }
        }   
        return null;   
    }
    public static boolean checkExist(double ID){
        for(int i = 0; i < listHistory.size(); i++){
            if(listHistory.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

    public static boolean delete(double ID){
        for(int i = 0; i < listHistory.size(); i++){
            if(listHistory.get(i).getID() == ID){
                listHistory.remove(i);
                return true;
            }
        }   
        return false;   
    }

    public static boolean update(History History){
        for(int i = 0; i < listHistory.size(); i++){
             if(listHistory.get(i).getID() == History.getID()){
                listHistory.set(i, History);
                return true;
            }
        }   
        return false;           
    }

    public static void displayAll(){
        for(int i = 0; i< listHistory.size(); i++){
            output(listHistory.get(i));
        }
    }

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

    public static void output(History history){
        Showtime showtime = ShowtimeController.read(history.getShowtimeId());
        Movie movie = MovieController.read(showtime.getMovieId());
        Cinema cinema = CinemaController.read(showtime.getCinemaId());
        Cineplex cineplex = CineplexController.read(showtime.getCineplexId());
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
        System.out.println("Price: " + history.getPrice());
        System.out.println("Transaction time: " + history.getTransactionTime());
        System.out.println("Transaction date: " + history.getTransactionDate());
        System.out.println("Transaction ID: " + String.valueOf(history.getID()));
        System.out.print("\n");
    }
}