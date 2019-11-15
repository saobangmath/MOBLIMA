package model;
import java.util.ArrayList;

/**
 * represents a class records User Movie booking
 * @author Phung Minh Khanh
 */
public class History extends DateTime{
    private long ID;
    private String email;
    private int showtimeId;
    private String transactionDate;
    private String transactionTime;
    private int price;
    private int noTicket;
    private ArrayList<Character> seatRow;
    private ArrayList<Integer> seatCol;

    /**
     * constructor represent a History object
     * @param IDInput
     * @param emailInput
     * @param showtimeIdInput
     * @param transactionDateInput
     * @param transactionTimeInput
     * @param priceInput
     * @param noTicketInput
     * @param seatRowInput
     * @param seatColInput
     */
    public History(long IDInput, String emailInput, int showtimeIdInput, String transactionDateInput, String transactionTimeInput,
                   int priceInput, int noTicketInput, ArrayList<Character> seatRowInput, ArrayList<Integer> seatColInput){
        this.ID = IDInput;
        this.email = emailInput;
        this.showtimeId = showtimeIdInput;
        this.transactionDate = transactionDateInput;
        this.transactionTime = transactionTimeInput;
        this.price = priceInput;
        this.noTicket = noTicketInput;
        this.seatRow = seatRowInput;
        this.seatCol = seatColInput;
    }

    /**
     * @return historyID
     */
    public long getID(){return this.ID;}

    /**
     * @return user email
     */
    public String getEmail(){return this.email;}

    /**
     *
     * @return showtime id of the booking
     */
    public int getShowtimeId(){return this.showtimeId;}

    /**
     *
     * @return transaction date
     */
    public String getTransactionDate(){return this.transactionDate;}

    /**
     *
     * @return transaction time
     */
    public String getTransactionTime(){return this.transactionTime;}

    /**
     *
     * @return price
     */
    public int getPrice(){return this.price;}

    /**
     *
     * @return number of tickets
     */
    public int getNoTicket(){return this.noTicket;}

    /**
     *
     * @return e
     */
    public ArrayList<Character> getSeatRow(){return this.seatRow;}

    /**
     *
     * @return
     */
    public ArrayList<Integer> getSeatCol(){return this.seatCol;}

    /**
     *
     * @return all row in tickets booking
     */
    public String stringifySeatRow(){
        String result = new String("");
        if(this.seatRow.size() == 0){
            return result;
        }
        int  i;
        for(i = 0 ; i < this.seatRow.size() - 1; i++){
            result = result + String.valueOf(this.seatRow.get(i)) + ",";
        }
        result = result + String.valueOf(this.seatRow.get(i));
        return result;
    }

    /**
     *
     * @return all column in tickets booking
     */
    public String stringifySeatCol(){
        String result = new String("");
        if(this.seatCol.size() == 0){
            return result;
        }
        int  i;
        for(i = 0 ; i < this.seatCol.size() - 1; i++){
            result = result + String.valueOf(this.seatCol.get(i)) + ",";
        }
        result = result + String.valueOf(this.seatCol.get(i));
        return result;
    }
}