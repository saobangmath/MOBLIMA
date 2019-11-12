package model;

public class Cinema {
    private String name;
    private int ID;
    private int cineplexId;
    private int cinemaClass; //1: normal, 2:platinum suite 3: elite
    private int row;
    private int col;

    public Cinema(String nameInput, int IDInput, int cineplexIdInput, int rowInput, int colInput, int cinemaClassInput){
        this.name = nameInput;
        this.ID = IDInput;
        this.cineplexId = cineplexIdInput;
        this.row = rowInput;
        this.col = colInput;
        this.cinemaClass = cinemaClassInput;
    }

    public int getID(){ return this.ID; };

    public int getRow(){return this.row; }

    public int getCol() {return this.col;}

    public int getCineplexId() {return this.cineplexId;}

    public String getName(){return this.name;}

    public int getCinemaClass(){return this.cinemaClass;}

    public String getCinemaClassDetail(){
        if(this.cinemaClass == 1){
            return "Normal";
        }
        else if(this.cinemaClass == 2){
            return "Platinum Suite";
        }
        else if(this.cinemaClass == 3){
            return "Elite";
        }
        return null;
    }

}