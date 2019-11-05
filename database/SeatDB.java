package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.Seat;

public class SeatDB extends DB{
	public static final String SEPARATOR = "|";
	public static final String filename = "seat.txt";
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
                char row = star.nextToken().trim().charAt(0);
                int col = Integer.parseInt(star.nextToken().trim());
                int showtimeId = Integer.parseInt(star.nextToken().trim());
                boolean occupied = Boolean.parseBoolean(star.nextToken().trim());
				boolean vip = Boolean.parseBoolean(star.nextToken().trim());
				int price = Integer.parseInt(star.nextToken().trim());
				Seat seat = new Seat(row, col, showtimeId, occupied, vip, price);
				alr.add(seat);
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
				Seat seat = (Seat)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(seat.getSeatRow());
                st.append(SEPARATOR);
				st.append(seat.getSeatCol());
				st.append(SEPARATOR);
				st.append(seat.getShowtimeId());
				st.append(SEPARATOR);
				st.append(seat.getOccupied());
                st.append(SEPARATOR);
				st.append(seat.getVip());
                st.append(SEPARATOR);
				st.append(seat.getPrice());
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