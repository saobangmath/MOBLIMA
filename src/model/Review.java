package model;

/**
 * Represents Review object
 * @author Tran Anh Tai
 */
public class Review {
    private int MovieID;
    private String email, comment;

    /**
     * constructor to create new Review object
     * @param MovieID
     * @param email
     * @param comment
     */
    public Review(int MovieID, String email, String comment){
        this.MovieID = MovieID;
        this.email = email;
        this.comment = comment;
    }

    /**
     * get MovieID from such review
     * @return MovieID
     */
    public int getMovieID() {
        return this.MovieID;
    }

    /**
     * get userEmail from such review
     * @return userEmail
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * get comment from the user object to such movie
     * @return comment
     */
    public String getComment() {
        return this.comment;
    }
}
