package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.Cinema;

public class CinemaDB extends DB{
	public static final String SEPARATOR = "|";
	public static final String filename = "cinema.txt";
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
                int cineplexId = Integer.parseInt(star.nextToken().trim());
                int row = Integer.parseInt(star.nextToken().trim());
                int col = Integer.parseInt(star.nextToken().trim());
				Cinema cine = new Cinema(name, ID, cineplexId, row, col);
				alr.add(cine);
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
				Cinema cine = (Cinema)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(cine.getID());
				st.append(SEPARATOR);
				st.append(cine.getName().trim());
				st.append(SEPARATOR);
				st.append(cine.getCineplexId());
                st.append(SEPARATOR);
				st.append(cine.getRow());
                st.append(SEPARATOR);
				st.append(cine.getCol());
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