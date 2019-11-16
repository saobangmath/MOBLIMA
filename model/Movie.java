package model;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

/**
 * @author Phung Minh Khanh
 */
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
    private String previewDate;
    private String endDate;
    private int duration;

    /**
     * constructor of movie object
     * @param nameInput
     * @param IDInput
     * @param categoryInput
     * @param descriptionInput
     * @param directorInput
     * @param castInput
     * @param restrictionInput
     * @param overallRatingInput
     * @param startDateInput
     * @param endDateInput
     * @param previewDateInput
     * @param duration
     */
    public Movie(String nameInput, int IDInput, String categoryInput, String descriptionInput,
                 String directorInput, String castInput, int restrictionInput, float overallRatingInput,
                 String startDateInput, String endDateInput, String previewDateInput, int duration){
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
        this.duration = duration;
        this.previewDate = previewDateInput;
    }

    /**
	 * get movie ID
     * @return movieID
     */
    public int getID(){ return this.ID; };

    /**
	 * get movie name
     * @return movieName
     */
    public String getName(){return this.name;}

    /**
	 * get movie category 
     * @return movie Category
     */
    public String getCategory(){return this.category;}

    /**
	 * get movie description
     * @return movie description
     */
    public String getDescription(){return this.description;}

    /**
	 * get movie director
     * @return movie director
     */
    public String getDirector(){return this.director;}

    /**
	 * get movie cast
     * @return movie casting
     */
    public String getCast() {return this.cast;}

    /**
     * get movie restriction age range
     * @return movie restriction 
     */
    public int getRestriction(){return this.restriction;}

    /**
	 * get movie overall rating
     * @return movie overall rating
     */
    public float getOverallRating(){return this.overallRating;}

    /**
     * set overall rating to a specific number
     * @param overallRating
     */
    public void setOverallRating(float overallRating){this.overallRating = overallRating;};

    /**
     * get movie start date
     * @return movie start date
     */
    public String getStartDate(){return this.startDate;};

    /**
     * get movie end date
     * @return movie end date
     */
    public String getEndDate(){return this.endDate;}

    /**
     * get movie duration 
     * @return movie duration
     */
    public int getDuration(){
        return this.duration;
    }

    /**
     * get movie preview date
     * @return movie preview date 
     */
    public String getPreviewDate(){
        return this.previewDate;
    }

    /**
     * get movie restriction age 
     * @return movie restriction
     */
    public String getRestrictionDetail(){
        //1. No Restriction   2. 10+   3. 16+    4. 18+
        if(this.restriction == 4){
            return "18+";
        }
        else if(this.restriction == 2){
            return "10+";
        }
        else if(this.restriction == 3){
            return "16+";
        }
        else{
            return "No restriction";
        }
    }

    /**
	 * get movie status
     * @return movieStatus: upcoming or over
     */
    public int getStatusMovie(){
        DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate= new Date();
        try{
            Date startDateParse = formatDate.parse(this.startDate);
            Date endDateParse = formatDate.parse(this.endDate);
            if(currentDate.compareTo(startDateParse) < 0){
                return 0; // upcoming Movie
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
