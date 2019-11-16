package View;
import java.util.Scanner;
import controller.ShowtimeController;
public class AvailabilityView extends BaseView{
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