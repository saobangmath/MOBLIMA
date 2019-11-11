package Interface;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import model.Showtime;
import controller.*;
import model.Movie;
public class ShowtimeInterface extends BaseInterface{
    public static void view()  {
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
            choice = sc.nextLine().charAt(0);
            System.out.print("\n");
            switch(choice){
                case '1':
                    ShowtimeController.displayAll();
                    break;
                case '2':
                    id = readID();
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
                    if(!ShowtimeController.delete(readID())){
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
    Movie movie;
    Scanner sc = new Scanner(System.in);
    while(true){
        try{
            System.out.print("ID: ");
            ID = sc.nextInt();
            sc.nextLine();
            System.out.print("\n");

            MovieController.displayAll();
            System.out.print("MovieID: ");
            movieId = sc.nextInt();
            sc.nextLine();
            movie = MovieController.read(movieId);
            System.out.print("\n");   

            CineplexController.displayAll();
            System.out.print("CineplexID: ");
            cineplexId = sc.nextInt();
            sc.nextLine();
            System.out.print("\n");   

            if(!CineplexController.checkExist(cineplexId)){
                throw new InvalidKeyException("The cineplex ID not exist");
            }
            if(!CineplexController.read(cineplexId).checkAvailableMovie(movieId)){
                throw new InvalidKeyException("The movie is not showed at this cineplex. Please update available movies in cineplex first.");
            }

            CinemaController.displayByCineplex(cineplexId);;
            System.out.print("CinemaID: ");
            cinemaId = sc.nextInt();
            sc.nextLine();
            System.out.print("\n"); 
            if(!CinemaController.checkExist(cinemaId)){
                throw new InvalidKeyException("The cinema ID not exist");
            }

            System.out.println("Movie showing time from " + movie.getStartDate() + " to "+ movie.getEndDate());
            System.out.print("Date (dd/MM/yyyy): ");
            date = sc.nextLine();
            if(!Showtime.validateDate(date)){
                throw new InvalidKeyException("Invalid date type please input as dd/MM/yyyy");
            }
            else{
                if(Showtime.compareDate(date, movie.getStartDate()) < 0 || Showtime.compareDate(date, movie.getEndDate()) > 0){
                    throw new InvalidKeyException("Date input is out of movie's date range");
                }
            }
            System.out.print("\n");

            System.out.print("Start time (hh:mm): ");
            startTime = sc.nextLine();
            if(!Showtime.validateTime(startTime)){
                throw new InvalidKeyException("Invalid time type please input as hh:mm");
            }
            System.out.print("\n");
            break;
        } catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
            continue;
        }
    }
    endTime = Showtime.plusMinutes(startTime, movie.getDuration());
    return new Showtime(ID, movieId, cineplexId, cinemaId, date, startTime, endTime);
  }

}