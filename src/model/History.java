package model;
import java.util.ArrayList;
public class History extends DateTime{
    private int ID;
    private String email;
    private int showtimeId;
    private String transactionDate;
    private String transactionTime;
    private int price;
    private int noTicket;
    private ArrayList<Character> seatRow;
    private ArrayList<Integer> seatCol;


    public History(int IDInput, String emailInput, int showtimeIdInput, String transactionDateInput, String transactionTimeInput,
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

    public int getID(){return this.ID;}

    public String getEmail(){return this.email;}

    public int getShowtimeId(){return this.showtimeId;}

    public String getTransactionDate(){return this.transactionDate;}

    public String getTransactionTime(){return this.transactionTime;}

    public int getPrice(){return this.price;}

    public int getNoTicket(){return this.noTicket;}

    public ArrayList<Character> getSeatRow(){return this.seatRow;}

    public ArrayList<Integer> getSeatCol(){return this.seatCol;}

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