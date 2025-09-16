package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random; // Import the Random class

public class ESPGame {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner keyBoard = new Scanner(System.in);
        Random random = new Random(); // Create a Random object
        PrintWriter outputFile = new PrintWriter("players.txt");

        // variables
        int userGuess, randomPick = 0, round = 0, total = 0; 
        int menuChoice;
        String userName, userDescription, dueDate, color = "";
        String fileName = "colors.txt";
        String option_1 = "Option 1: Display the first 16"
                + " colors from colors.txt ";
        String option_2 = "Option 2: Display the first 10"
                + " colors from colors.txt "; 
        String option_3 = "Option 3: Display the first 5 colors"
                + " from colors.txt ";
        String option_4 = "Option 4: Exit the program";

        Scanner fileScanner = new Scanner(new File(fileName)); 
        
        // Display main menu
        System.out.println("This a guessing game,%n"
                + "and you have 3 rounds to guess the color");
        System.out.printf("Select an option from the menu%n" 
                + "%s%n%s%n%s%n%s%n", option_1, option_2, option_3, option_4);

        menuChoice = keyBoard.nextInt();
        if (menuChoice == 4) {
            System.exit(0); // Exit without an error
        } else {
            System.out.println("File found successfully");

            int counter = 0;
            switch (menuChoice) {
                case 1:
                    while (fileScanner.hasNext() && counter < 16) {                       
                        System.out.println(fileScanner.next());
                        counter++;
                    }
                    break;
                case 2:
                    while (fileScanner.hasNext() && counter < 10) { 
                        System.out.println(fileScanner.next());
                        counter++;
                    }
                    break;
                case 3:
                    while (fileScanner.hasNext() && counter < 5) { 
                        System.out.println(fileScanner.next());
                        counter++;
                    }
                    break;
                default:
                    System.out.print("Error: invalid value");
            }
        }

        while (round < 3) {

            if (menuChoice == 1) {
                randomPick = random.nextInt(16) + 1; // for 1 - 16
                switch (randomPick) {
                    case 1:  color = "black"; break;
                    case 2:  color = "white"; break;
                    case 3:  color = "gray"; break;
                    case 4:  color = "silver"; break;
                    case 5:  color = "maroon"; break;
                    case 6:  color = "red"; break;
                    case 7:  color = "purple"; break;
                    case 8:  color = "fuchsia"; break;
                    case 9:  color = "green"; break;
                    case 10: color = "lime"; break;
                    case 11: color = "olive"; break;
                    case 12: color = "yellow"; break;
                    case 13: color = "navy"; break;
                    case 14: color = "blue"; break;
                    case 15: color = "teal"; break;
                    case 16: color = "aqua"; break;
                    default:
                        System.out.print("Error: invalid value");
                }
            }
            else if (menuChoice == 2) {
                randomPick = random.nextInt(10) + 1; // for 1 - 10
                switch (randomPick) {
                    case 1:  color = "black"; break;
                    case 2:  color = "white"; break;
                    case 3:  color = "gray"; break;
                    case 4:  color = "silver"; break;
                    case 5:  color = "maroon"; break;
                    case 6:  color = "red"; break;
                    case 7:  color = "purple"; break;
                    case 8:  color = "fuchsia"; break;
                    case 9:  color = "green"; break;
                    case 10: color = "lime"; break;
                    default:
                        System.out.print("Error: invalid value");
                }	
            }
            else if (menuChoice == 3) {
                randomPick = random.nextInt(5) + 1; // for 1 - 5
                switch (randomPick) {
                    case 1:  color = "black"; break;
                    case 2:  color = "white"; break;
                    case 3:  color = "gray"; break;
                    case 4:  color = "silver"; break;
                    case 5:  color = "maroon"; break;
                    default:
                        System.out.print("Error: invalid value");
                }	
            }

           
            if (menuChoice == 1) {
                System.out.println("I'm thinking of a color, can you guess what it is (1–16): ");
            } else if (menuChoice == 2) {
                System.out.println("I'm thinking of a color, can you guess what it is (1–10): ");
            } else if (menuChoice == 3) {
                System.out.println("I'm thinking of a color, can you guess what it is (1–5): ");
            }

            userGuess = keyBoard.nextInt();

            // Validation to match menu choice
            boolean validGuess = false;
            if (menuChoice == 1 && (userGuess >= 1 && userGuess <= 16)) validGuess = true;
            if (menuChoice == 2 && (userGuess >= 1 && userGuess <= 10)) validGuess = true;
            if (menuChoice == 3 && (userGuess >= 1 && userGuess <= 5)) validGuess = true;

            // If vaildGuess is not its original value of false skip output block
            if (!validGuess) {
                System.out.println("Error: invalid value");
            } else if (userGuess == randomPick) {
                    System.out.println("Great job! You got it! The color is " + color);
                    total++;
                } else {
                    System.out.println("Oh no, the correct choice was "
                            + color + ". Let's try again!");
                }
            
            round++;
        }
    	
        keyBoard.nextLine(); 
        
        // Get user's information
        System.out.print("What is your name: ");
        userName = keyBoard.nextLine();
        System.out.print("Describe yourself: ");
        userDescription = keyBoard.nextLine();
        System.out.print("Due Date: ");
        dueDate = keyBoard.nextLine();

        // Print user's information
        System.out.println("Enter your name: " + userName);
        System.out.println("Describe yourself: " + userDescription);
        System.out.println("Due Date: " + dueDate);

        // Print the total score
        System.out.println("Game Over");
        System.out.printf("You guessed %d out of 3 colors correctly: %n", total);

        // Write to file
        outputFile.println("Due Date: " + dueDate);
        outputFile.println("Enter your name: " + userName);
        outputFile.println("Describe yourself: " + userDescription);

        keyBoard.close();
        outputFile.close();
        fileScanner.close();
    }
}
