package controller;
import java.util.ArrayList;
import database.SeatDB;
import model.Seat;
public class SeatController{

    private static ArrayList<Seat> listSeats = new ArrayList<Seat>();

    public static void readDB(){
        listSeats = SeatDB.readData();
    }

    public static void saveDB(){
        SeatDB.saveData(listSeats);
    }
    public static boolean create(Seat seat){
        if(checkExist(seat.getSeatRow(), seat.getSeatCol(), seat.getShowtimeId())){
            return false;
        }
        listSeats.add(seat);
        return true;
    }

    public static Seat read(char row, int col, int showtimeId){
        for(int i = 0; i < listSeats.size(); i++){
            if(listSeats.get(i).getSeatCol() == col && listSeats.get(i).getSeatRow() == row
            && listSeats.get(i).getShowtimeId() == showtimeId){
                return listSeats.get(i);
            }
        }   
        return null;   
    }

    public static boolean checkExist(char row, int col, int showtimeId){
        for(int i = 0; i < listSeats.size(); i++){
            if(listSeats.get(i).getSeatCol() == col && listSeats.get(i).getSeatRow() == row
                && listSeats.get(i).getShowtimeId() == showtimeId){
                return true;
            }
        }
        return false;
    }

    public static boolean checkOccupied(char row, int col, int showtimeId){
        for(int i = 0; i < listSeats.size(); i++){
            if(listSeats.get(i).getSeatCol() == col && listSeats.get(i).getSeatRow() == row
                && listSeats.get(i).getShowtimeId() == showtimeId){
                return listSeats.get(i).getOccupied();
            }
        }
        return false;
    }

    public static boolean delete(char row, int col, int showtimeId){
        for(int i = 0; i < listSeats.size(); i++){
            if(listSeats.get(i).getSeatCol() == col && listSeats.get(i).getSeatRow() == row
            && listSeats.get(i).getShowtimeId() == showtimeId){
                listSeats.remove(i);
                return true;
            }
        }   
        return false;   
    }

    public static boolean update(Seat seat){
        for(int i = 0; i < listSeats.size(); i++){
             if(listSeats.get(i).getSeatCol() == seat.getSeatCol() && listSeats.get(i).getSeatRow() == seat.getSeatRow()
             && listSeats.get(i).getShowtimeId() == seat.getShowtimeId()){
                listSeats.set(i, seat);
                return true;
            }
        }   
        return false;           
    }

    public static void updateOccupied(char row, int col, int showtimeId, int price){
        for(int i = 0; i < listSeats.size(); i++){
            if(listSeats.get(i).getSeatCol() == col && listSeats.get(i).getSeatRow() == row
                && listSeats.get(i).getShowtimeId() == showtimeId){
                Seat seat = listSeats.get(i);
                seat.setOccupied(true);
                seat.setPrice(price);
                listSeats.set(i, seat);
            }
        }
    }

    public static void displayAll(){
        for(int i = 0; i< listSeats.size(); i++){
            output(listSeats.get(i));
        }
    }

    public static void displayByID(char row, int col, int showtimeId){
        for(int i = 0; i< listSeats.size(); i++){
            if(listSeats.get(i).getSeatCol() == col && listSeats.get(i).getSeatRow() == row
            && listSeats.get(i).getShowtimeId() == showtimeId){
                output(listSeats.get(i));
                return;
            }
        }
    }

    public static void output(Seat seat){
        System.out.println("Seat Number : "+ seat.getSeatRow() + seat.getSeatCol());
        System.out.println("Showtime Id: " + seat.getShowtimeId());
        System.out.println("Occupied: "+ seat.getOccupied() );
        System.out.println("VIP: "+ seat.getVip() );
        System.out.print("\n");
    }
}