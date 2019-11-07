package Interface;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import model.Movie;
import controller.MovieController;
public class MovieInterface extends BaseInterface{
    public static void main(String[] aArgs)  {
        MovieController.readDB();
        Scanner sc = new Scanner(System.in);
        int choice, id;
        boolean process = true;
        while(process){
            System.out.println("Please input your choice to continue:");
            System.out.println("1. Retrieve all Movie details");
            System.out.println("2. Get Movie by ID");
            System.out.println("3. Add new Movie");
            System.out.println("4. Update Movie information");
            System.out.println("5. Delete Movie ");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choice = sc.next().charAt(0);
            System.out.print("\n");
            switch(choice){
                case '1':
                    MovieController.displayAll();
                    break;
                case '2':
                    id = readID();
                    if(MovieController.read(id) == null){
                        System.out.println("Movie does not exist");
                    }
                    else{
                        MovieController.displayByID(id);
                    }
                    break;
                case '3':
                    if(MovieController.create(createMovie())){
                        System.out.println("Create Movie successfully!");
                    }
                    else{
                        System.out.println("Movie has already existed");
                    }
                    break;
                case '4':
                    if(!MovieController.update(createMovie())){
                        System.out.println("Movie does not exist to update");
                    }
                    else{
                        System.out.println("Update Movie successfully!");
                    }
                    break;
                case '5':
                    if(!MovieController.delete(readID())){
                        System.out.println("Movie does not exist to delete");
                    }
                    else{
                        System.out.println("Delete Movie successfully!");
                    }
                    break;
                case '6':
                    process = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static Movie createMovie(){
        String name, description, cast, director, category, startDate, endDate;
        int ID, restriction;
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print("ID: ");
                ID = sc.nextInt();
                System.out.print("\n");

                System.out.print("Name: ");
                name = sc.next();
                System.out.print("\n");

                System.out.print("Category: ");
                category = sc.next();
                System.out.print("\n");

                System.out.print("Description: ");
                description = sc.next();
                System.out.print("\n");

                System.out.print("Director: ");
                director = sc.next();
                System.out.print("\n");

                System.out.print("Cast: ");
                cast = sc.next();
                System.out.print("\n");

                System.out.print("Restriction( 1. No Restriction   2. 10+   3. 16+    4. 18+ ): ");
                restriction= sc.nextInt();
                if(restriction < 1 || restriction > 4){
                    throw new InvalidKeyException("Restriction must be from 1 to 4");
                }
                System.out.print("\n");

                System.out.print("Start date (dd/MM/yyyy): ");
                startDate = sc.next();
                if(Movie.validateDate(startDate)){
                    throw new InvalidKeyException("Invalid date input (dd/MM/yyyy)");
                }
                System.out.print("\n");

                System.out.print("End date (dd/MM/yyyy): ");
                endDate = sc.next();
                if(Movie.validateDate(endDate)){
                    throw new InvalidKeyException("Invalid date input (dd/MM/yyyy)");
                }
                System.out.print("\n");
                break;
            } catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                sc.nextLine();
                continue;
            }
        }
        return new Movie(name, ID, category, description, director, cast, restriction, 0, startDate, endDate);
    }
}