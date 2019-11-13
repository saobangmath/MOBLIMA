package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.History;

public class HistoryDB extends DB{
    public static final String SEPARATOR = "|";
    public static final String filename = "D://NTU CS/Java/MOBLIMA/src/history.txt";
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
                long ID = Long.parseLong(star.nextToken().trim());
                String  email = star.nextToken().trim();
                int showtimeId = Integer.parseInt(star.nextToken().trim());
                String transactionDate = star.nextToken().trim();
                String transactionTime = star.nextToken().trim();
                int price = Integer.parseInt(star.nextToken().trim());
                int noTicket = Integer.parseInt(star.nextToken().trim());
                ArrayList<Character> seatRow = new ArrayList<Character>();
                if(star.countTokens() > 0){
                    String[]  seatRowRaw = star.nextToken().trim().split(","); // third token
                    for(int j = 0 ; j < seatRowRaw.length; j++){
                        seatRow.add(seatRowRaw[j].charAt(0));
                    }
                }
                ArrayList<Integer> seatCol = new ArrayList<Integer>();
                if(star.countTokens() > 0){
                    String[]  seatColRaw = star.nextToken().trim().split(","); // third token
                    for(int j = 0 ; j < seatColRaw.length; j++){
                        seatCol.add(Integer.parseInt(seatColRaw[j]));
                    }
                }
                History history = new History(ID, email, showtimeId,
                        transactionDate, transactionTime, price, noTicket, seatRow, seatCol);
                alr.add(history);
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
            History history = (History)al.get(i);
            StringBuilder st =  new StringBuilder() ;
            st.append(history.getID());
            st.append(SEPARATOR);
            st.append(history.getEmail().trim());
            st.append(SEPARATOR);
            st.append(history.getShowtimeId());
            st.append(SEPARATOR);
            st.append(history.getTransactionDate().trim());
            st.append(SEPARATOR);
            st.append(history.getTransactionTime().trim());
            st.append(SEPARATOR);
            st.append(history.getPrice());
            st.append(SEPARATOR);
            st.append(history.getNoTicket());
            st.append(SEPARATOR);
            st.append(history.stringifySeatRow());
            st.append(SEPARATOR);
            st.append(history.stringifySeatCol());
            st.append(SEPARATOR);
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