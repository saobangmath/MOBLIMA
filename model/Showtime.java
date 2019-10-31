package model;

public class Showtime extends DateTime {
    private int ID;
    private int movieId;
    private int cineplexId;
    private int cinemaId;
    private String date; //date format is DD/MM/YYYY
    private String startTime; // time format is hh:mm
    private String endTime; // time format is hh:mm

    public Showtime(int IDInput, int movieIdInput, int cineplexIdInput, int cinemaId, String dateInput, String startTimeInput, String endTimeInput){
        this.ID = IDInput;
        this.movieId = movieIdInput;
        this.cineplexId = cineplexIdInput;
        this.cinemaId = cinemaId;
        this.date = dateInput;
        this.startTime = startTimeInput;
        this.endTime = endTimeInput;
    }

    public int getID(){ return this.ID; };

    public int getMovieId(){return this.movieId;}

    public int getCineplexId(){return this.cineplexId;}

    public int getCinemaId(){return this.cinemaId;}

    public String getDate(){return this.date;}

    public String getStartTime(){return this.startTime;}

    public String getEndTime() {return this.endTime;}

}