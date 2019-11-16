package View;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import model.History;
import controller.*;
public class HistoryView extends BaseView{
    public static void view() {
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