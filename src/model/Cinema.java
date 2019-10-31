package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable {
    private int CineplexID, SeatNo;
    private String name;
    private boolean isOccupied[];
    private ArrayList<Movie> availableMovies;
    public Cinema(int CineplexID, int SeatNo, String name){
        this.CineplexID = CineplexID;
        this.SeatNo = SeatNo;
        this.name =  name;
        this.isOccupied = new boolean[SeatNo];
        this.availableMovies = new ArrayList<Movie>();
    }


}
