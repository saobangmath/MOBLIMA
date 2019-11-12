package controller;
import java.util.ArrayList;
import database.HolidayDB;
import model.Holiday;
public class HolidayController{

    private static ArrayList<Holiday> listHoliday = new ArrayList<Holiday>();

    public static void readDB(){
        listHoliday = HolidayDB.readData();
    }

    public static void saveDB(){
        HolidayDB.saveData(listHoliday);
    }
    
    public static boolean create(Holiday holiday){
        if(checkExist(holiday.getDate())){
            return false;
        }
        listHoliday.add(holiday);
        return true;
    }

    public static boolean checkExist(String date){
        for(int i = 0; i < listHoliday.size(); i++){
            if(listHoliday.get(i).getDate().equals(date)){
                return true;
            }
        }
        return false;
    }

    public static boolean delete(String date){
        for(int i = 0; i < listHoliday.size(); i++){
            if(listHoliday.get(i).getDate().equals(date)){
                listHoliday.remove(i);
                return true;
            }
        }   
        return false;   
    }

    public static void displayAll(){
        for(int i = 0; i< listHoliday.size(); i++){
            System.out.println(listHoliday.get(i).getDate());
        }
    }
}