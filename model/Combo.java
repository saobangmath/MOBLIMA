package model;

/**
 * Represents combo of popcorn and drink
 * @author Tran Anh Tai
 */
public class Combo {
    private long transactionID;
    private String email;
    private int showtimeID;
    private int popcorn;
    private int drink;

    /**
     * constructor to create a Combo object
     * @param showtimeID
     * @param email
     * @param popcorn
     * @param drink
     */
    public Combo(long transactionID, int showtimeID, String email, int popcorn, int drink){
        this.transactionID = transactionID;
        this.showtimeID = showtimeID;
        this.email = email;
        this.popcorn = popcorn;
        this.drink =  drink;
    }

    /**
     * get the showtimeID where the person order the combo
     * @return showtimeID
     */
    public int getShowtimeID(){
        return this.showtimeID;
    }
    /**
     * get the email of the person who take this order
     * @return email
     */
    public String getEmail(){
        return this.email;
    }
    /**
     * get number of popcorn buy when booking a film
     * @return popcorn
     */
    public int getPopcorn() {
        return this.popcorn;
    }

    /**
     * get the number of drink buy when booking a film
     * @return drink
     */
    public int getDrink() {
        return this.drink;
    }

    public long getTransactionId(){
        return this.transactionID;
    }
}
