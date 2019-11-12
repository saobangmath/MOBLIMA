package controller;

import database.HistoryBookingDB;
import model.Booking;

import java.util.ArrayList;

public class BookingController {
    static private ArrayList<Booking> AllBooking;
    private HistoryBookingDB histDB = new HistoryBookingDB();
    public  BookingController(){
        this.AllBooking = histDB.readData();
    }

    public static ArrayList<Booking> getAllBooking() {
        return AllBooking;
    }
}
