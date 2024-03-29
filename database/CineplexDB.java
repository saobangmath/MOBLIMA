package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.Cineplex;

/**
 * cineplex database
 * @author Phung Minh Khanh
 */
public class CineplexDB extends DB{
    public static final String SEPARATOR = "|";
    public static final String filename = "D://NTU CS/Java/MOBLIMA/src/cineplex.txt";

    /**
     *
     * @returna list of available cineplexes
     */
    // an example of reading
    public static ArrayList readData() {
        ArrayList alr = new ArrayList() ;// to store Professors data
        try{
            // read String from text file
            ArrayList stringArray = (ArrayList)read(filename);
            for (int i = 0 ; i < stringArray.size() ; i++) {
                String st = (String)stringArray.get(i);
                // get individual 'fields' of the string separated by SEPARATOR
                StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","
                int ID = Integer.parseInt(star.nextToken().trim());
                String  name = star.nextToken().trim();	// first token
                String location = star.nextToken().trim();
                ArrayList<Integer> availableMovie = new ArrayList<Integer>();
                if(star.countTokens() > 0){
                    String[]  availableMovieRaw = star.nextToken().trim().split(","); // third token
                    for(int j = 0 ; j < availableMovieRaw.length; j++){
                        availableMovie.add(Integer.parseInt(availableMovieRaw[j]));
                    }
                }
                Cineplex cine = new Cineplex(name, ID, location, availableMovie);
                alr.add(cine);
            }
        }
        catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
        return alr ;
    }

    /**
     * save back the ArrayList to the cineplex database
     * @param al
     */
    // an example of saving
    public static void saveData(List al) {
        List alw = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < al.size() ; i++) {
            Cineplex cine = (Cineplex)al.get(i);
            StringBuilder st =  new StringBuilder() ;
            st.append(cine.getID());
            st.append(SEPARATOR);
            st.append(cine.getName().trim());
            st.append(SEPARATOR);
            st.append(cine.getLocation().trim());
            st.append(SEPARATOR);
            st.append(cine.stringifyAvailableMovie().trim());
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