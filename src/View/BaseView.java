package View;
import java.util.Scanner;

/**
 * @author Phung Minh Khanh
 */
public abstract class BaseView {
    /**
     *
     * @return ID input
     */
    public static int readID(){
        int ID;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input ID to continue:");
        ID = sc.nextInt();
        return ID;
    }
}