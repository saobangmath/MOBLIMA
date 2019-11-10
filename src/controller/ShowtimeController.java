package controller;
import java.util.ArrayList;
import database.ShowtimeDB;
import model.Showtime;
import model.Cinema;
import model.Seat;
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
        batchCreateSeat(showtime.getID(), CinemaController.read(showtime.getCinemaId()));
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

    public static void batchCreateSeat(int ID, Cinema cinema){
        int row = cinema.getRow();
        int col = cinema.getCol();
        char rowChar;
        for(int i = 0; i < row; i++){
            rowChar = (char) (i + 65);
            for(int j = 0; j < col; j++){
                Seat seat;
                if(rowChar == 'E' || rowChar == 'F' || rowChar == 'G'){
                    seat = new Seat(rowChar, col, ID, false, false, 0);
                }
                else{
                    seat = new Seat(rowChar, col, ID, false, true, 0);
                }
                SeatController.create(seat);
            }
        }
    }

    public static void displaySeatMap(int ID, Cinema cine){
        int row = cine.getRow();
        int col = cine.getCol();
        char rowChar;
        System.out.print("    ");
        for(int i = 0; i < col; i++){
            System.out.print(i+1);
        }
        System.out.print("\n");
        for(int i = 0; i < row; i++){
            rowChar = (char) (i + 65);
            System.out.print(rowChar + "   ");
            for(int j = 0; j < col; j++){
                if(SeatController.checkOccupied(rowChar, col, ID)){
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