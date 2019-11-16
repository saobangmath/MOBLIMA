package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.Movie;

/**
 * movie database
 * @author Phung Minh Khanh
 */
public class MovieDB extends DB{
    public static final String SEPARATOR = "|";
    public static final String filename = "D://NTU CS/Java/MOBLIMA/src/movie.txt";

    /**
     *
     * @return all available movies in the database
     */
    // an example of reading
    public static ArrayList readData() {
        ArrayList alr = new ArrayList() ;// to store Movie data
        try{
            // read String from text file
            ArrayList stringArray = (ArrayList)read(filename);
            for (int i = 0 ; i < stringArray.size() ; i++) {
                String st = (String)stringArray.get(i);
                // get individual 'fields' of the string separated by SEPARATOR
                StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","
                int ID = Integer.parseInt(star.nextToken().trim());
                String  name = star.nextToken().trim();	// first token
                String  category = star.nextToken().trim();
                String  description = star.nextToken().trim();
                String  director = star.nextToken().trim();
                String  cast = star.nextToken().trim();
                int restriction = Integer.parseInt(star.nextToken().trim());
                float overallRating = Float.parseFloat(star.nextToken().trim());
                String startDate = star.nextToken().trim();
                String endDate = star.nextToken().trim();
                String previewDate = star.nextToken().trim();
                int duration = Integer.parseInt(star.nextToken().trim());
                Movie cine = new Movie(name, ID, category, description, director, cast, restriction, overallRating, startDate, endDate, previewDate, duration);
                alr.add(cine);
            }
        }
        catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
        return alr;
    }

    /**
     * save back a movielist to a database
     * @param al
     */
    // an example of saving
    public static void saveData(List al) {
        List alw = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < al.size() ; i++) {
            Movie cine = (Movie)al.get(i);
            StringBuilder st =  new StringBuilder() ;
            st.append(cine.getID());
            st.append(SEPARATOR);
            st.append(cine.getName().trim());
            st.append(SEPARATOR);
            st.append(cine.getCategory().trim());
            st.append(SEPARATOR);
            st.append(cine.getDescription().trim());
            st.append(SEPARATOR);
            st.append(cine.getDirector().trim());
            st.append(SEPARATOR);
            st.append(cine.getCast().trim());
            st.append(SEPARATOR);
            st.append(cine.getRestriction());
            st.append(SEPARATOR);
            st.append(cine.getOverallRating());
            st.append(SEPARATOR);
            st.append(cine.getStartDate());
            st.append(SEPARATOR);
            st.append(cine.getEndDate());
            st.append(SEPARATOR);
            st.append(cine.getPreviewDate());
            st.append(SEPARATOR);
            st.append(cine.getDuration());
            alw.add(st.toString()) ;
        }
        try{
            write(filename,alw);
        }
        catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}