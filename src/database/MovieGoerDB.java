package database;
import model.MovieGoer;

import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

public class MovieGoerDB extends DB{
    public static final String SEPARATOR = "|";
    public static final String filename = "D://NTU CS/Java/MOBLIMA/src/movieGoer.txt";
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
                String  email = star.nextToken().trim();	// first token
                int  age = Integer.parseInt(star.nextToken().trim());	// second token
                String  name = star.nextToken().trim(); // third token
                int mobile = Integer.parseInt(star.nextToken().trim());
                MovieGoer goer = new MovieGoer(email, age, name, mobile);
                alr.add(goer);
            }
        }
        catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
        return alr ;
    }

    // an example of saving
    public static void saveData(List al) {
        List alw = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < al.size() ; i++) {
            MovieGoer goer = (MovieGoer)al.get(i);
            StringBuilder st =  new StringBuilder() ;
            st.append(goer.getEmail().trim());
            st.append(SEPARATOR);
            st.append(goer.getAge());
            st.append(SEPARATOR);
            st.append(goer.getName());
            st.append(SEPARATOR);
            st.append(goer.getMobile());
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