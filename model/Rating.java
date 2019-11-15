package model;

/**
 * Represents Rating object
 * @author Tran Anh Tai
 */
public class Rating {
    private int movieID;
    private float rating;
    private String email;

    /**
     * constructor for creating a Rating object
     * @param movieID
     * @param email
     * @param rating
     */
    public Rating(int movieID, String email, float rating){
        this.movieID = movieID;
        this.rating = rating;
        this.email = email;
    }

    /**
     * get the rating rate for a Rating
     * @return rating
     */
    public float getRating() {
        return this.rating;
    }

    /**
     * get movieID corresponding to the rating
     * @return movieID
     */
    public int getMovieID() {
        return this.movieID;
    }

    /**
     * get user email who rated
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

}
