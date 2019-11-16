package View;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import model.Holiday;
import controller.HolidayController;

/**
 * holiday interface
 * @author Phung Minh Khanh
 */
public class HolidayView extends BaseView {
    /**
     * main interface
     */
    public static void view()  {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean process = true;
        while(process){
            System.out.println("Please input your choice to continue:");
            System.out.println("1. Retrieve all Holiday ");
            System.out.println("2. Add new Holiday");
            System.out.println("3. Delete Holiday ");
            System.out.println("4. Back");
            System.out.print("Your choice: ");
            choice = sc.nextLine().charAt(0);
            System.out.print("\n");
            switch(choice){
                case '1':
                    HolidayController.displayAll();
                    break;
                case '2':
                    if(HolidayController.create(createHoliday())){
                        System.out.println("Create Holiday successfully!");
                    }
                    else{
                        System.out.println("Holiday has already existed");
                    }
                    break;
                case '3':
                    if(!HolidayController.delete(readInput())){
                        System.out.println("Holiday does not exist to delete");
                    }
                    else{
                        System.out.println("Delete Holiday successfully!");
                    }
                    break;
                case '4':
                    process = false;
                    break;
                default:
                    break;
            }
        }
        HolidayController.saveDB();
    }

    /**
     *
     * @return new created holiday
     */
    public static Holiday createHoliday(){
        String date;
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Date (dd/MM/yyyy): ");
                date = sc.nextLine();
                if(!Holiday.validateDate(date)){
                    throw new InvalidKeyException("Invalid date type please input as dd/MM/yyyy");
                }
                return new Holiday(date);
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                System.out.print("\n");
            }
        }
    }

    /**
     *
     * @return date input
     */
    public static String readInput(){
        String date;
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Date (dd/MM/yyyy): ");
                date = sc.nextLine();
                if(!Holiday.validateDate(date)){
                    throw new InvalidKeyException("Invalid date type please input as dd/MM/yyyy");
                }
                return date;
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                System.out.print("\n");
            }
        }
    }
}