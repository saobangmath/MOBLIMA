package model;
import java.util.ArrayList;
public class Cineplex {
    private String name;
    private int ID;
    private String location;
    private ArrayList<Integer> availableMovie = new ArrayList<Integer>();

    public Cineplex(String nameInput, int IDInput, String locationInput, ArrayList<Integer> availableMovieInput){
        location = locationInput;
        ID = IDInput;
        name = nameInput;
        availableMovie = availableMovieInput; 
    }

    public int getID(){ return this.ID; };

    public String getLocation(){return this.location; }

    public String getName() {return this.name;}

    public ArrayList<Integer> getAvailableMovie() {return this.availableMovie;}

    public boolean checkAvailableMovie(int movieId){return this.availableMovie.contains(movieId);};

    public String stringifyAvailableMovie(){
        String result = new String("");
        if(this.availableMovie.size() == 0){
            return result;
        }
        int  i;
        for(i = 0 ; i < this.availableMovie.size() - 1; i++){
            result = result + String.valueOf(this.availableMovie.get(i)) + ",";
        }
        result = result + String.valueOf(this.availableMovie.get(i));
        return result;
    }


}