package database;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DB {
    /** Write fixed content to the given file. */
    public static void write(String filename, List data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(filename));
        try{
           for (int i = 0; i < data.size(); i++){
               out.println((String) data.get(i));
           }
        }
        finally {
            out.close();
        }
    }
    /** read the contents of the given file*/
    public static List read(String filename) throws IOException{
        List data = new ArrayList();
        Scanner scanner = new Scanner(new FileInputStream(filename));
        try{
            while (scanner.hasNextLine()){
                data.add(scanner.nextLine());
            }
        }
        finally {
            scanner.close();
        }
        return data;
    }
}
