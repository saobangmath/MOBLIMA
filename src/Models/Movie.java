package Models;

public class Movie {
    private int MovieID;
    private String MovieName,Description, Restriction, Category;
    public Movie(int MovieID){
        this.MovieID = MovieID;
    }
    public Movie(int MovieID, String MovieName, String Description){
        this(MovieID);
        this.MovieName = MovieName;
        this.Description = Description;
    }
    public Movie(int MovieID, String MovieName, String Description, String Category){
        this(MovieID,MovieName,Description);
        this.Category = Category;
    }
}
