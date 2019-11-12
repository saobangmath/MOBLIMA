package controller;
import java.util.ArrayList;
import database.CineplexDB;
import model.Cineplex;
public class CineplexController{

    private static ArrayList<Cineplex> listCineplex = new ArrayList<Cineplex>();

    public static void readDB(){
        listCineplex = CineplexDB.readData();
    }

    public static void saveDB() {
        CineplexDB.saveData(listCineplex);
    }

    public static boolean create(Cineplex cineplex){
        if(checkExist(cineplex.getID())){
            return false;
        }
        listCineplex.add(cineplex);
        CineplexDB.saveData(listCineplex);
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
                CineplexDB.saveData(listCineplex);
                return true;
            }
        }
        return false;
    }

    public static boolean update(Cineplex cineplex){
        for(int i = 0; i < listCineplex.size(); i++){
            if(listCineplex.get(i).getID() == cineplex.getID()){
                listCineplex.set(i, cineplex);
                CineplexDB.saveData(listCineplex);
                return true;
            }
        }
        return false;
    }

    public static void displayAll(){
        for(int i = 0; i< listCineplex.size(); i++){
            System.out.println("ID: "+ listCineplex.get(i).getID());
            System.out.println("Name: " + listCineplex.get(i).getName());
            System.out.println("Location: "+ listCineplex.get(i).getLocation());
            System.out.println("\n");
        }
    }

    public static void displayByID(int ID){
        for(int i = 0; i< listCineplex.size(); i++){
            if(listCineplex.get(i).getID() == ID){
                System.out.println("ID: "+ listCineplex.get(i).getID());
                System.out.println("Name: " + listCineplex.get(i).getName());
                System.out.println("Location: "+ listCineplex.get(i).getLocation());
                System.out.println("\n");
            }
        }
    }
}