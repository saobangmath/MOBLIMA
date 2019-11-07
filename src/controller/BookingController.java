package controller;

import database.HistoryBookingDB;
import model.Booking;

import java.util.ArrayList;

public class BookingController {
    private ArrayList<Booking> AllBooking;
    private HistoryBookingDB histDB = new HistoryBookingDB();
    public  BookingController(){
        this.AllBooking = histDB.readData();
    }

    public ArrayList<Booking> getAllBooking() {
        return this.AllBooking;
    }
}
