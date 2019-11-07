package Interface;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import model.Seat;
import controller.SeatController;
public class SeatInterface extends BaseInterface{
    private static int col, showtimeId;
    private static char row;
    public static void main(String[] aArgs)  {
        SeatController.readDB();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean process = true;
        while(process){
            System.out.println("Please input your choice to continue:");
            System.out.println("1. Retrieve all Seat details");
            System.out.println("2. Get Seat by row, column, showtimeId");
            System.out.println("3. Add new Seat");
            System.out.println("4. Update Seat information");
            System.out.println("5. Delete Seat ");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choice = sc.next().charAt(0);
            System.out.print("\n");
            switch(choice){
                case '1':
                    SeatController.displayAll();
                    break;
                case '2':
                    readInput();
                    if(SeatController.read(row, col, showtimeId) == null){
                        System.out.println("Seat does not exist");
                    }
                    else{
                        SeatController.displayByID(row, col, showtimeId);
                    }
                    break;
                case '3':
                    if(SeatController.create(createSeat())){
                        System.out.println("Create Seat successfully!");
                    }
                    else{
                        System.out.println("Seat has already existed");
                    }
                    break;
                case '4':
                    if(!SeatController.update(createSeat())){
                        System.out.println("Seat does not exist to update");
                    }
                    else{
                        System.out.println("Update Seat successfully!");
                    }
                    break;
                case '5':
                    readInput();
                    if(!SeatController.delete(row, col , showtimeId)){
                        System.out.println("Seat does not exist to delete");
                    }
                    else{
                        System.out.println("Delete Seat successfully!");
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

    public static Seat createSeat(){
        char rowInput;
        int colInput, showtimeIdInput, vipInput;
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Row: ");
                rowInput = sc.next().charAt(0);
                System.out.print("\n");

                System.out.print("Column: ");
                colInput = sc.nextInt();
                System.out.print("\n");

                System.out.print("Showtime Id: ");
                showtimeIdInput = sc.nextInt();
                System.out.print("\n");

                System.out.print("VIP (1 for true, 0 for false): ");
                vipInput = sc.nextInt();
                System.out.print("\n");
                break;
            } catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                sc.nextLine();
                continue;
            }
        }
        if(vipInput == 0){
            return new Seat(rowInput, colInput, showtimeIdInput, false, false, 0);
        }
        return new Seat(rowInput, colInput, showtimeIdInput, false, true, 0);
    }

    public static void readInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input row: ");
        row = sc.next().charAt(0);
        System.out.println("Input column: ");
        col = sc.nextInt();
        System.out.println("Input Showtime Id: ");
        showtimeId = sc.nextInt();
        return;
    }
}