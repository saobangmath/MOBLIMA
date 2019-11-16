package controller;
import java.util.ArrayList;
import database.CinemaDB;
import model.Cinema;

/**
 * all logic operations related to Cinema
 * @author Phung Minh Khanh
 */
public class CinemaController{

    private static ArrayList<Cinema> listCinemas = new ArrayList<Cinema>();

    /**
     * retrieve all availabls cinemas and put into an ArrayList listCinemas
     */
    public static void readDB(){
        listCinemas = CinemaDB.readData();
    }

    /**
     * save back the listCinemas ArrayList to the database
     */
    public static void saveDB(){
        CinemaDB.saveData(listCinemas);
    }

    /**
     *
     * @param ID
     * @return a Cinema with specific ID
     */
    public static Cinema read(int ID){
        for(int i = 0; i < listCinemas.size(); i++){
            if(listCinemas.get(i).getID() == ID){
                return listCinemas.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @param cinema
     * @return if could create a new cinema
     */
    public static boolean create(Cinema cinema){
        if(checkExist(cinema.getID())){
            return false;
        }
        listCinemas.add(cinema);
        CinemaDB.saveData(listCinemas);
        return true;
    }

    /**
     *
     * @param ID
     * @return if a cinema with specific ID existed in the database
     */
    public static boolean checkExist(int ID){
        for(int i = 0; i < listCinemas.size(); i++){
            if(listCinemas.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param ID
     * @return if could delete a cinema with specific ID
     */
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

    /**
     *
     * @param cinema
     * @return if could update a cinema
     */
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

    /**
     * displayb all the cinema details
     */
    public static void displayAll(){
        for(int i = 0; i< listCinemas.size(); i++){
            System.out.println("ID: "+ listCinemas.get(i).getID());
            System.out.println("Name: " + listCinemas.get(i).getName());
            System.out.println("Row Column: "+ listCinemas.get(i).getRow() + " "+ listCinemas.get(i).getCol());
            System.out.println("\n");
        }
    }

    /**
     * display all cinema details with specific ID
     * @param ID
     */
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

    /**
     * display all cinema details with a specific cineplexedId
     * @param cineplexId
     */
    public static void displayByCineplex(int cineplexId) {
        for(int i = 0; i< listCinemas.size(); i++){
            if(listCinemas.get(i).getCineplexId() == cineplexId){
                output(listCinemas.get(i));
            }
        }
    }

    /**
     * display the details of a cinema
     * @param cinema
     */
    public static void output(Cinema cinema){
        System.out.println("ID: "+ cinema.getID());
        System.out.println("Name: " + cinema.getName());
        System.out.println("Cineplex: " + CineplexController.read(cinema.getCineplexId()).getName());
        System.out.println("Number of rows: "+ cinema.getRow());
        System.out.println("Number of columns: " + cinema.getCol());
        System.out.println("Cinema class: " + cinema.getCinemaClassDetail());
        System.out.print("\n");
    }
}