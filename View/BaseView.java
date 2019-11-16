package View;
import java.util.Scanner;
public abstract class BaseView{
    
  public static int readID(){
    int ID;
    Scanner sc = new Scanner(System.in);   
    System.out.println("Input ID to continue:");   
    ID = sc.nextInt();
    return ID;
  }
}