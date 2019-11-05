package controller;
import java.util.ArrayList;
import database.CinemaDB;
import model.Cinema;

public class CinemaController{

    private static ArrayList<Cinema> listCinemas = new ArrayList<Cinema>();

    public static void readDB(){
        listCinemas = CinemaDB.readData();
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
        CinemaDB.saveData(listCinemas);
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
                CinemaDB.saveData(listCinemas);
                return true;
            }
        }   
        return false;   
    }

    public static boolean update(Cinema cinema){
        for(int i = 0; i < listCinemas.size(); i++){
             if(listCinemas.get(i).getID() == cinema.getID()){
                listCinemas.set(i, cinema);
                CinemaDB.saveData(listCinemas);
                return true;
            }
        }   
        return false;           
    }

    public static void displayAll(){
        for(int i = 0; i< listCinemas.size(); i++){
            System.out.println("ID: "+ listCinemas.get(i).getID());
            System.out.println("Name: " + listCinemas.get(i).getName());
            System.out.println("Row Column: "+ listCinemas.get(i).getRow() + " "+ listCinemas.get(i).getCol());
            System.out.println("\n");
        }
    }

    public static void displayByID(int ID){
        for(int i = 0; i< listCinemas.size(); i++){
            if(listCinemas.get(i).getID() == ID){
                System.out.println("ID: "+ listCinemas.get(i).getID());
                System.out.println("Name: " + listCinemas.get(i).getName());
                System.out.println("Row Column: "+ listCinemas.get(i).getRow() + " "+ listCinemas.get(i).getCol());
                System.out.println("\n");
                return;
            }
        }
    }
}