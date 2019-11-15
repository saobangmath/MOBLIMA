package Interface;
import java.util.Scanner;

import javax.management.openmbean.InvalidKeyException;
import model.MovieGoer;
import controller.MovieGoerController;

/**
 * moviegoer interface
 * @author Phung Minh Khanh
 */
public class MovieGoerInterface extends BaseInterface{
    /**
     * main interface
     */
    public static void view() {
        MovieGoerController.readDB();
        Scanner sc = new Scanner(System.in);
        int choice;
        String email;
        boolean process = true;
        while(process){
            System.out.println("Please input your choice to continue:");
            System.out.println("1. Retrieve all MovieGoer details");
            System.out.println("2. Get MovieGoer by Email");
            System.out.println("3. Add new MovieGoer");
            System.out.println("4. Update MovieGoer information");
            System.out.println("5. Delete MovieGoer ");
            System.out.println("6. Back");
            System.out.print("Your choice: ");
            choice = sc.next().charAt(0);
            System.out.print("\n");
            switch(choice){
                case '1':
                    MovieGoerController.displayAll();
                    break;
                case '2':
                    email = readEmail().trim();
                    if(MovieGoerController.read(email) == null){
                        System.out.println("Movie Goer does not exist");
                    }
                    else{
                        MovieGoerController.displayByID(email);
                    }
                    break;
                case '3':
                    if(MovieGoerController.create(createMovieGoer())){
                        System.out.println("Create Movie Goer successfully!");
                    }
                    else{
                        System.out.println("Movie Goer has already existed");
                    }
                    break;
                case '4':
                    if(!MovieGoerController.update(createMovieGoer())){
                        System.out.println("Movie Goer does not exist to update");
                    }
                    else{
                        System.out.println("Update Movie Goer successfully!");
                    }
                    break;
                case '5':
                    if(!MovieGoerController.delete(readEmail())){
                        System.out.println("Movie Goer does not exist to delete");
                    }
                    else{
                        System.out.println("Delete Movie Goer successfully!");
                    }
                    break;
                case '6':
                    process = false;
                    break;
                default:
                    break;
            }
        }
        MovieGoerController.saveDB();
    }

    public static MovieGoer createMovieGoer(){
        String email, name;
        int age, mobile;
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Email: ");
                email = sc.next();
                System.out.print("\n");
                System.out.print("Age: ");
                age = sc.nextInt();
                if(age < 0 || age > 100){
                    throw new InvalidKeyException("Age must be a valid value");
                }
                System.out.print("\n");
                System.out.print("Name: ");
                name = sc.next();
                System.out.print("\n");
                System.out.print("Mobile: ");
                mobile = sc.nextInt();
                System.out.print("\n");
                break;
            } catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                sc.nextLine();
                continue;
            }
        }
        return new MovieGoer(email, age, name, mobile, 0);
    }

    public static String readEmail(){
        String email;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input ID to continue:");
        email = sc.next();
        return email;
    }

}