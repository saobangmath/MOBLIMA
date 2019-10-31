package Interface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MOBLIMAInterface {
    public static void main(String[] args) {
        AdminInterface adminInterface = new AdminInterface();
        DisplayInterface displayInterface = new DisplayInterface();
        Scanner sc = new Scanner(System.in);
        boolean process = true;
        while(process){
            displayInterface.Welcome();
            try{
                int choice =  sc.nextInt();
                switch (choice){
                    case 1:
                        AdminInterface.main(null);
                        break;
                    case 2:
                        MovieGoerInterface.main(null);
                        break;
                    default:
                        displayInterface.InvalidNotification();
                        break;
                }
            }
            catch (InputMismatchException e){
                displayInterface.InvalidNotification();
                sc.next(); // flushing the next char input
            }
        }
    }
}
