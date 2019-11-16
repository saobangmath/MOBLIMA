package database;


import model.Rating;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This module saving and reading the data from Rating database
 * @author Tran Anh Tai
 */
public class RatingDB extends DB{
    public static String filename = "rating.txt";
    public static String SEPARATOR = "|";
	 /**
     * 
     * @return an arrayList of the Rating objects in the database
     */
    public static ArrayList readData(){
        ArrayList alr = new ArrayList();
        try{
            ArrayList StringArray = (ArrayList)read(filename);
            for (int i = 0; i < StringArray.size(); i++){
                String st = (String)StringArray.get(i);
                StringTokenizer star = new StringTokenizer(st, SEPARATOR);
                int MovieID = Integer.parseInt(star.nextToken().trim());
                String email = star.nextToken().trim();
                float rating = Float.parseFloat(star.nextToken().trim());
                Rating MovieRating = new Rating(MovieID, email ,rating);
                alr.add(MovieRating);
            }
        }
        catch (IOException e){
            System.out.println("IOException >" + e.getMessage());
        }
        return alr;
    }
	/**
     * save back the Rating List to the database
     * @param alr List of Rating stored back to the database
     */
    public static void saveData(List alr){
        ArrayList alw = new ArrayList();
        for (int i = 0; i < alr.size(); i++){
            Rating MovieRating = (Rating) alr.get(i);
            StringBuilder stb = new StringBuilder();
            stb.append(MovieRating.getMovieID());
            stb.append(SEPARATOR);
            stb.append(MovieRating.getEmail());
            stb.append(SEPARATOR);
            stb.append(MovieRating.getRating());
            alw.add(stb.toString());
        }
        try{
            write(filename, alw);
        }
        catch (IOException e){
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
