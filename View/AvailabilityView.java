package View;
import java.util.Scanner;

import controller.ShowtimeController;

/**
 * availability interface
 * @author Phung Minh Khanh
 */
public class AvailabilityView extends BaseView {
    /**
     * main interface for availability interface display showtimeId seat map
     */
    public static void view() {
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
    }

}