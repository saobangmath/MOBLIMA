package controller;
import java.util.ArrayList;
import database.CineplexDB;
import model.Cineplex;

/**
 * represents all cineplex related logic operations
 * @author Phung Minh Khanh
 */
public class CineplexController{

    private static ArrayList<Cineplex> listCineplex = new ArrayList<Cineplex>();

    /**
     * retrieve all cineplexes and put into an ArrayList listCineplex
     */
    public static void readDB(){
        listCineplex = CineplexDB.readData();
    }

    /**
     * save back the listCineplex to the database
     */
    public static void saveDB() {
        CineplexDB.saveData(listCineplex);
    }

    /**
     *
     * @param cineplex
     * @return if could create a new cineplex
     */
    public static boolean create(Cineplex cineplex){
        if(checkExist(cineplex.getID())){
            return false;
        }
        listCineplex.add(cineplex);
        CineplexDB.saveData(listCineplex);
        return true;
    }

    /**
     *
     * @param ID
     * @return a Cineplex with specific ID
     */
    public static Cineplex read(int ID){
        for(int i = 0; i < listCineplex.size(); i++){
            if(listCineplex.get(i).getID() == ID){
                return listCineplex.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @param ID
     * @return if existed a cineplex with specific ID
     */
    public static boolean checkExist(int ID){
        for(int i = 0; i < listCineplex.size(); i++){
            if(listCineplex.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param ID
     * @return if could delete a cineplex
     */
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

    /**
     *
     * @param cineplex
     * @return if could update a cineplex
     */
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

    /**
     * display all cineplex details
     */
    public static void displayAll(){
        for(int i = 0; i< listCineplex.size(); i++){
            System.out.println("ID: "+ listCineplex.get(i).getID());
            System.out.println("Name: " + listCineplex.get(i).getName());
            System.out.println("Location: "+ listCineplex.get(i).getLocation());
            System.out.println("\n");
        }
    }

    /**
     * display a cineplex details with specific ID
     * @param ID
     */
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