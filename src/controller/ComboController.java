package controller;

import database.ComboDB;
import model.Combo;

import java.util.ArrayList;

/**
 * all operations related to Combo objects
 * @author Tran Anh Tai
 */
public class ComboController {
    static ArrayList<Combo> listCombo;

    /**
     * store all available Combo into a ComboList  for internal operations
     */
    public static void readDB(){
        listCombo = ComboDB.readData();
    }

    /**
     * save back to the Combo database with overriding the listCombo to the text database
     */
    public static void saveDB(){
        ComboDB.saveData(listCombo);
    }

    /**
     * create new Combo
     * @param combo
     */
    public static void create(Combo combo){
        listCombo.add(combo);
        saveDB();
    }

    /**
     * display all Combo order of a user with specific email
     * @param email
     */
    public static void display(String email){
        for (int i = 0; i < listCombo.size(); i++){
            Combo combo = listCombo.get(i);
            if (combo.getEmail().equals(email)){
                output(combo);
            }
        }
    }

    /**
     * display a Combo details
     * @param combo
     */
    private static void output(Combo combo) {
        System.out.println("User: " + combo.getEmail() +
                           " has order: " + combo.getPopcorn() +
                           " popcorn and " + combo.getDrink() +
                           " when booking the movie with ID: " + combo.getMovieID());
    }

    /**
     * display all available Combos
     */
    public static void displayAll(){
        for (int i = 0; i < listCombo.size(); i++){
            output(listCombo.get(i));
        }
    }
}
