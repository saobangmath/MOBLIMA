package controller;
import java.util.ArrayList;
import database.ShowtimeDB;
import model.Showtime;
import model.Cinema;
import model.Seat;
import controller.SeatController;
import controller.CinemaController;
import controller.MovieController;
public class ShowtimeController{

    private static ArrayList<Showtime> listShowtimes = new ArrayList<Showtime>();

    public static void readDB(){
        listShowtimes = ShowtimeDB.readData();
    }
    
    public static void saveDB(){
        ShowtimeDB.saveData(listShowtimes);
    }

    public static boolean create(Showtime showtime){
        if(checkExist(showtime.getID())){
            return false;
        }
        listShowtimes.add(showtime);
        batchCreateSeat(showtime.getID(), CinemaController.read(showtime.getCinemaId()));
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
                return true;
            }
        }   
        return false;   
    }

    public static boolean update(Showtime showtime){
        for(int i = 0; i < listShowtimes.size(); i++){
             if(listShowtimes.get(i).getID() == showtime.getID()){
                listShowtimes.set(i, showtime);
                return true;
            }
        }   
        return false;           
    }

    public static void displayAll(){
        System.out.println("All available movies: ");
        for(int i = 0; i< listShowtimes.size(); i++){
            output(listShowtimes.get(i));
        }
    }

    public static void displayByID(int ID){
        for(int i = 0; i < listShowtimes.size(); i++){
            if(listShowtimes.get(i).getID() == ID){
                output(listShowtimes.get(i));
                return;
            }
        }
    }

    public static void displayByCineplex(int cineplexId){
        System.out.println("All showtimes in this cineplex");
        for(int i = 0; i < listShowtimes.size(); i++){
            if(listShowtimes.get(i).getCineplexId() == cineplexId){
                output(listShowtimes.get(i));
            }
        }
    }

    public static void output(Showtime showtime){
        System.out.println("ID: "+ showtime.getID());
        System.out.println("Movie : " + MovieController.read(showtime.getMovieId()).getName());
        System.out.println("Cineplex : "+ CineplexController.read(showtime.getCineplexId()).getName() );
        System.out.println("Cinema : "+ CinemaController.read(showtime.getCinemaId()).getName());
        System.out.println("Date : "+ showtime.getDate() );
        System.out.println("Start time: "+ showtime.getStartTime() );
        System.out.println("End time: "+ showtime.getEndTime() );
        System.out.print("\n");
    }

    public static boolean validateShowtime(int cineplexId, String date){
        for(int i = 0; i < listShowtimes.size(); i++){
            if(listShowtimes.get(i).getCineplexId() == cineplexId && listShowtimes.get(i).getDate().equals(date)){
                return true;
            }
        }
        return false;
    }
    public static void batchCreateSeat(int showtimeId, Cinema cinema){
        int row = cinema.getRow();
        int col = cinema.getCol();
        char rowChar;
        for(int i = 0; i < row; i++){
            rowChar = (char) (i + 65);
            for(int j = 0; j < col; j++){
                Seat seat;
                if(rowChar == 'E' || rowChar == 'F' || rowChar == 'G'){
                    seat = new Seat(rowChar, j+1, showtimeId, false, false, 0);
                }
                else{
                    seat = new Seat(rowChar, j+1, showtimeId, false, true, 0);
                }
                SeatController.create(seat);
            }
        }
    }

    public static void displaySeatMap(int showtimeId, Cinema cine){
        int row = cine.getRow();
        int col = cine.getCol();
        char rowChar;
        System.out.print("    ");
        for(int i = 0; i < col; i++){
            System.out.print(i+1 );
            System.out.print(" ");
        }
        System.out.print("\n");
        for(int i = 0; i < row; i++){
            rowChar = (char) (i + 65);
            System.out.print(rowChar + "   ");
            for(int j = 1; j < col+1; j++){
                if(SeatController.checkOccupied(rowChar, j, showtimeId)){
                    System.out.print("o ");
                }
                else{
                    System.out.print("x ");
                }
            }
            System.out.print("\n");
        }
    }
}