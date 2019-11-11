package Interface;

import controller.RatingController;

import java.util.Scanner;

public class RatingInterface {
    static public RatingController ratingController = new RatingController();
    public static void main(String[] args) {
        boolean stop =  false;
        Scanner sc = new Scanner(System.in);
        while (!stop){
            try{
                System.out.println();
                System.out.println("Please input your choice to continue: ");
                System.out.println("1. Add your own rating: ");
                System.out.println("2. View all ratings with a specific movie: ");
                System.out.println("3. View average rating for a movie: ");
                System.out.println("4. Exit");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        ratingController.AddRating();
                        break;
                    case 2:
                        ratingController.ViewMovieRatingByID();
                        break;
                    case 3:
                        ratingController.getAverageRatingByID();
                        break;
                    case 4:
                        stop = true;
                        break;
                    default:
                        System.out.println("Please enter a valid choice!");
                }
            }
            catch (Exception e){
                System.out.println("Please enter a valid choice!");
            }
            sc.nextLine();
        }
    }

}
