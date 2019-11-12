package model;
public class Holiday extends DateTime{
    private String date;

    public Holiday(String dateInput){
        this.date = dateInput;
    }

    public String getDate(){return this.date;}
}