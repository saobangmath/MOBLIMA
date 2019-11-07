package Interface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MOBLIMAInterface {
    public static void main(String[] args) {
        AdminInterface adminInterface = new AdminInterface();
        Scanner sc = new Scanner(System.in);
        boolean process = true;
        while(process){
            System.out.println("Welcome to our MOBLIMA!");
            System.out.println("1. Admin Mode");
            System.out.println("2. MovieGoer Mode");
            System.out.println("Enter your choice:");
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
                        System.out.println("Please enter a valid choice!");
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a valid choice!");
                sc.next(); // flushing the next char input
            }
        }
    }
}
