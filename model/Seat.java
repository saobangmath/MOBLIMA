package model;

public class Seat {
    private char row;
    private int col;
    private int showtimeId;
    private boolean occupied; // false for non-occupied
    private boolean vip;
    private int price;

    public Seat( char rowInput, int colInput, int showtimeIdInput, boolean occupiedInput, boolean vipInput, int priceInput){
        this.row = rowInput;
        this.col = colInput;
        this.showtimeId = showtimeIdInput;
        this.occupied  = occupiedInput;
        this.vip = vipInput;
        this.price = priceInput;
    }

    public char getSeatRow(){ return this.row; };

    public int getSeatCol(){ return this.col;}

    public int getShowtimeId(){return this.showtimeId;}

    public boolean getOccupied(){return this.occupied;}

    public boolean getVip(){return this.vip;}

    public void setOccupied(boolean occ){ this.occupied = occ;}

    public int getPrice(){return this.price;}

    public void setPrice(int price){ this.price = price;}

}