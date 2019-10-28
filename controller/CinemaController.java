package controller;
import java.util.ArrayList;
import database.CinemaDB;
import model.Cinema;
public class CinemaController{

    private ArrayList<Cinema> listCinemas = new ArrayList<Cinema>();
    private CinemaDB db = new CinemaDB();

    public CinemaController(){
        listCinemas = db.readData();
    }
    
    public boolean createCinema(Cinema cinema){
        if(checkExistCinema(cinema.getID())){
            return false;
        }
        this.listCinemas.add(cinema);
        this.db.saveData(this.listCinemas);
        return true;
    }

    public boolean checkExistCinema(int ID){
        for(int i = 0; i < this.listCinemas.size(); i++){
            if(this.listCinemas.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

    public boolean deleteCinema(int ID){
        for(int i = 0; i < this.listCinemas.size(); i++){
            if(this.listCinemas.get(i).getID() == ID){
                this.listCinemas.remove(i);
                this.db.saveData(this.listCinemas);
                return true;
            }
        }   
        return false;   
    }

    public boolean updateCinema(Cinema cinema){
        for(int i = 0; i < this.listCinemas.size(); i++){
             if(this.listCinemas.get(i).getID() == cinema.getID()){
                this.listCinemas.set(i, cinema);
                this.db.saveData(this.listCinemas);
                return true;
            }
        }   
        return false;           
    }

    public void displayCinema(){
        for(int i = 0; i< this.listCinemas.size(); i++){
            System.out.println("ID: "+ this.listCinemas.get(i).getID());
            System.out.println("Name: " + this.listCinemas.get(i).getName());
            System.out.println("Row Column: "+ this.listCinemas.get(i).getRow() + " "+ this.listCinemas.get(i).getCol());
            System.out.println("\n");
        }
    }
}