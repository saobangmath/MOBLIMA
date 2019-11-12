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
    private String previewDate;
    private String endDate;
    private int duration;

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

    public int getDuration(){return this.duration;}

    public String getPreviewDate(){return this.previewDate;}

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

    public int getStatusMovie(){
        DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate= new Date();
        try{
            Date startDateParse = formatDate.parse(this.startDate);
            Date endDateParse = formatDate.parse(this.endDate);    
            Date previewDateParse = formatDate.parse(this.previewDate);
            if(currentDate.compareTo(endDateParse) > 0){
                return 3; //already over
            }
            if(currentDate.compareTo(startDateParse) >= 0 && currentDate.compareTo(endDateParse) <=0){
                return 2; // showing
            }
            if(currentDate.compareTo(previewDateParse) >= 0 && currentDate.compareTo(startDateParse) < 0){
                return 1; // preview show
            }  
            return 0; // upcoming      
        }
        catch(Exception e){
            return -1; // error
        }
    }
}