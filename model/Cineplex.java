package model;
import java.util.ArrayList;

/**
 * represents Cineplex class
 * @author Phung Minh Khanh
 */
public class Cineplex {
    private String name;
    private int ID;
    private String location;
    private ArrayList<Integer> availableMovie = new ArrayList<Integer>();

    /**
     * constructor to build a cineplex  object
     * @param nameInput
     * @param IDInput
     * @param locationInput
     * @param availableMovieInput
     */
    public Cineplex(String nameInput, int IDInput, String locationInput, ArrayList<Integer> availableMovieInput){
        location = locationInput;
        ID = IDInput;
        name = nameInput;
        availableMovie = availableMovieInput;
    }

    /**
     * get cineplex ID
     * @return cineplexID
     */
    public int getID(){ return this.ID; };

    /**
     * get the cineplex location
     * @return location
     */
    public String getLocation(){return this.location; }

    /**
     * get the cineplex name
     * @return name
     */
    public String getName() {return this.name;}

    /**
     * get the list of available movie in the cineplex
     * @return available movie
     */
    public ArrayList<Integer> getAvailableMovie() {return this.availableMovie;}

    /**
     * check whether a movieId in the Cineplex
     * @param movieId
     * @return
     */
    public boolean checkAvailableMovie(int movieId){
        return this.availableMovie.contains(movieId);
    }

    /**
     *
     * @return the concatenation of all Available movie in String format
     */
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
