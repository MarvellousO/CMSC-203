package movieapp;

import java.util.Scanner;

public class MovieDriver {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the title of the movie: \n");
            String title = keyboard.nextLine();

            System.out.print("Enter the movie's rating: \n");
            String rating = keyboard.nextLine();

            System.out.print("Enter the number of tickets sold at a theater: \n");
            int soldTickets = keyboard.nextInt();

            Movie movie = new Movie(title,rating, soldTickets);

            System.out.println(movie.toString()+"\n");

            // Ask the user if they want to continue
            System.out.print("Do you want to enter another movie? (y or n): \n ");
            String continueInput = keyboard.next();

            // Check if the user wants to continue
            if (!continueInput.equalsIgnoreCase("y")) {
                keyboard.close();
                System.out.println("Goodbye");
                 // Exit the loop if the user's response is not "y"
                break;
            }
            

            keyboard.nextLine(); 
        }
    }
}