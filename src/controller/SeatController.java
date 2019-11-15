package controller;
import java.util.ArrayList;
import database.SeatDB;
import model.Seat;

/**
 * seat controller
 * @author Phung Minh Khanh
 */
public class SeatController{

    private static ArrayList<Seat> listSeats = new ArrayList<Seat>();

    /**
     * retrieve all Seat database and put it in the listSeats ArrayList
     */
    public static void readDB(){
        listSeats = SeatDB.readData();
    }

    /**
     * save back the listSeats to the textfile database
     */
    public static void saveDB() {
        SeatDB.saveData(listSeats);
    }

    /**
     *
     * @param seat
     * @return if could create a new seat
     */
    public static boolean create(Seat seat){
        if(checkExist(seat.getSeatRow(), seat.getSeatCol(), seat.getShowtimeId())){
            return false;
        }
        listSeats.add(seat);
        return true;
    }

    /**
     *
     * @param row
     * @param col
     * @param showtimeId
     * @return a Seat with specific row, col and showtimeID
     */
    public static Seat read(char row, int col, int showtimeId){
        for(int i = 0; i < listSeats.size(); i++){
            if(listSeats.get(i).getSeatCol() == col && listSeats.get(i).getSeatRow() == row
                    && listSeats.get(i).getShowtimeId() == showtimeId){
                return listSeats.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @param row
     * @param col
     * @param showtimeId
     * @return if existed a Seat with specific  details
     */
    public static boolean checkExist(char row, int col, int showtimeId){
        for(int i = 0; i < listSeats.size(); i++){
            if(listSeats.get(i).getSeatCol() == col && listSeats.get(i).getSeatRow() == row
                    && listSeats.get(i).getShowtimeId() == showtimeId){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param row
     * @param col
     * @param showtimeId
     * @return if a seat is occupied
     */
    public static boolean checkOccupied(char row, int col, int showtimeId){
        for(int i = 0; i < listSeats.size(); i++){
            if(listSeats.get(i).getSeatCol() == col && listSeats.get(i).getSeatRow() == row
                    && listSeats.get(i).getShowtimeId() == showtimeId){
                return listSeats.get(i).getOccupied();
            }
        }
        return false;
    }

    /**
     *
     * @param row
     * @param col
     * @param showtimeId
     * @return if we could delete a Seat
     */
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

    /**
     *
     * @param seat
     * @return if we could update a seat
     */
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

    /**
     * update the status of a Seat to be occupied
     * @param row
     * @param col
     * @param showtimeId
     * @param price
     */
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

    /**
     * display all Seat details
     */
    public static void displayAll(){
        for(int i = 0; i< listSeats.size(); i++){
            output(listSeats.get(i));
        }
    }

    /**
     * display a Seat details with specific ID, row and column
     * @param row
     * @param col
     * @param showtimeId
     */
    public static void displayByID(char row, int col, int showtimeId){
        for(int i = 0; i< listSeats.size(); i++){
            if(listSeats.get(i).getSeatCol() == col && listSeats.get(i).getSeatRow() == row
                    && listSeats.get(i).getShowtimeId() == showtimeId){
                output(listSeats.get(i));
                return;
            }
        }
    }

    /**
     * display a seat details
     * @param seat
     */
    public static void output(Seat seat){
        System.out.println("Seat Number : "+ seat.getSeatRow() + seat.getSeatCol());
        System.out.println("Showtime Id: " + seat.getShowtimeId());
        System.out.println("Occupied: "+ seat.getOccupied() );
        System.out.println("VIP: "+ seat.getVip() );
        System.out.print("\n");
    }
}