package Interface;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import controller.*;
import model.*;
public class BookingInterface {
    static Scanner sc = new Scanner(System.in);
    static int movieID, cineplexID, showtimeID, noTicket, cinemaID, col, price;
    static char row;
    static String date, email;
    static boolean process = true;
    static boolean discount;
    public static void main(String[] aArgs)  {
        while(process){
            movieIDInput();
            CineplexController.displayAll();
            cineplexIDInput();
            dateInput();
            ShowtimeController.displayAll();
            showtimeIDInput();
            noTicketInput();
            cinemaID = ShowtimeController.read(showtimeID).getCinemaId();
            ShowtimeController.displaySeatMap(showtimeID, CinemaController.read(cinemaID));
            seatNumberInput();
            emailInput();
        }
        SeatController.updateOccupied(row, col, showtimeID, price);
    }

    public static void movieIDInput(){
        while(true){
            try{
                System.out.println("Please input movie ID to continue");
                movieID = sc.nextInt();
                if(MovieController.checkExist(movieID)){
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid movie ID");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }

    public static void cineplexIDInput(){
        while(true){
            try{
                System.out.println("Please input cineplex ID to continue");
                cineplexID = sc.nextInt();
                if(CineplexController.checkExist(cineplexID)){
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid cineplex ID");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }

    public static void dateInput(){
        while(true){
            System.out.println("Please input date to continue (dd/MM/yyyy)");
            date = sc.next();
            if(Showtime.validateDate(date)){
                break;
            }
            else{
                System.out.println("Invalid date format does not exist");
            }
        }
    }

    public static void showtimeIDInput(){
        while(true){
            try{
                System.out.println("Please input showtime ID to continue");
                showtimeID = sc.nextInt();
                if(ShowtimeController.checkExist(showtimeID)){
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid showtime ID");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }

    public static void noTicketInput(){
        while(true){
            try{
                System.out.println("Please input showtime ID to continue");
                noTicket = sc.nextInt();
                if(1 <= noTicket && noTicket < 10){
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid number of ticket");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }

    public static void seatNumberInput(){
        while(true){
            try{
                System.out.println("Please input Seat row to continue");
                row = sc.next().charAt(0);
                row = Character.toUpperCase(row);
                System.out.println("Please input Seat col to continue");
                col = sc.nextInt();
                if(SeatController.checkExist(row, col, showtimeID)){
                    break;
                }else{
                    throw new InvalidKeyException("Invalid Seat Number");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }
    public static void discountInput(){
        int dc;
        while(true){
            try{
                System.out.println("Please input 1 if you are student/senior to receive discount otherwise input 0");
                dc = sc.nextInt();
                if(dc == 0|| dc == 1 ){
                    discount = (dc == 1) ? true: false;
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid value");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }

    public static void emailInput(){
        while(true){
            try{
                System.out.println("Please input your email");
                email = sc.next();
                if(MovieGoer.validateEmail(email)){
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid email format");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }

    public static void confirm(){
        Movie movie = MovieController.read(movieID);
        Cineplex cineplex = CineplexController.read(cineplexID);
        Cinema cinema = CinemaController.read(cinemaID);
        Showtime showtime = ShowtimeController.read(showtimeID);
        Seat seat =SeatController.read(row, col, showtimeID);
        boolean vip = false, special = false;
        if(Showtime.validateWeekend(showtime.getDate())){
            special = true;
        }
        if(seat.getVip()){
            vip = true;
        }
        price = Price.getPrice(vip, special, discount);
        System.out.println("Please confirm your booking:");
        System.out.println("Movie: "+ movie.getName());
        System.out.println("Cineplex: " + cineplex.getName());
        System.out.println("Cinema " + cinema.getName());
        System.out.println("Showtime: " + showtime.getDate() + "  " + showtime.getStartTime() + " to "+ showtime.getEndTime());
        System.out.println("Number of ticket: "+ noTicket);
        System.out.println("Seat number: " + row+col);
        System.out.println("Discount: "+ discount);
        System.out.println("Email: "+ email);
        System.out.println("Price: "+ price);
        char cf;
        while(true){
            try{
                System.out.println("Confirm booking Y/N");
                cf = sc.next().charAt(0);
                if(cf == 'Y'){
                    process = false;
                    break;
                }
                else if(cf == 'N'){
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid Input");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }
}