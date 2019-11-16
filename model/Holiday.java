package model;

/**
 * represents Holiday class for special date
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
	 * get the holiday date 
     * @return holiday date in String
     */
    public String getDate(){return this.date;}
}