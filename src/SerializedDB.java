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
            System.out.println("Who are you? \n" +
                    "Enter 1 for Admin Mode \n" +
                    "Enter 2 for viewer Mode \n" +
                    "Enter any other keys for exiting \n");
            try{
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
                            for (int i = 0; i < admins.size(); i++) {
                                Admin ad = admins.get(i);
                                if (ad.getName().equals(admin_name) &&
                                        ad.getPassword().equals(admin_password)) {
                                    authentication = true;
                                    break;
                                }
                            }
                            if (authentication) {
                                System.out.println("Authentication \n");
                                // TODO - forward to the next page of amending database}
                            }
                            else {
                                System.out.println("NOT AN ADMIN YET! \n");
                                // TODO - back to the main}
                            }
                        }

                        catch (IOException e) {
                            System.out.println("database connection Error!");
                        }

                        catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;

                    default:
                        stop = true;
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Please re-enter your choice!\n");
                sc.nextLine(); // flush the nextline character!
            }
        }
    }
    // database set up
    private static void Initialization() {
        ArrayList<Admin>admins = new ArrayList<>();
        admins.add(new Admin("Tai", "tai123"));
        admins.add(new Admin("Khanh", "khanh123"));
        admins.add(new Admin("Rich", "rich123"));
        admins.add(new Admin("Ryan", "ryan123"));
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
