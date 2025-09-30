package classExercise;

import java.util.Scanner;

public class MovieDriverTask2 {
	public static void main(String[] args) {
		Scanner keyBoard = new Scanner(System.in);
		
		String title = " ";
		String rating = " ";
		int soldTickets;
		boolean exit = true;
		
		Movie myMovie = new Movie("Transformers", "PG13", 3000 );
		System.out.println(myMovie.toString());
		
		do {
			System.out.println("Enter the name of the a movie: ");
			title = keyBoard.nextLine();
			
			System.out.println("Enter the rating for the a movie: ");
			rating = keyBoard.nextLine();
			
			System.out.println("Enter the tickets sold for this movie: ");
			soldTickets = keyBoard.nextInt();
			
			keyBoard.nextLine();
			Movie movie = new Movie(title, rating, soldTickets );
			
			System.out.println(movie);
			
			System.out.println("Would you like to enter another (Y or N): ");
			String repeat = keyBoard.nextLine();
			repeat = repeat.toLowerCase();
			
			if(repeat.equals("y")){
				exit = false;
			}else {
				System.out.println("Goodbye");	
				exit = true;
			}
		
		}while(!exit);
		keyBoard.close();
	}
}
