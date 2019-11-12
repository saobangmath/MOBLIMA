package Interface;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;

import controller.*;
import model.Showtime;

public class ShowtimeInterface{
    public static void main(String[] aArgs)  {
        ShowtimeController.readDB();
        CineplexController.readDB();
        CinemaController.readDB();
        SeatController.readDB();
        MovieController.readDB();
        Scanner sc = new Scanner(System.in);
        int choice, id;
        boolean process = true;
        while(process){
            System.out.println("Please input your choice to continue:");
            System.out.println("1. Retrieve all Showtime details");
            System.out.println("2. Get Showtime details by ID");
            System.out.println("3. Add new Showtime");
            System.out.println("4. Update Showtime information");
            System.out.println("5. Delete Showtime ");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choice = sc.next().charAt(0);
            System.out.print("\n");
            switch(choice){
                case '1':
                    ShowtimeController.displayAll();
                    break;
                case '2':
                    id = readShowtime();
                    if(ShowtimeController.read(id) == null){
                        System.out.println("Showtime does not exist");
                    }
                    else{
                        ShowtimeController.displayByID(id);
                    }
                    break;
                case '3':
                    if(ShowtimeController.create(createShowtime())){
                        System.out.println("Create Showtime successfully!");
                    }
                    else{
                        System.out.println("Showtime has already existed");
                    }
                    break;
                case '4':
                    if(!ShowtimeController.update(createShowtime())){
                        System.out.println("Showtime does not exist to update");
                    }
                    else{
                        System.out.println("Update Showtime successfully!");
                    }
                    break;
                case '5':
                    if(!ShowtimeController.delete(deleteShowtime())){
                        System.out.println("Showtime does not exist to delete");
                    }
                    else{
                        System.out.println("Delete Showtime successfully!");
                    }
                    break;
                case '6':
                    process = false;
                    break;
                default:
                    break;
            }
        }
        MovieController.saveDB();
        ShowtimeController.saveDB();
        SeatController.saveDB();
    }

    public static Showtime createShowtime(){
        String date, startTime, endTime;
        int movieId, cinemaId, ID, cineplexId;
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print("ID: ");
                ID = sc.nextInt();
                System.out.print("\n");

                System.out.print("MovieID: ");
                movieId = sc.nextInt();
                System.out.print("\n");

                System.out.print("CineplexID: ");
                cineplexId = sc.nextInt();
                System.out.print("\n");

                System.out.print("CinemaID: ");
                cinemaId = sc.nextInt();
                System.out.print("\n");

                System.out.print("Date (dd/MM/yyyy): ");
                date = sc.next();
                if(!Showtime.validateDate(date)){
                    throw new InvalidKeyException("Invalid date type please input as dd/MM/yyyy");
                }
                System.out.print("\n");

                System.out.print("Start time (hh:mm): ");
                startTime = sc.next();
                if(!Showtime.validateTime(startTime)){
                    throw new InvalidKeyException("Invalid time type please input as hh:mm");
                }
                System.out.print("\n");

                System.out.print("End time (hh:mm): ");
                endTime = sc.next();
                if(!Showtime.validateTime(endTime)){
                    throw new InvalidKeyException("Invalid time type please input as hh:mm");
                }
                System.out.print("\n");

                break;
            } catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                sc.nextLine();
                continue;
            }
        }
        return new Showtime(ID, movieId, cineplexId, cinemaId, date, startTime, endTime);
    }

    public static int deleteShowtime(){
        int ID;
        Scanner sc = new Scanner(System.in);
        System.out.println("ID of Showtime to delete:");
        ID = sc.nextInt();
        return ID;
    }

    public static int readShowtime(){
        int ID;
        Scanner sc = new Scanner(System.in);
        System.out.println("ID of Showtime to read:");
        ID = sc.nextInt();
        return ID;
    }
}