package View;
import java.util.Scanner;

import controller.*;

/**
 * history interface
 * @author Phung Minh Khanh
 */
public class HistoryView extends BaseView {
    /**
     * main interface for display all history view operations
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