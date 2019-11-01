package model;

public class Review {
    private int MovieID;
    private String email, comment, MovieName;
    public Review(int MovieID, String MovieName, String email, String comment){
        this.MovieID = MovieID;
        this.email = email;
        this.MovieName = MovieName;
        this.comment = comment;
    }

    public int getMovieID() {
        return this.MovieID;
    }

    public String getMovieName() {
        return this.MovieName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getComment() {
        return this.comment;
    }
}
