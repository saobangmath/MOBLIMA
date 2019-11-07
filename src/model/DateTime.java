package model;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.Calendar;
public class DateTime {

    public static boolean validateDate(String dateInput){ //date format is DD/MM/YYYY
        dateInput = dateInput.trim();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try{
            format.parse(dateInput);
        }
        catch(ParseException e){
            return false;
        }
        return true;
    }

    public static boolean validateTime(String timeInput){ //time format is hh:mm
        timeInput = timeInput.trim();
        try{
            LocalTime.parse(timeInput);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    public static boolean validateWeekend(String dateInput){
        dateInput = dateInput.trim();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try{
            c.setTime(format.parse(dateInput));
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            if(dayOfWeek == 1 || dayOfWeek == 7){
                return true;
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }

}