package model;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class Movie extends DateTime {
    private String name;
    private int ID;
    private String category;
    private String description;
    private float overallRating;
    private String director;
    private String cast;
    private int restriction;
    private String startDate;
    private String endDate;

    public Movie(String nameInput, int IDInput, String categoryInput, String descriptionInput,
                 String directorInput, String castInput, int restrictionInput, float overallRatingInput,
                 String startDateInput, String endDateInput){
        this.name = nameInput;
        this.ID = IDInput;
        this.category = categoryInput;
        this.description = descriptionInput;
        this.overallRating = overallRatingInput;
        this.director = directorInput;
        this.cast = castInput;
        this.restriction = restrictionInput;
        this.startDate = startDateInput;
        this.endDate = endDateInput;
    }

    public int getID(){ return this.ID; };

    public String getName(){return this.name;}

    public String getCategory(){return this.category;}

    public String getDescription(){return this.description;}

    public String getDirector(){return this.director;}

    public String getCast() {return this.cast;}

    public int getRestriction(){return this.restriction;}

    public float getOverallRating(){return this.overallRating;}

    public void setOverallRating(float overallRating){this.overallRating = overallRating;};

    public String getStartDate(){return this.startDate;};

    public String getEndDate(){return this.endDate;}

    public int getStatusMovie(){
        DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate= new Date();
        try{
            Date startDateParse = formatDate.parse(this.startDate);
            Date endDateParse = formatDate.parse(this.endDate);
            if(currentDate.compareTo(startDateParse) < 0){
                return 0; // upcoming movie
            }
            if(currentDate.compareTo(endDateParse) > 0){
                return 2; // already over
            }
        }
        catch(Exception e){
            return -1; // error
        }
        return 1; // now showing
    }
}
