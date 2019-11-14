package model;

/**
 * Represents combo of popcorn and drink
 * @author Tran Anh Tai
 */
public class Combo {
    private String email;
    private int movieID;
    private int popcorn;
    private int drink;

    /**
     * constructor to create a Combo object
     * @param movieID
     * @param email
     * @param popcorn
     * @param drink
     */
    public Combo(int movieID, String email, int popcorn, int drink){
        this.movieID = movieID;
        this.email = email;
        this.popcorn = popcorn;
        this.drink =  drink;
    }

    /**
     * get the movieID where the person order the combo
     * @return movieID
     */
    public int getMovieID(){
        return this.movieID;
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
}
