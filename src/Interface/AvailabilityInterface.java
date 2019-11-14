package Interface;
import java.util.Scanner;

import controller.SeatController;
import controller.ShowtimeController;
import model.Seat;

public class AvailabilityInterface extends BaseInterface{
    public static void view() {
        ShowtimeController.readDB();
        SeatController.readDB();
        Scanner sc = new Scanner(System.in);
        int showtimeId;
        boolean process = true;
        while(process){
            ShowtimeController.displayAll();
            showtimeId = readID();
            if(ShowtimeController.checkExist(showtimeId)){
                ShowtimeController.displaySeatMap(showtimeId);
                process = false;
            }
            else{
                System.out.println("Showtime ID not exists");
            }
        }
        ShowtimeController.saveDB();
        SeatController.saveDB();
    }

}