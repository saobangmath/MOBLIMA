package Interface;
import controller.ReviewController;

import java.util.Scanner;

public class ReviewInterface {
    private static ReviewController reviewController = new ReviewController();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        while(!stop){
            try{
                System.out.println();
                System.out.println("Please input your choice to continue: ");
                System.out.println("1. Add your own review for a movie: ");
                System.out.println("2. View all reviews with a specific movie: ");
                System.out.println("3. Exit");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        reviewController.AddReview("anhtai@gmail.com");
                        break;
                    case 2:
                        reviewController.RetrieveAllReview();
                        break;
                    case 3:
                        stop = true;
                        break;
                    default:
                        System.out.println("Please enter a valid choice!");
                        break;
                }
            }
            catch (Exception e){
                System.out.println("Please enter a valid choice!");
            }
        }
    }
}
