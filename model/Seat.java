package model;

/**
 * represents Seat class
 * @author Phung Minh Khanh
 */
public class Seat {
    private char row;
    private int col;
    private int showtimeId;
    private boolean occupied; // false for non-occupied
    private boolean vip;
    private int price;

    /**
     * constructor of the Seat object
     * @param rowInput
     * @param colInput
     * @param showtimeIdInput
     * @param occupiedInput
     * @param vipInput
     * @param priceInput
     */
    public Seat( char rowInput, int colInput, int showtimeIdInput, boolean occupiedInput, boolean vipInput, int priceInput){
        this.row = rowInput;
        this.col = colInput;
        this.showtimeId = showtimeIdInput;
        this.occupied  = occupiedInput;
        this.vip = vipInput;
        this.price = priceInput;
    }

    /**
     * get seat row
     * @return seat row
     */
    public char getSeatRow(){ return this.row; };

    /**
     * get seat column
     * @return seat column
     */
    public int getSeatCol(){ return this.col;}

    /**
     * get a showtimeId corresponding the seat 
     * @return showtimeId corresponding to the seat
     */
    public int getShowtimeId(){return this.showtimeId;}

    /**
     * get whether a seat is occupied
     * @return whether this seat is occupied
     */
    public boolean getOccupied(){return this.occupied;}

    /**
     * get whether a seat is VIP
     * @return if this seat is for VIP
     */
    public boolean getVip(){return this.vip;}

    /**
     * change the state of a seat be a seated or not
     * @param occ
     */
    public void setOccupied(boolean occ){ this.occupied = occ;}

    /**
     * get the seat price
     * @return seat price
     */
    public int getPrice(){return this.price;}

    /**
     * change seat price to a specific value
     * @param price
     */
    public void setPrice(int price){ this.price = price;}

}