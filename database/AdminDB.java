package database;

import model.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This module process saving and reading the data from the Admin database
 * @author Tran Anh Tai
 */
public class AdminDB extends DB {
    public static final String SEPARATOR = "|";
    public  static final String filename = "D://NTU CS/Java/MOBLIMA/src/Admin.txt";

    /**
     * get all admins from admin database
     * @return all available Admins
     */
    public static ArrayList readData(){
        ArrayList admins = new ArrayList<>(); // storing admin info
        try{
            ArrayList StringArray = (ArrayList)read(filename);
            for (int i = 0; i < StringArray.size(); i++){
                String st = (String)StringArray.get(i);
                //get individual field of the string separator
                StringTokenizer star = new StringTokenizer(st, SEPARATOR);
                String AdminUserName = star.nextToken().trim();
                String AdminPass = star.nextToken().trim();
                String AdminName = star.nextToken().trim();
                Admin admin = new Admin(AdminUserName, AdminPass, AdminName);
                admins.add(admin);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return admins;
    }

    /**
     * save the admins list back to the admin database by overriding the database text file
     * @param admins
     */
    public static void saveData(List admins){
        List adminlist = new ArrayList();
        for (int i = 0; i < admins.size(); i++){
            Admin admin = (Admin)(admins.get(i));
            StringBuilder stb = new StringBuilder();
            // change Admin object to a string
            stb.append(admin.getUsername());
            stb.append(SEPARATOR);
            stb.append(admin.getPassword());
            stb.append(SEPARATOR);
            stb.append(admin.getName());
            stb.append(SEPARATOR);
            stb.append(admin.getEmail());
            // create such string object to a adminList
            adminlist.add(stb.toString());
        }
        try{
            write(filename, adminlist); //overwrite all data in filename
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

