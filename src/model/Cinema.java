package model;

/**
 * Represents Cinema class
 * @author Phung Minh Khanh
 */
public class Cinema {
    private String name;
    private int ID;
    private int cineplexId;
    private int cinemaClass; //1: normal, 2: platinum suite, 3: elite
    private int row;
    private int col;

    /**
     * constructor for creating the Cinema instance
     * @param nameInput
     * @param IDInput
     * @param cineplexIdInput
     * @param rowInput
     * @param colInput
     * @param cinemaClassInput
     */
    public Cinema(String nameInput, int IDInput, int cineplexIdInput, int rowInput, int colInput, int cinemaClassInput){
        this.name = nameInput;
        this.ID = IDInput;
        this.cineplexId = cineplexIdInput;
        this.row = rowInput;
        this.col = colInput;
        this.cinemaClass = cinemaClassInput;
    }

    /**
     * get the Cinema ID
     * @return cinemaID
     */
    public int getID(){ return this.ID; }

    /**
     *
     * @return
     */
    public int getRow(){return this.row; }

    /**
     *
     * @return
     */
    public int getCol() {return this.col;}

    /**
     * get the cineplexID that the cinema belongs to
     * @return cineplexId
     */
    public int getCineplexId() {return this.cineplexId;}

    /**
     * get the cinema Name
     * @return cinemaName
     */
    public String getName(){return this.name;}

    /**
     * get the class level of the cinema
     * @return cinemaClass
     */
    public int getCinemaClass(){
        return this.cinemaClass;
    }

    /**
     * get such class details
     * @return String in ["Normal", "Platinum Suite", "Elite"]
     */
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