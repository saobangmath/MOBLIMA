package model;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalTime;

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

}