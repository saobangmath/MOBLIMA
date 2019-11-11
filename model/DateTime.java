package model;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date; 
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

    public static String plusMinutes(String timeInput, int minutes){
        timeInput = timeInput.trim();
        try{
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            Date d = df.parse(timeInput);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            cal.add(Calendar.MINUTE, minutes);
            String newTime = df.format(cal.getTime());
            return newTime;
        }
        catch(Exception e){
            return null;
        }
    }

    public static int compareDate(String date1, String date2){
        try{
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date d1 = format.parse(date1);
            Date d2 = format.parse(date2);
            return d1.compareTo(d2);
        }
        catch(Exception e){
            return -1000000;
        }
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

    public static String getCurrentDate(){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(); 
        return format.format(date);
    }

    public static String getCurrentTime(){
        DateFormat format = new SimpleDateFormat("HH:mm");
        Date date = new Date();   
        return format.format(date);
    }
}