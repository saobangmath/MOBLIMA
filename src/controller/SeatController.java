package controller;
import java.util.ArrayList;
import database.SeatDB;
import model.Seat;
public class SeatController{

    private static ArrayList<Seat> listSeats = new ArrayList<Seat>();

    public static void readDB(){
        listSeats = SeatDB.readData();
    }

    public static void saveDB() {
        SeatDB.saveData(listSeats);
    }
    public static boolean create(Seat seat){
        if(checkExist(seat.getSeatRow(), seat.getSeatCol(), seat.getShowtimeId())){
            return false;
        }
        listSeats.add(seat);
        SeatDB.saveData(listSeats);
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
                SeatDB.saveData(listSeats);
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
                SeatDB.saveData(listSeats);
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
                SeatDB.saveData(listSeats);
            }
        }
    }

    public static void displayAll(){
        for(int i = 0; i< listSeats.size(); i++){
            System.out.println("Seat Number : "+ listSeats.get(i).getSeatRow() + listSeats.get(i).getSeatCol());
            System.out.println("Showtime Id: " + listSeats.get(i).getShowtimeId());
            System.out.println("Occupied: "+ listSeats.get(i).getOccupied() );
            System.out.println("VIP: "+ listSeats.get(i).getVip() );
            System.out.println("\n");
        }
    }

    public static void displayByID(char row, int col, int showtimeId){
        for(int i = 0; i< listSeats.size(); i++){
            if(listSeats.get(i).getSeatCol() == col && listSeats.get(i).getSeatRow() == row
                    && listSeats.get(i).getShowtimeId() == showtimeId){
                System.out.println("Seat Number : "+ listSeats.get(i).getSeatRow() + listSeats.get(i).getSeatCol());
                System.out.println("Showtime Id: " + listSeats.get(i).getShowtimeId());
                System.out.println("Occupied: "+ listSeats.get(i).getOccupied() );
                System.out.println("VIP: "+ listSeats.get(i).getVip() );
                System.out.println("\n");
                return;
            }
        }
    }
}