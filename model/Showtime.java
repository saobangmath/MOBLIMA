package model;

/**
 * represent Showtime class
 * @author Phung Minh Khanh
 */
public class Showtime extends DateTime {
    private int ID;
    private int movieId;
    private int cineplexId;
    private int cinemaId;
    private String date; //date format is DD/MM/YYYY
    private String startTime; // time format is hh:mm
    private String endTime; // time format is hh:mm

    /**
     * constructor of a showtime object
     * @param IDInput
     * @param movieIdInput
     * @param cineplexIdInput
     * @param cinemaId
     * @param dateInput
     * @param startTimeInput
     * @param endTimeInput
     */
    public Showtime(int IDInput, int movieIdInput, int cineplexIdInput, int cinemaId, String dateInput, String startTimeInput, String endTimeInput){
        this.ID = IDInput;
        this.movieId = movieIdInput;
        this.cineplexId = cineplexIdInput;
        this.cinemaId = cinemaId;
        this.date = dateInput;
        this.startTime = startTimeInput;
        this.endTime = endTimeInput;
    }

    /**
     * get showtime ID
     * @return showtimeID
     */
    public int getID(){ return this.ID; };

    /**
     * get showtime corresponding movie ID 
     * @return MovieID corresponding to the showtime
     */
    public int getMovieId(){return this.movieId;}

    /**
     * get showtime corresponding cineplex ID
     * @return cineplexId corresponding to showtime
     */
    public int getCineplexId(){return this.cineplexId;}

    /**
     * get showtime corresponding cinema ID
     * @return cinema ID corresponding to the showtime
     */
    public int getCinemaId(){return this.cinemaId;}

    /**
     * get showtime corresponding date
     * @return get date
     */
    public String getDate(){return this.date;}

    /**
     * get showtime corresponding starting time
     * @return start time
     */
    public String getStartTime(){return this.startTime;}

    /**
     * get showtime corresponding ending time
     * @return endtime
     */
    public String getEndTime() {return this.endTime;}

}