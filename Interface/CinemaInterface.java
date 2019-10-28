package Interface;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import model.Cinema;
import controller.CinemaController;
public class CinemaInterface{
    public static void main(String[] aArgs)  {
        CinemaController CinemaController = new CinemaController();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean process = true;
        while(process){
            System.out.println("Please input your choice to continue:");
            System.out.println("1. Retrieve all Cinema details");
            System.out.println("2. Add new Cinema");
            System.out.println("3. Update Cinema information");
            System.out.println("4. Delete Cinema ");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = sc.next().charAt(0);
            System.out.print("\n");
            switch(choice){
                case '1':
                    CinemaController.displayCinema();
                    break;
                case '2':
                    if(CinemaController.createCinema(createCinema())){
                        System.out.println("Create Cinema successfully!");
                    }
                    else{
                        System.out.println("Cinema has already existed");
                    }
                    break;
                case '3':
                    if(!CinemaController.updateCinema(createCinema())){
                        System.out.println("Cinema does not exist to update");
                    }
                    else{
                        System.out.println("Update Cinema successfully!");
                    }
                    break;
                case '4':
                    if(!CinemaController.deleteCinema(deleteCinema())){
                        System.out.println("Cinema does not exist to delete");
                    }                 
                    else{
                        System.out.println("Delete Cinema successfully!");
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

  public static Cinema createCinema(){
    String name;
    int row, col, ID, cineplexId;
    Scanner sc = new Scanner(System.in);
    while(true){
        try{
            System.out.print("ID: ");
            ID = sc.nextInt();
            System.out.print("\n");
            System.out.print("Name: ");
            name = sc.next();
            System.out.print("\n");    
            System.out.print("CineplexID: ");
            cineplexId = sc.nextInt();
            System.out.print("\n");    
            System.out.print("Row: ");
            row = sc.nextInt();
            if(row < 0 || row > 15){
                throw new InvalidKeyException("Row must be from 1 to 15");
            }
            System.out.print("\n");
            System.out.print("Column: ");
            col= sc.nextInt();
            if(col < 0 || col > 15){
                throw new InvalidKeyException("Column must be from 1 to 15");
            }
            System.out.print("\n");
            break;
        } catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
            sc.nextLine();
            continue;
        }
    }
    return new Cinema(name, ID, cineplexId, row, col);
  }

  public static int deleteCinema(){
    int ID;
    Scanner sc = new Scanner(System.in);   
    System.out.println("ID of Cinema to delete:");   
    ID = sc.nextInt();
    return ID;
  }
}