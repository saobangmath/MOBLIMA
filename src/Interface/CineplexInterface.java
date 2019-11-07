package Interface;
import java.util.Scanner;
import controller.CineplexController;
import model.Cineplex;
import java.util.ArrayList;
public class CineplexInterface extends BaseInterface{
    public static void main(String[] aArgs)  {
        CineplexController.readDB();
        Scanner sc = new Scanner(System.in);
        int choice, id;
        boolean process = true;
        while(process){
            System.out.println("Please input your choice to continue:");
            System.out.println("1. Retrieve all Cineplex details");
            System.out.println("2. Get Cineplex by ID");
            System.out.println("3. Add new Cineplex");
            System.out.println("4. Update Cineplex information");
            System.out.println("5. Delete Cineplex ");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choice = sc.next().charAt(0);
            System.out.print("\n");
            switch(choice){
                case '1':
                    CineplexController.displayAll();
                    break;
                case '2':
                    id = readID();
                    if(CineplexController.read(id) == null){
                        System.out.println("Cineplex does not exist");
                    }
                    else{
                        CineplexController.displayByID(id);
                    }
                    break;
                case '3':
                    if(CineplexController.create(createCineplex())){
                        System.out.println("Create Cineplex successfully!");
                    }
                    else{
                        System.out.println("Cineplex has already existed");
                    }
                    break;
                case '4':
                    if(!CineplexController.update(createCineplex())){
                        System.out.println("Cineplex does not exist to update");
                    }
                    else{
                        System.out.println("Update Cineplex successfully!");
                    }
                    break;
                case '5':
                    if(!CineplexController.delete(readID())){
                        System.out.println("Cineplex does not exist to delete");
                    }
                    else{
                        System.out.println("Delete Cineplex successfully!");
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
}