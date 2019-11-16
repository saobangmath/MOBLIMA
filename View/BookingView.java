package View;
import java.util.Scanner;
import javax.management.openmbean.InvalidKeyException;
import controller.*;
import model.*;
import java.util.ArrayList;

/**
 * booking interface
 * @author Phung Minh Khanh
 */
public class BookingView {
    static Scanner sc = new Scanner(System.in);
    static int movieID, cineplexID, showtimeID, noTicket, cinemaID, price, discountPoint, popcorn, drink;
    static float earnedPoint;
    static long historyID;
    static ArrayList<Character> rows = new ArrayList<Character>();
    static ArrayList<Integer> cols = new ArrayList<Integer>();
    static String date, email, transactionDate, transactionTime, seatString;
    static boolean process = true;
    static boolean discount;
    static MovieGoer movieGoer;

    /**
     * main interface display all bookings related operations 
     */
    public static void view() {
        while(process){
            MovieController.displayAll();
            movieIDInput();

            CineplexController.displayAll();
            cineplexIDInput();

            ShowtimeController.displayByCineplex(cineplexID);
            showtimeIDInput();

            noTicketInput();
            System.out.println("x denotes empty, o denotes occupied");
            cinemaID = ShowtimeController.read(showtimeID).getCinemaId();
            Price.displayPrice();
            ShowtimeController.displaySeatMap(showtimeID);
            seatNumberInput();
            discountInput();
            emailInput();
            comboInput();
            discountByRewardPoint();
            confirm();
        }
        for(int i = 0; i < noTicket; i++){
            SeatController.updateOccupied(rows.get(i), cols.get(i), showtimeID, price);
        }
        transactionDate = DateTime.getCurrentDate();
        transactionTime = DateTime.getCurrentTime();
        String transactionID = "" + showtimeID + transactionDate.replace("/", "") + transactionTime.replace(":", "");
        historyID = Long.parseLong(transactionID.trim());
        Combo combo = new Combo(historyID, showtimeID, email, popcorn, drink);
        ComboController.create(combo);
        History history = new History(historyID, email, showtimeID, transactionDate, transactionTime, price, noTicket, rows, cols);
        HistoryController.create(history);
        if(!MovieGoerController.checkExist(email)){
            MovieGoerController.create(movieGoer);
        }
        earnedPoint = earnedPoint - (float)discountPoint;
        MovieGoerController.addRewardPoint(earnedPoint, email);
        process = true;
    }

    /**
     * input a movie ID for a booking
     */
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

    /**
     * input a cineplexID for a booking
     */
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

    /**
     * input showtimeID for a booking
     */
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

    /**
     * input number of tickets for a booking
     */
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

    /**
     * input seat number for corresponding Ticket number
     */
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
                        if(SeatController.checkOccupied(row, col, showtimeID)){
                            throw new InvalidKeyException("Seats are occupied");
                        }
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

    /**
     * input discount input option
     */
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

    /**
     * input moviegoer email
     */
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
                        movieGoer = new MovieGoer(email, age, name, mobile, 0);
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

    /**
     * input combo attached to the movie booking
     */
    public static void comboInput(){
        boolean process = true;
        while (process){
            popcorn = 0;
            drink = 0;
            try{
                System.out.println("Do you want to add any food or drink?");
                System.out.println("Popcorn price: " + Price.POPCORN);
                System.out.println("Drink price: " + Price.DRINK);
                System.out.println("Enter Yes or No (Y/N): ");
                char choice = sc.nextLine().charAt(0);
                if(choice == 'Y'){
                    System.out.println("Enter number of popcorn: ");
                    popcorn = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter number of drink: ");
                    drink = sc.nextInt();
                    sc.nextLine();
                }
                break;
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                System.out.print("\n");
            }
        }
    }

    /**
     * discount by rewardPoint functions to the booking price
     */
    public static void discountByRewardPoint(){
        char yn;
        discountPoint = 0;
        while(true){
            try{
                System.out.println("Your reward point is: " + movieGoer.getRewardPoint());
                System.out.println("Do you want to use reward point to get discount?(Y/N)");
                yn = sc.nextLine().charAt(0);
                if(yn == 'Y'){
                    System.out.println("Input your discount point(Integer only)");
                    discountPoint = sc.nextInt();
                    sc.nextLine();
                    if(discountPoint > movieGoer.getRewardPoint()){
                        throw new InvalidKeyException("Invalid discount point");
                    }
                }
                else{
                    sc.nextLine();
                }
                break;
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                discountPoint = 0;
                System.out.print("\n");
            }
        }
    }

    /**
     * confirm booking details display
     */
    public static void confirm(){
        Movie movie = MovieController.read(movieID);
        Cineplex cineplex = CineplexController.read(cineplexID);
        Cinema cinema = CinemaController.read(cinemaID);
        Showtime showtime = ShowtimeController.read(showtimeID);
        price = 0;
        for(int i = 0; i < noTicket; i++){
            Seat seat = SeatController.read(rows.get(i), cols.get(i), showtimeID);
            boolean vip = false, special = false;
            if(Showtime.validateWeekend(showtime.getDate()) || HolidayController.checkExist(showtime.getDate())){
                special = true;
            }
            if(seat.getVip()){
                vip = true;
            }
            price += Price.getPrice(vip, special, discount, cinema.getCinemaClass());
        }
        price += Price.DRINK*drink + Price.POPCORN*popcorn;
        price -= discountPoint;
        earnedPoint = (float)((float)price)/10;
        System.out.println("Please confirm your booking:");
        System.out.println("Movie: "+ movie.getName());
        System.out.println("Cineplex: " + cineplex.getName());
        System.out.println("Cinema: " + cinema.getName());
        System.out.println("Showtime: " + showtime.getDate() + "  " + showtime.getStartTime() + " to "+ showtime.getEndTime());
        System.out.println("Number of ticket: "+ noTicket);
        System.out.println("Seat number: " + seatString);
        System.out.println("Popcorn: " + popcorn);
        System.out.println("Drink: " + drink);
        System.out.println("Discount: "+ discount);
        System.out.println("Price: "+ price);
        System.out.println("Email: "+ movieGoer.getEmail());
        System.out.println("Name: "+ movieGoer.getName());
        System.out.println("Age: " + movieGoer.getAge());
        System.out.println("Mobile: " + movieGoer.getMobile());
        System.out.println("Earned reward point: " + earnedPoint);
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