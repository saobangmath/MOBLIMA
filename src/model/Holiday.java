package model;

/**
 *
 * @author Phung Minh Khanh
 */
public class Holiday extends DateTime{
    private String date;

    /**
     * constructor of the Holiday object
     * @param dateInput
     */
    public Holiday(String dateInput){
        this.date = dateInput;
    }

    /**
     * @return holiday date in String
     */
    public String getDate(){return this.date;}
}