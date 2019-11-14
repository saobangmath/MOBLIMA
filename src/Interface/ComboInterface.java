package Interface;

import controller.ComboController;
import controller.MovieController;
import model.Combo;
import model.Email;

import java.util.Scanner;

/**
 * represents console display of the Combo objects
 * @author Tran Anh Tai
 */
public class ComboInterface {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        view();
    }

    /**
     * main interface of the combo
     */
    public static void view(){
        MovieController.readDB();
        ComboController.readDB();
        boolean process = true;
        while (process){
            System.out.println();
            System.out.println("Do you want to book any food or drink?");
            System.out.println("Enter Yes or No (Y/N): ");
            char choice = sc.next().charAt(0);
            switch (choice){
                case 'Y':
                    create();
                    break;

                case 'N':
                    process = false;
                    break;

                default:
                    System.out.println("Please enter valid choice");
                    break;

            }

        }
        MovieController.saveDB();
        ComboController.saveDB();
    }

    /**
     * create new Combo popcorn and drink
     */
    private static void create(){
        System.out.println("Enter your email: ");
        String email = sc.next();
        if (Email.validateEmail(email)){
            System.out.println("Enter movie ID: ");
            int movieID = sc.nextInt();
            if (MovieController.checkExist(movieID)){
                System.out.println("Enter number of popcorn: ");
                int popcorn = sc.nextInt();
                System.out.println("Enter number of drink: ");
                int drink = sc.nextInt();
                Combo combo = new Combo(movieID, email, popcorn, drink);

                ComboController.create(combo);
                System.out.println("You have successfully ordered!");
            }
            else{
                System.out.println("The movie ID is not existed in the database!");
            }
        }
        else{
            System.out.println("Your email account is invalid!");
        }
    }
}
