import Models.Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SerializedDB{
    public static void main(String[] args) {
        Initialization();
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        while (!stop){
            try{
                System.out.println("Welcome to our application! \n"+
                                   "Enter 1 for Admin Mode \n"+
                                   "Enter 2 for viewer Mode \n");
                System.out.println("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter your admin username: ");
                        String admin_name = sc.next();
                        System.out.println("Enter your admin password: ");
                        String admin_password = sc.next();
                        try {
                            //open the flat file database
                            FileInputStream infile = new FileInputStream("admin.dat");
                            ObjectInputStream in = new ObjectInputStream(infile);
                            ArrayList<Admin> admins = (ArrayList<Admin>) (in.readObject());
                            boolean authentication = false;
                            // loop to check whether the authentication info in flat file
                            int i = 0;
                            for (i = 0; i < admins.size(); i++) {
                                Admin ad = admins.get(i);
                                if (ad.getUsername().equals(admin_name) &&
                                        ad.getPassword().equals(admin_password)) {
                                    authentication = true;
                                    break;
                                }
                            }
                            if (authentication) {
                                // TODO - forward to the next page of amending database}
                                Admin ad = admins.get(i);
                                System.out.println("Welcome admin " + ad.getName() + " :)");
                                boolean AdminStop = false;
                                System.out.println("Enter 1 for Create/Update/Remove movie listing! \n" +
                                        "Enter 2 for Create/Update/Remove cinema showtimes and movie to be show! \n" +
                                        "Enter 3 for Configure the system settings! \n" +
                                        "Enter any others key for logging out! \n");
                                while (!AdminStop){
                                    System.out.println("Enter your choice:");
                                    int AdminChoice = sc.nextInt();
                                    switch (AdminChoice){
                                        case 1:
                                            ad.MovieListing();
                                            break;
                                        case 2:
                                            ad.CinemaShowTime();
                                            break;
                                        case 3:
                                            ad.SystemConfiguration();
                                            break;
                                        default:
                                            AdminStop = true;
                                            System.out.println("Exit!\n");
                                            break;
                                    }
                                }
                            }
                            else {
                                System.out.println("Not an ADMIN yet! \n");
                            }
                        }

                        catch (IOException e) {
                            System.out.println("database connection Error!");
                        }

                        catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        //TODO need MovieGoer class
                        System.out.println("Movie goer!"); //for debugging only
                        break;
                    default:
                        System.out.println("Please enter a valid choice!");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Please re-enter your choice!\n");
                sc.nextLine(); // flush the nextline character!
            }
        }
        sc.close();
    }
    // database set up
    private static void Initialization() {
        ArrayList<Admin>admins = new ArrayList<>();
        admins.add(new Admin("Tran Anh Tai", "tai123", "Tai"));
        admins.add(new Admin("Phung Minh Khanh", "khanh123", "Khanh"));
        admins.add(new Admin("Rich", "rich123", "Rich"));
        admins.add(new Admin("Ryan", "ryan123", "Ryan"));
        try{
            FileOutputStream fileout = new FileOutputStream("admin.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(admins);
            out.close();
        }
        catch (IOException e){
            System.out.println("Set up database Error!");
        }
    }
}
