package model;

public class Review {
    private int MovieID;
    private String email, comment;
    public Review(int MovieID, String email, String comment){
        this.MovieID = MovieID;
        this.email = email;
        this.comment = comment;
    }

    public int getMovieID() {
        return this.MovieID;
    }


    public String getEmail() {
        return this.email;
    }

    public String getComment() {
        return this.comment;
    }
}
