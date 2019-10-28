package controller;
import java.util.ArrayList;
import database.CineplexDB;
import model.Cineplex;
public class CineplexController{

    private ArrayList<Cineplex> listCineplex = new ArrayList<Cineplex>();
    private CineplexDB db = new CineplexDB();

    public CineplexController(){
        listCineplex = db.readData();
    }
    
    public boolean createCineplex(Cineplex cineplex){
        if(checkExistCineplex(cineplex.getID())){
            return false;
        }
        this.listCineplex.add(cineplex);
        this.db.saveData(this.listCineplex);
        return true;
    }

    public boolean checkExistCineplex(int ID){
        for(int i = 0; i < this.listCineplex.size(); i++){
            if(this.listCineplex.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

    public boolean deleteCineplex(int ID){
        for(int i = 0; i < this.listCineplex.size(); i++){
            if(this.listCineplex.get(i).getID() == ID){
                this.listCineplex.remove(i);
                this.db.saveData(this.listCineplex);
                return true;
            }
        }   
        return false;   
    }

    public boolean updateCineplex(Cineplex cineplex){
        for(int i = 0; i < this.listCineplex.size(); i++){
             if(this.listCineplex.get(i).getID() == cineplex.getID()){
                this.listCineplex.set(i, cineplex);
                this.db.saveData(this.listCineplex);
                return true;
            }
        }   
        return false;           
    }

    public void displayCineplex(){
        for(int i = 0; i< this.listCineplex.size(); i++){
            System.out.println("ID: "+ this.listCineplex.get(i).getID());
            System.out.println("Name: " + this.listCineplex.get(i).getName());
            System.out.println("Location: "+ this.listCineplex.get(i).getLocation());
            System.out.println("\n");
        }
    }
}