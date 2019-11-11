package Interface;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import model.History;
import controller.*;
public class HistoryInterface extends BaseInterface{
    public static void view() {
        HistoryController.readDB();
        CineplexController.readDB();
        CinemaController.readDB();
        SeatController.readDB();
        MovieController.readDB();
        ShowtimeController.readDB();
        MovieGoerController.readDB();
        boolean process = true;
        String email;
        Scanner sc = new Scanner(System.in);
        while(process){
            System.out.println("Please input your email to see your booking history:");
            email = sc.nextLine();
            HistoryController.displayByEmail(email);
            break;
        }
  }

}