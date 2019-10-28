package model;

public class Movie {
    private String name;
    private int ID;
    private String category;
    private String description;
    private float overallRating;
    private String director;
    private String cast;
    private int restriction;

    public Movie(String nameInput, int IDInput, String categoryInput, String descriptionInput, 
        String directorInput, String castInput, int restrictionInput, float overallRatingInput){
        this.name = nameInput;
        this.ID = IDInput;
        this.category = categoryInput;
        this.description = descriptionInput;
        this.overallRating = overallRatingInput;
        this.director = directorInput;
        this.cast = castInput;
        this.restriction = restrictionInput;
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
}