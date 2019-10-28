package Interface;
import java.util.Scanner;
import controller.CineplexController;
import model.Cineplex;
import java.util.ArrayList;
public class CineplexInterface{
    public static void main(String[] aArgs)  {
        CineplexController CineplexController = new CineplexController();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean process = true;
        while(process){
            System.out.println("Please input your choice to continue:");
            System.out.println("1. Retrieve all Cineplex details");
            System.out.println("2. Add new Cineplex");
            System.out.println("3. Update Cineplex information");
            System.out.println("4. Delete Cineplex ");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = sc.next().charAt(0);
            System.out.print("\n");
            switch(choice){
                case '1':
                    CineplexController.displayCineplex();
                    break;
                case '2':
                    if(CineplexController.createCineplex(createCineplex())){
                        System.out.println("Create Cineplex successfully!");
                    }
                    else{
                        System.out.println("Cineplex has already existed");
                    }
                    break;
                case '3':
                    if(!CineplexController.updateCineplex(createCineplex())){
                        System.out.println("Cineplex does not exist to update");
                    }
                    else{
                        System.out.println("Update Cineplex successfully!");
                    }
                    break;
                case '4':
                    if(!CineplexController.deleteCineplex(deleteCineplex())){
                        System.out.println("Cineplex does not exist to delete");
                    }                 
                    else{
                        System.out.println("Delete Cineplex successfully!");
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

  public static Cineplex createCineplex(){
    String name, location;
    int ID;
    ArrayList<String> availableMovie = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);
    while(true){
        try{
            System.out.print("ID: ");
            ID = sc.nextInt();
            System.out.print("\n");
            System.out.print("Name: ");
            name = sc.next();
            System.out.print("\n");    
            System.out.print("Location: ");
            location = sc.next();
            System.out.print("\n");    
            break;
        } catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
            sc.nextLine();
            continue;
        }
    }
    return new Cineplex(name, ID, location, availableMovie);
  }

  public static int deleteCineplex(){
    int ID;
    Scanner sc = new Scanner(System.in);   
    System.out.println("ID of Cineplex to delete:");   
    ID = sc.nextInt();
    return ID;
  }
}