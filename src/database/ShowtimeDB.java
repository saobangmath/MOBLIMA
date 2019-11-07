package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.Showtime;

public class ShowtimeDB extends DB{
    public static final String SEPARATOR = "|";
    public static final String filename = "showtime.txt";
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
                int movieId = Integer.parseInt(star.nextToken().trim());
                int cineplexId = Integer.parseInt(star.nextToken().trim());
                int cinemaId = Integer.parseInt(star.nextToken().trim());
                String  date = star.nextToken().trim();
                String  startTime = star.nextToken().trim();
                String  endTime = star.nextToken().trim();
                Showtime showtime = new Showtime(ID, movieId, cineplexId, cinemaId, date, startTime, endTime);
                alr.add(showtime);
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
            Showtime showtime = (Showtime)al.get(i);
            StringBuilder st =  new StringBuilder() ;
            st.append(showtime.getID());
            st.append(SEPARATOR);
            st.append(showtime.getMovieId());
            st.append(SEPARATOR);
            st.append(showtime.getCineplexId());
            st.append(SEPARATOR);
            st.append(showtime.getCinemaId());
            st.append(SEPARATOR);
            st.append(showtime.getDate().trim());
            st.append(SEPARATOR);
            st.append(showtime.getStartTime().trim());
            st.append(SEPARATOR);
            st.append(showtime.getEndTime().trim());
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