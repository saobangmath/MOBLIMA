package model;
import java.util.ArrayList;
public class Cineplex {
    private String name;
    private int ID;
    private String location;
    private ArrayList<String> availableMovie = new ArrayList<String>();

    public Cineplex(String nameInput, int IDInput, String locationInput, ArrayList<String> availableMovieInput){
        location = locationInput;
        ID = IDInput;
        name = nameInput;
        availableMovie = availableMovieInput;
    }

    public int getID(){ return this.ID; };

    public String getLocation(){return this.location; }

    public String getName() {return this.name;}

    public ArrayList<String> getAvailableMovie() {return this.availableMovie;}

    public String stringifyAvailableMovie(){
        String result = new String("");
        if(this.availableMovie.size() == 0){
            return result;
        }
        int  i;
        for(i = 0 ; i < this.availableMovie.size() - 1; i++){
            result.concat(this.availableMovie.get(i).trim());
            result.concat(",");
        }
        result.concat(this.availableMovie.get(i).trim());
        return result;
    }


}
