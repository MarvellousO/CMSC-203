// This is a ESPGame2 (Extra sensory) program.
import java.util.Scanner;
import java.util.Random; // Import the Random class

public class ESPGame2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random(); // Create a Random object

        // name variables
        int userGuess, randomPick, total = 0;
        String userName, userDescription, dueDate, color="";

        // Get user's information
        System.out.print("What is your name: ");
        userName = keyboard.nextLine();
        System.out.print("Describe yourself: ");
        userDescription = keyboard.nextLine();
        System.out.print("Due Date: ");
        dueDate = keyboard.nextLine();

        // Print user's information
        System.out.println("Enter your name: " + userName);
        System.out.println("Describe yourself: " + userDescription);
        System.out.println("Due Date: " + dueDate);
	
	// Instructions
	System.out.println("This a guessing game and you have 10 tries to guess the color");
	
	System.out.println("each number from 0 to 4 represent a color");
	System.out.println("0 = Red" +
			   " 1 = Green" +
		           " 2 = Blue" +
		           " 3 = Orange" +
		           " 4 = Yellow");
        
	// Create a loop for the game
        for (int i = 1; i <= 10; i++) {
            randomPick = random.nextInt(5);
            System.out.println("I'm thinking of a color, can you guess what it is: ");
            userGuess = keyboard.nextInt();

	    // Initialize color
	    color = ""; 
	
	if (userGuess < 0 || userGuess > 4) {
        System.out.println("Error: invalid value");
    } else {
           
	 switch (randomPick) {
                case 0:
                    color = "Red";
                    break;
                case 1:
                    color = "Green";
                    break;
                case 2:
                    color = "Blue";
                    break;
                case 3:
                    color = "Orange";
                    break;
                case 4:
                    color = "Yellow";
                    break;
		default:
		    System.out.print( "Error: invaid value" );
            }
		

            if (userGuess == randomPick) {
                System.out.println("Great job! You got it! The color is " + color);
                total += 1;
            } else {
                System.out.println("Oh no, the correct choice was " + color + ". Let's try again!");
            }
        }

        // Print the total score
        System.out.println("Total correct guesses: " + total);
    }
  }
}


