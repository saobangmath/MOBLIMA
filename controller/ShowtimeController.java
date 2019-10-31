package controller;
import java.util.ArrayList;
import database.ShowtimeDB;
import model.Showtime;
public class ShowtimeController{

    private static ArrayList<Showtime> listShowtimes = new ArrayList<Showtime>();

    public static void readDB(){
        listShowtimes = ShowtimeDB.readData();
    }
    
    public static boolean create(Showtime showtime){
        if(checkExist(showtime.getID())){
            return false;
        }
        listShowtimes.add(showtime);
        ShowtimeDB.saveData(listShowtimes);
        return true;
    }

    public static Showtime read(int ID){
        for(int i = 0; i < listShowtimes.size(); i++){
            if(listShowtimes.get(i).getID() == ID){
                return listShowtimes.get(i);
            }
        }
        return null;
    }

    public static boolean checkExist(int ID){
        for(int i = 0; i < listShowtimes.size(); i++){
            if(listShowtimes.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

    public static boolean delete(int ID){
        for(int i = 0; i < listShowtimes.size(); i++){
            if(listShowtimes.get(i).getID() == ID){
                listShowtimes.remove(i);
                ShowtimeDB.saveData(listShowtimes);
                return true;
            }
        }   
        return false;   
    }

    public static boolean update(Showtime showtime){
        for(int i = 0; i < listShowtimes.size(); i++){
             if(listShowtimes.get(i).getID() == showtime.getID()){
                listShowtimes.set(i, showtime);
                ShowtimeDB.saveData(listShowtimes);
                return true;
            }
        }   
        return false;           
    }

    public static void displayAll(){
        for(int i = 0; i< listShowtimes.size(); i++){
            System.out.println("ID: "+ listShowtimes.get(i).getID());
            System.out.println("Movie : " + listShowtimes.get(i).getMovieId());
            System.out.println("Cineplex : "+ listShowtimes.get(i).getCineplexId() );
            System.out.println("Cinema : "+ listShowtimes.get(i).getCinemaId() );
            System.out.println("Date : "+ listShowtimes.get(i).getDate() );
            System.out.println("Start time: "+ listShowtimes.get(i).getStartTime() );
            System.out.println("End time: "+ listShowtimes.get(i).getEndTime() );
            System.out.println("\n");
        }
    }

    public static void displayByID(int ID){
        for(int i = 0; i < listShowtimes.size(); i++){
            if(listShowtimes.get(i).getID() == ID){
                System.out.println("ID: "+ listShowtimes.get(i).getID());
                System.out.println("Movie : " + listShowtimes.get(i).getMovieId());
                System.out.println("Cineplex : "+ listShowtimes.get(i).getCineplexId() );
                System.out.println("Cinema : "+ listShowtimes.get(i).getCinemaId() );
                System.out.println("Date : "+ listShowtimes.get(i).getDate() );
                System.out.println("Start time: "+ listShowtimes.get(i).getStartTime() );
                System.out.println("End time: "+ listShowtimes.get(i).getEndTime() );
                System.out.print("\n");
                return;
            }
        }
    }
}