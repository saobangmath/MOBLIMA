package Interface;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import model.Movie;
import controller.MovieController;
public class MovieInterface{
    public static void main(String[] aArgs)  {
        MovieController MovieController = new MovieController();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean process = true;
        while(process){
            System.out.println("Please input your choice to continue:");
            System.out.println("1. Retrieve all Movie details");
            System.out.println("2. Add new Movie");
            System.out.println("3. Update Movie information");
            System.out.println("4. Delete Movie ");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = sc.next().charAt(0);
            System.out.print("\n");
            switch(choice){
                case '1':
                    MovieController.displayMovie();
                    break;
                case '2':
                    if(MovieController.createMovie(createMovie())){
                        System.out.println("Create Movie successfully!");
                    }
                    else{
                        System.out.println("Movie has already existed");
                    }
                    break;
                case '3':
                    if(!MovieController.updateMovie(createMovie())){
                        System.out.println("Movie does not exist to update");
                    }
                    else{
                        System.out.println("Update Movie successfully!");
                    }
                    break;
                case '4':
                    if(!MovieController.deleteMovie(deleteMovie())){
                        System.out.println("Movie does not exist to delete");
                    }                 
                    else{
                        System.out.println("Delete Movie successfully!");
                    }   
                    break;
                case '5':
                    process = false;
                    break;
                default:
                    break;
            }
        }
  }

  public static Movie createMovie(){
    String name, description, cast, director, category;
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
            break;
        } catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
            sc.nextLine();
            continue;
        }
    }
    return new Movie(name, ID, category, description, director, cast, restriction, 0);
  }

  public static int deleteMovie(){
    int ID;
    Scanner sc = new Scanner(System.in);   
    System.out.println("ID of Movie to delete:");   
    ID = sc.nextInt();
    return ID;
  }
}