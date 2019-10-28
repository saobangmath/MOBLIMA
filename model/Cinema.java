package model;

public class Cinema {
    private String name;
    private int ID;
    private int cineplexId;
    private int row;
    private int col;

    public Cinema(String nameInput, int IDInput, int cineplexIdInput, int rowInput, int colInput){
        this.name = nameInput;
        this.ID = IDInput;
        this.cineplexId = cineplexIdInput;
        this.row = rowInput;
        this.col = colInput;
    }

    public int getID(){ return this.ID; };

    public int getRow(){return this.row; }

    public int getCol() {return this.col;}

    public int getCineplexId() {return this.cineplexId;}

    public String getName(){return this.name;}

}