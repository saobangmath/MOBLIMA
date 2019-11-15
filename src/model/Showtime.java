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
     * constructor
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
     *
     * @return showtimeID
     */
    public int getID(){ return this.ID; };

    /**
     *
     * @return MovieID corresponding to the showtime
     */
    public int getMovieId(){return this.movieId;}

    /**
     *
     * @return cineplexId corresponding to showtime
     */
    public int getCineplexId(){return this.cineplexId;}

    /**
     *
     * @return cinema ID corresponding to the showtime
     */
    public int getCinemaId(){return this.cinemaId;}

    /**
     *
     * @return get date
     */
    public String getDate(){return this.date;}

    /**
     *
     * @return start time
     */
    public String getStartTime(){return this.startTime;}

    /**
     *
     * @return endtime
     */
    public String getEndTime() {return this.endTime;}

}