package database;

import model.Booking;
import model.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HistoryBookingDB  extends DB{
    public static String SEPARATOR = "|";
    public static String filename = "D://NTU CS/Java/MOBLIMA/src/HistoryBooking.txt";

    public static ArrayList<Booking> readData(){
        ArrayList<Booking> All = new ArrayList<>();
        try{
            ArrayList StringArray = (ArrayList)read(filename);
            for (int i = 0; i < StringArray.size(); i++) {
                String st = (String)StringArray.get(i);
                StringTokenizer star = new StringTokenizer(st, SEPARATOR);
                // get booking component
                String Email = (star.nextToken().trim());
                int MovieID = Integer.parseInt(star.nextToken().trim());
                int CineplexID = Integer.parseInt(star.nextToken().trim());
                String date = star.nextToken().trim();

                Booking booking = new Booking(Email, MovieID, CineplexID, date);
                All.add(booking);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return All;
    }

    public static void SaveData(ArrayList<Booking> All){
        List BookingList = new ArrayList();
        for (int i = 0; i < All.size(); i++){
            Booking booking = All.get(i);
            StringBuilder stb = new StringBuilder();
            stb.append(booking.getMovieID());
            stb.append(SEPARATOR);
            stb.append(booking.getUserEmail());
            stb.append(SEPARATOR);
            stb.append(booking.getCinelexID());
            stb.append(SEPARATOR);
            stb.append(booking.getMovieID());
            stb.append(SEPARATOR);
            stb.append(booking.getDate());

            BookingList.add(stb.toString());
        }
        try{
            write(filename, BookingList);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
