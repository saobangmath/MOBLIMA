package model;

public class Booking {
    private int MovieID, CinelexID;
    private String userEmail, date;
    public Booking(String userEmail, int MovieID, int CineplexID,String date){
        this.userEmail = userEmail;
        this.MovieID = MovieID;
        this.CinelexID = CineplexID;
        this.date = date;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public int getMovieID() {
        return this.MovieID;
    }

    public int getCinelexID() {
        return this.CinelexID;
    }

    public String getDate() {
        return this.date;
    }
}
