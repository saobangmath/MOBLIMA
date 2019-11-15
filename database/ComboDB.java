package database;

import model.Combo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * saving and storing Combo database
 * @author Tran Anh Tai
 */
public class ComboDB extends DB{
    private static String filename = "combo.txt";
    private  static String SEPARATOR = "|";

    /**
     * get all available combo history in the database
     * @return combo list
     */
    public static ArrayList readData(){
        ArrayList<Combo> alr = new ArrayList();
        try{
            ArrayList StringArray = (ArrayList)read(filename);
            for (int i = 0; i < StringArray.size(); i++){
                String st = (String)StringArray.get(i);
                StringTokenizer star = new StringTokenizer(st, SEPARATOR);
                long transactionId = Long.parseLong(star.nextToken().trim());
                int movieID = Integer.parseInt(star.nextToken().trim());
                String email = star.nextToken().trim();
                int popcorn = Integer.parseInt(star.nextToken().trim());
                int drink = Integer.parseInt(star.nextToken().trim());
                Combo combo = new Combo(transactionId, movieID, email, popcorn, drink);
                alr.add(combo);
            }
        }
        catch (IOException e){
            System.out.println("IOException > " + e.getMessage());
        }
        return alr;
    }

    /**
     * save the Combo list back to the database by overriding the text file
     * @param alr
     */
    public static void saveData(ArrayList alr){
        ArrayList alw = new ArrayList();
        for (int i = 0; i < alr.size(); i++){
            Combo combo = (Combo) alr.get(i);
            StringBuilder stb = new StringBuilder();
            stb.append(combo.getTransactionId());
            stb.append(SEPARATOR);
            stb.append(combo.getShowtimeID());
            stb.append(SEPARATOR);
            stb.append(combo.getEmail());
            stb.append(SEPARATOR);
            stb.append(combo.getPopcorn());
            stb.append(SEPARATOR);
            stb.append(combo.getDrink());
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
