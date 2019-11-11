package model;

public class Rating {
    private int movieID;
    private float rating;
    private String email;
    public Rating(int movieID, String email, float rating){
        this.movieID = movieID;
        this.rating = rating;
        this.email = email;
    }

    public float getRating() {
        return this.rating;
    }

    public int getMovieID() {
        return this.movieID;
    }

    public String getEmail() {
        return this.email;
    }
}
