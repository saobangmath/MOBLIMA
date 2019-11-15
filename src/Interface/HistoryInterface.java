package Interface;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import model.History;
import controller.*;

/**
 * history interface
 * @author Phung Minh Khanh
 */
public class HistoryInterface extends BaseInterface{
    /**
     * main interface
     */
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