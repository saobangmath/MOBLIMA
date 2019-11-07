package Interface;
import java.util.Scanner;
public abstract class BaseInterface{

    public static int readID(){
        int ID;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input ID to continue:");
        ID = sc.nextInt();
        return ID;
    }
}