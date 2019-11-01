package database;

import model.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HistoryBookingDB  extends DB{
    public static String SEPARATOR = "|";
    public static String filename = "D://NTU CS/Java/MOBLIMA/src/HistoryBooking.txt";

    public static ArrayList<Review> readData(){
        ArrayList<Review> All = new ArrayList<Review>();
        try{
            ArrayList StringArray = (ArrayList)read(filename);
            for (int i = 0; i < StringArray.size(); i++) {
                String st = (String)StringArray.get(i);
                StringTokenizer star = new StringTokenizer(st, SEPARATOR);
                // get review component
                int MovieID = Integer.parseInt(star.nextToken().trim());
                String MovieName = (star.nextToken().trim());
                String Email = (star.nextToken().trim());
                String comment = (star.nextToken().trim());

                Review review = new Review(MovieID, MovieName, Email, comment);
                All.add(review);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return All;
    }

    public static void SaveData(ArrayList<Review> All){
        List ReviewList = new ArrayList();
        for (int i = 0; i < All.size(); i++){
            Review review = All.get(i);
            StringBuilder stb = new StringBuilder();
            stb.append(review.getMovieID());
            stb.append(SEPARATOR);
            stb.append(review.getMovieName());
            stb.append(SEPARATOR);
            stb.append(review.getEmail());
            stb.append(SEPARATOR);
            stb.append(review.getComment());
            ReviewList.add(stb.toString());
        }
        try{
            write(filename, ReviewList);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
