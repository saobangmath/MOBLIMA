package Interface;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import model.Cinema;
import controller.CinemaController;
public class CinemaInterface extends BaseInterface{
    public static void main(String[] aArgs)  {
        CinemaController.readDB();
        Scanner sc = new Scanner(System.in);
        int choice, id;
        boolean process = true;
        while(process){
            System.out.println("Please input your choice to continue:");
            System.out.println("1. Retrieve all Cinema details");
            System.out.println("2. Get Cinema by ID");
            System.out.println("3. Add new Cinema");
            System.out.println("4. Update Cinema information");
            System.out.println("5. Delete Cinema ");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choice = sc.next().charAt(0);
            System.out.print("\n");
            switch(choice){
                case '1':
                    CinemaController.displayAll();
                    break;
                case '2':
                    id = readID();
                    if(CinemaController.read(id) == null){
                        System.out.println("Cinema does not exist");
                    }
                    else{
                        CinemaController.displayByID(id);
                    }
                    break;
                case '3':
                    if(CinemaController.create(createCinema())){
                        System.out.println("Create Cinema successfully!");
                    }
                    else{
                        System.out.println("Cinema has already existed");
                    }
                    break;
                case '4':
                    if(!CinemaController.update(createCinema())){
                        System.out.println("Cinema does not exist to update");
                    }
                    else{
                        System.out.println("Update Cinema successfully!");
                    }
                    break;
                case '5':
                    if(!CinemaController.delete(readID())){
                        System.out.println("Cinema does not exist to delete");
                    }
                    else{
                        System.out.println("Delete Cinema successfully!");
                    }
                    break;
                case '6':
                    process = false;
                    break;
                default:
                    break;
            }
        }
        CinemaController.saveDB();
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

}