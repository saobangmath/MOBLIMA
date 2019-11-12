package moblima;
import model.*;
import controller.*;
import Interface.*;
import database.*;

public class MOBLIMA{
    public static void main(String[] args) {
        readData();
        boolean process = true;
        while(process){
            AvailabilityInterface.view();
            process = false;
        }
        saveData();
    }

    public static void readData(){
        MovieController.readDB();
        MovieGoerController.readDB();
        CinemaController.readDB();
        CineplexController.readDB();
        SeatController.readDB();
        ShowtimeController.readDB();
        HistoryController.readDB();
        HolidayController.readDB();
    }

    public static void saveData(){
        MovieController.saveDB();
        MovieGoerController.saveDB();
        CinemaController.saveDB();
        CineplexController.saveDB();
        SeatController.saveDB();
        ShowtimeController.saveDB();
        HistoryController.saveDB(); 
        HolidayController.readDB();
    }
}