package controller;
import java.util.ArrayList;
import database.HolidayDB;
import model.Holiday;

/**
 * holiday controller
 * @author Phung Minh Khanh
 */
public class HolidayController{

    private static ArrayList<Holiday> listHoliday = new ArrayList<Holiday>();

    /**
     * retrieve all holiday details, then put into the listHoliday ArrayList
     */
    public static void readDB(){
        listHoliday = HolidayDB.readData();
    }

    /**
     * save the ArrayList back to the database text file
     */
    public static void saveDB(){
        HolidayDB.saveData(listHoliday);
    }

    /**
     *
     * @param holiday
     * @return if we could create a new Holiday in the database
     */
    public static boolean create(Holiday holiday){
        if(checkExist(holiday.getDate())){
            return false;
        }
        listHoliday.add(holiday);
        return true;
    }

    /**
     *
     * @param date
     * @return if exists a String date in the holiday database
     */
    public static boolean checkExist(String date){
        for(int i = 0; i < listHoliday.size(); i++){
            if(listHoliday.get(i).getDate().equals(date)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param date
     * @return if we could delete a holiday date in the database
     */
    public static boolean delete(String date){
        for(int i = 0; i < listHoliday.size(); i++){
            if(listHoliday.get(i).getDate().equals(date)){
                listHoliday.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * display all holiday in the database
     */
    public static void displayAll(){
        for(int i = 0; i< listHoliday.size(); i++){
            System.out.println(listHoliday.get(i).getDate());
        }
    }
}