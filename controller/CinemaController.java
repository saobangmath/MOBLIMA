package controller;
import java.util.ArrayList;
import database.CinemaDB;
import model.Cinema;
import controller.CineplexController;
public class CinemaController{

    private static ArrayList<Cinema> listCinemas = new ArrayList<Cinema>();

    public static void readDB(){
        listCinemas = CinemaDB.readData();
    }

    public static void saveDB(){
        CinemaDB.saveData(listCinemas);
    }
    
    public static Cinema read(int ID){
        for(int i = 0; i < listCinemas.size(); i++){
            if(listCinemas.get(i).getID() == ID){
                return listCinemas.get(i);
            }
        }
        return null;
    }
    public static boolean create(Cinema cinema){
        if(checkExist(cinema.getID())){
            return false;
        }
        listCinemas.add(cinema);
        return true;
    }

    public static boolean checkExist(int ID){
        for(int i = 0; i < listCinemas.size(); i++){
            if(listCinemas.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

    public static boolean delete(int ID){
        for(int i = 0; i < listCinemas.size(); i++){
            if(listCinemas.get(i).getID() == ID){
                listCinemas.remove(i);
                return true;
            }
        }   
        return false;   
    }

    public static boolean update(Cinema cinema){
        for(int i = 0; i < listCinemas.size(); i++){
             if(listCinemas.get(i).getID() == cinema.getID()){
                listCinemas.set(i, cinema);
                return true;
            }
        }   
        return false;           
    }

    public static void displayAll(){
        System.out.println("All cine");
        for(int i = 0; i< listCinemas.size(); i++){
            output(listCinemas.get(i));
        }
    }

    public static void displayByID(int ID){
        for(int i = 0; i< listCinemas.size(); i++){
            if(listCinemas.get(i).getID() == ID){
                output(listCinemas.get(i));
                return;
            }
        }
    }

    public static void displayByCineplex(int cineplexId) {
        for(int i = 0; i< listCinemas.size(); i++){
            if(listCinemas.get(i).getCineplexId() == cineplexId){
                output(listCinemas.get(i));
            }
        }
    }

    public static void output(Cinema cinema){
        System.out.println("ID: "+ cinema.getID());
        System.out.println("Name: " + cinema.getName());
        System.out.println("Cineplex: " + CineplexController.read(cinema.getCineplexId()).getName());
        System.out.println("Number of rows: "+ cinema.getRow());
        System.out.println("Number of columns: " + cinema.getCol());
        System.out.print("\n");
    }
}