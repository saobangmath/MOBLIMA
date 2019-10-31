package Interface;

public class DisplayInterface {
    public void Welcome(){
        System.out.println("Welcome to our MOBLIMA!");
        System.out.println("1. Admin Mode");
        System.out.println("2. MovieGoer Mode");
        System.out.println("Enter your choice:");
    }
    public void InvalidNotification(){
        System.out.println("Please enter a valid choice!");
    }
    public void AdminInstructionDisplay(){
        System.out.println("Please input your choice to continue: ");
        System.out.println("1. Configuring the System data");
        System.out.println("2. DisPlay top 5 movie rank by Ratings: ");
        System.out.println("3. Display top 2 movie rank by Viewers: ");
        System.out.println("4. View history booking: ");
        System.out.println("5. Exit");
        System.out.print("Your choice: ");
    }
}
