package database;

import model.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This module saving and reading the data from the Review database
 * @author Tran Anh Tai
 */
public class ReviewDB extends DB {
    public static String SEPARATOR = "|";
    public static String filename = "D://NTU CS/Java/MOBLIMA/src/review.txt";
    public static ArrayList readData(){
        ArrayList alr = new ArrayList();
        try{
            ArrayList stringArray = (ArrayList)read(filename);
            for (int i = 0; i < stringArray.size(); i++){
                String st = (String)stringArray.get(i);
                StringTokenizer star = new StringTokenizer(st, SEPARATOR);
                int movieID = Integer.parseInt(star.nextToken().trim());
                String  email = star.nextToken().trim();
                String comment = star.nextToken().trim();
                Review review = new Review(movieID, email, comment);
                alr.add(review);
            }
        }
        catch (IOException e){
            System.out.println("Exception > " + e.getMessage());
        }
        return alr;
    }

    public static void saveData(ArrayList alr){
        List alw = new ArrayList();
        for (int i = 0; i < alr.size(); i++){
            Review review = (Review)alr.get(i);
            StringBuilder stb = new StringBuilder();
            stb.append(review.getMovieID());
            stb.append(SEPARATOR);
            stb.append(review.getEmail());
            stb.append(SEPARATOR);
            stb.append(review.getComment());
            alw.add(stb.toString());
        }
        try{
            write(filename, alw);
        }
        catch (IOException e){
            System.out.println("Exception > " + e.getMessage());
        }
    }
}
