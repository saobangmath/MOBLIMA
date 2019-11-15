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
     * constructor
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
     * @return movieID
     */
    public int getID(){ return this.ID; };

    /**
     * @return movieName
     */
    public String getName(){return this.name;}

    /**
     * @return movie Category
     */
    public String getCategory(){return this.category;}

    /**
     * @return movie description
     */
    public String getDescription(){return this.description;}

    /**
     * @return movie director
     */
    public String getDirector(){return this.director;}

    /**
     * @return movie casting
     */
    public String getCast() {return this.cast;}

    /**
     * @return movie restriction rule
     */
    public int getRestriction(){return this.restriction;}

    /**
     * @return movie overall rating
     */
    public float getOverallRating(){return this.overallRating;}

    /**
     * set te overall rating to a specific float
     * @param overallRating
     */
    public void setOverallRating(float overallRating){this.overallRating = overallRating;};

    /**
     *
     * @return movie start date
     */
    public String getStartDate(){return this.startDate;};

    /**
     *
     * @return movie end date
     */
    public String getEndDate(){return this.endDate;}

    /**
     *
     * @return movie duration
     */
    public int getDuration(){
        return this.duration;
    }

    /**
     *
     * @return movie preview date in String
     */
    public String getPreviewDate(){
        return this.previewDate;
    }

    /**
     *
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
