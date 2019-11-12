package Interface;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import controller.*;
import model.*;
import java.util.ArrayList;
import java.util.Random;
public class BookingInterface {
    static Scanner sc = new Scanner(System.in);
    static int movieID, cineplexID, showtimeID, noTicket, cinemaID, price, historyID;
    static ArrayList<Character> rows = new ArrayList<Character>();
    static ArrayList<Integer> cols = new ArrayList<Integer>();
    static String date, email, transactionDate, transactionTime, seatString;
    static boolean process = true;
    static boolean discount;
    static MovieGoer movieGoer;
    public static void view() {
        MovieController.readDB();
        MovieGoerController.readDB();
        CineplexController.readDB();
        CinemaController.readDB();
        ShowtimeController.readDB();
        SeatController.readDB();
        HistoryController.readDB();
        while(process){
            MovieController.displayAll();
            movieIDInput();

            CineplexController.displayAll();
            cineplexIDInput();

            ShowtimeController.displayByCineplex(cineplexID);
            dateInput();
            showtimeIDInput();

            noTicketInput();
            System.out.println("x denotes empty, o denotes occupied");
            cinemaID = ShowtimeController.read(showtimeID).getCinemaId();
            ShowtimeController.displaySeatMap(showtimeID, CinemaController.read(cinemaID));
            seatNumberInput();
            discountInput();
            emailInput();
            confirm();
        }
        for(int i = 0; i < noTicket; i++){
            SeatController.updateOccupied(rows.get(i), cols.get(i), showtimeID, price);
        }
        transactionDate = DateTime.getCurrentDate();
        transactionTime = DateTime.getCurrentTime();
        Random rand = new Random();
        historyID = rand.nextInt(1000000000);
        History history = new History(historyID, email, showtimeID, transactionDate, transactionTime, price, noTicket, rows, cols);
        HistoryController.create(history);
        if(!MovieGoerController.checkExist(email)){
            MovieGoerController.create(movieGoer);
        }

        MovieController.saveDB();
        MovieGoerController.saveDB();
        CineplexController.saveDB();
        CinemaController.saveDB();
        ShowtimeController.saveDB();
        SeatController.saveDB();
        HistoryController.saveDB();
    }

    public static void movieIDInput(){
        while(true){
            try{
                System.out.println("Please input movie ID to continue");
                movieID = sc.nextInt();
                sc.nextLine();
                if(MovieController.checkExist(movieID)){
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid movie ID");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                System.out.print("\n");
            }
        }
    }

    public static void cineplexIDInput(){
        while(true){
            try{
                System.out.println("Please input cineplex ID to continue");
                cineplexID = sc.nextInt();
                sc.nextLine();
                if(CineplexController.checkExist(cineplexID)){
                    if(!CineplexController.read(cineplexID).checkAvailableMovie(movieID)){
                        throw new InvalidKeyException("This cineplex does not have this movie");
                    }
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid cineplex ID");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                System.out.print("\n");
            }
        }
    }

    public static void dateInput(){
        while(true){
            try{
                System.out.println("Please input date to continue (dd/MM/yyyy)");
                date = sc.nextLine();
                if(Showtime.validateDate(date)){
                    if(!ShowtimeController.validateShowtime(cineplexID, date)){
                        throw new InvalidKeyException("There is no showtime for this movie in this cineplex on this date");
                    };
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid date format does not exist");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }

    public static void showtimeIDInput(){
        while(true){
            try{
                System.out.println("Please input showtime ID to continue");
                showtimeID = sc.nextInt();
                sc.nextLine();
                if(ShowtimeController.checkExist(showtimeID)){
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid showtime ID");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                System.out.print("\n");
            }
        }
    }

    public static void noTicketInput(){
        while(true){
            try{
                System.out.println("Please input number of tickets to continue");
                noTicket = sc.nextInt();
                sc.nextLine();
                if(1 <= noTicket && noTicket < 10){
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid number of ticket");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                System.out.print("\n");
            }
        }
    }

    public static void seatNumberInput(){
        String seatInput;
        char row;
        int col;
        while(true){
            rows.clear();
            cols.clear();
            try{
                System.out.println("Please input seat numbers to continue. You are allowed to input " + noTicket + " seats");
                System.out.println("Each seat number is seperated by , Eg: G14, A12");
                seatInput = sc.nextLine();
                String[] arr = seatInput.split(",");
                if(arr.length != noTicket){
                    throw new InvalidKeyException("The number of seats is not equal to the number of tickets");
                }
                for(int i = 0; i < noTicket; i++){
                    row  = arr[i].charAt(0);
                    col = Integer.parseInt(arr[i].substring(1));
                    if(SeatController.checkExist(row, col, showtimeID)){
                        rows.add(row);
                        cols.add(col);
                    }else{
                        throw new InvalidKeyException("Invalid Seat Number");
                    }
                }
                seatString = seatInput;
                break;
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                System.out.print("\n");
            }
        }
    }
    public static void discountInput(){
        int dc;
        while(true){
            try{
                System.out.println("Please input 1 if you are student/senior to receive discount otherwise input 0");
                dc = sc.nextInt();
                sc.nextLine();
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
                System.out.print("\n");
            }
        }
    }

    public static void emailInput(){
        String name;
        int age, mobile;
        while(true){
            try{
                System.out.println("Please input your email");
                email = sc.nextLine();
                if(MovieGoer.validateEmail(email)){
                    if(MovieGoerController.checkExist(email)){
                        movieGoer = MovieGoerController.read(email);
                    }
                    else{
                        System.out.println("You have not registered to our system before. Please provide your personal information:");
                        System.out.println("Please input your name");
                        name = sc.nextLine();
                        System.out.println("Please input your age");
                        age = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Please input your mobile number");
                        mobile = sc.nextInt();
                        sc.nextLine();
                        movieGoer = new MovieGoer(email, age, name, mobile);
                    }
                    break;
                }
                else{
                    throw new InvalidKeyException("Invalid email format");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                System.out.print("\n");
            }
        }
    }

    public static void confirm(){
        Movie movie = MovieController.read(movieID);
        Cineplex cineplex = CineplexController.read(cineplexID);
        Cinema cinema = CinemaController.read(cinemaID);
        Showtime showtime = ShowtimeController.read(showtimeID);
        price = 0;
        for(int i = 0; i < noTicket; i++){
            Seat seat = SeatController.read(rows.get(i), cols.get(i), showtimeID);
            boolean vip = false, special = false;
            if(Showtime.validateWeekend(showtime.getDate())){
                special = true;
            }
            if(seat.getVip()){
                vip = true;
            }
            price += Price.getPrice(vip, special, discount);
        }
        System.out.println("Please confirm your booking:");
        System.out.println("Movie: "+ movie.getName());
        System.out.println("Cineplex: " + cineplex.getName());
        System.out.println("Cinema: " + cinema.getName());
        System.out.println("Showtime: " + showtime.getDate() + "  " + showtime.getStartTime() + " to "+ showtime.getEndTime());
        System.out.println("Number of ticket: "+ noTicket);
        System.out.println("Seat number: " + seatString);
        System.out.println("Discount: "+ discount);
        System.out.println("Price: "+ price);
        System.out.println("Email: "+ movieGoer.getEmail());
        System.out.println("Name: "+ movieGoer.getName());
        System.out.println("Age: " + movieGoer.getAge());
        System.out.println("Mobile: " + movieGoer.getMobile());
        char cf;
        while(true){
            try{
                System.out.println("Confirm booking Y/N");
                cf = sc.nextLine().charAt(0);
                if(cf == 'Y'){
                    process = false; //terminate the main while loop
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
                System.out.print("\n");
            }
        }
    }
}