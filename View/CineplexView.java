package View;
import java.security.InvalidKeyException;
import java.util.Scanner;
import controller.CineplexController;
import controller.MovieController;
import model.Cineplex;
import java.util.ArrayList;

/**
 * cineplex interface
 * @author Phung Minh Khanh
 */
public class CineplexView extends BaseView {
    public static void main(String[] args) {
        view();
    }

    /**
     * main interface display all Cineplex related operations
     */
    public static void view()  {
        CineplexController.readDB();
        MovieController.readDB();
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
            System.out.println("6. Back");
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
        CineplexController.saveDB();
    }

    /**
     * get a new created Cineplex object
     * @return new created cineplex
     */
    public static Cineplex createCineplex(){
        String name, location, inputAVMovie;
        int ID;
        ArrayList<Integer> availableMovie = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        while(true){
            availableMovie.clear();
            try{
                System.out.print("ID: ");
                ID = sc.nextInt();
                sc.nextLine();
                System.out.print("\n");

                System.out.print("Name: ");
                name = sc.nextLine();
                if (name.equals("")){
                    throw new InvalidKeyException("Name can not be empty");
                }
                System.out.print("\n");

                System.out.print("Location: ");
                location = sc.nextLine();
                if (location.equals("")){
                    throw new InvalidKeyException("Location can not be empty");
                }
                System.out.print("\n");

                MovieController.displayAll();
                System.out.print("Available movies(input movie ID seperate by ','): ");
                inputAVMovie = sc.nextLine();
                if(inputAVMovie.equals("")){
                    break;
                }
                String[] split = inputAVMovie.split(",");
                for(int i = 0; i < split.length; i++){
                    if(!MovieController.checkExist(Integer.parseInt(split[i]))){
                        throw new InvalidKeyException("Invalid movie ID, movie ID must be integer");
                    }
                    availableMovie.add(Integer.parseInt(split[i]));
                }

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