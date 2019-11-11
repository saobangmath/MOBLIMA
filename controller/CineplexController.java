package controller;
import java.util.ArrayList;
import database.CineplexDB;
import model.Cineplex;
public class CineplexController{

    private static ArrayList<Cineplex> listCineplex = new ArrayList<Cineplex>();

    public static void readDB(){
        listCineplex = CineplexDB.readData();
    }

    public static void saveDB(){
        CineplexDB.saveData(listCineplex);
    }
    
    public static boolean create(Cineplex cineplex){
        if(checkExist(cineplex.getID())){
            return false;
        }
        cineplex.stringifyAvailableMovie();
        listCineplex.add(cineplex);
        return true;
    }

    public static Cineplex read(int ID){
        for(int i = 0; i < listCineplex.size(); i++){
            if(listCineplex.get(i).getID() == ID){
                return listCineplex.get(i);
            }
        }   
        return null;   
    }
    public static boolean checkExist(int ID){
        for(int i = 0; i < listCineplex.size(); i++){
            if(listCineplex.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

    public static boolean delete(int ID){
        for(int i = 0; i < listCineplex.size(); i++){
            if(listCineplex.get(i).getID() == ID){
                listCineplex.remove(i);
                return true;
            }
        }   
        return false;   
    }

    public static boolean update(Cineplex cineplex){
        for(int i = 0; i < listCineplex.size(); i++){
             if(listCineplex.get(i).getID() == cineplex.getID()){
                listCineplex.set(i, cineplex);
                return true;
            }
        }   
        return false;           
    }

    public static void displayAll(){
        System.out.println("All cineplexes:");
        for(int i = 0; i< listCineplex.size(); i++){
            output(listCineplex.get(i));
        }
    }

    public static void displayByID(int ID){
        for(int i = 0; i< listCineplex.size(); i++){
            if(listCineplex.get(i).getID() == ID){
                output(listCineplex.get(i));
            }
        }
    }

    public static void output(Cineplex cineplex){
        System.out.println("ID: "+ cineplex.getID());
        System.out.println("Name: " + cineplex.getName());
        System.out.println("Location: "+ cineplex.getLocation());
        System.out.println("Available movies: " + cineplex.getAvailableMovie());
        System.out.print("\n");
    }
}