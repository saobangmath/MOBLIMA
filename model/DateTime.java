package model;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * represent datetime class to process all datetime operation
 * @author Phung Minh Khanh
 */
public class DateTime {
    /**
     * chack whether a String is matched to a Date format
     * @param dateInput
     * @return if a String parse in a Date format
     */
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

    /**
     * check  whether a String is matched to a  time format
     * @param timeInput
     * @return if a String parse in a time format
     */
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

    /**
     * return a String of a time when plus to a specific minutes
     * @param timeInput
     * @param minutes
     * @return a String result of a timeInput plus minutes
     */
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

    /**
     * compare between 2 datetime in String format
     * @param date1
     * @param date2
     * @return a int compare between 2 date String
     */
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

    /**
     * check whether a date String is on the weekend
     * @param dateInput
     * @return a if a dateInput is on the weekend
     */
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

    /**
     * get current date
     * @return a String of the current date
     */
    public static String getCurrentDate(){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return format.format(date);
    }

    /**
     * get current time
     * @return a String of a current time
     */
    public static String getCurrentTime(){
        DateFormat format = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return format.format(date);
    }

}