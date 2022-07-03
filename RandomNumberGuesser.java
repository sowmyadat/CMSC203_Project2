import java.util.*;

/*
 * Class: CMSC203 
 * Instructor:
 * Description: A random number guesser game that generates a random number, then asks the user for input to guess the random number. 
 * Due: 2/23/2021
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Sowmya Datla
*/

public class RandomNumberGuesser {
	public static void main(String[] args) {
		System.out.println("Random Number Guesser Program - Sowmya Datla");
		
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		
		while(repeat) {
		
			String again;
			int randNum = RNG.rand();
			int nextGuess = 0, highGuess = 99, lowGuess = 0;
			int numGuesses = 0;
			boolean isValid;
			
			System.out.println("Enter your first guess");
			nextGuess = input.nextInt();
			
			isValid = RNG.inputValidation(nextGuess, lowGuess, highGuess); 
			System.out.println("Number of guesses is "+RNG.getCount());
			
			if(isValid) {
				if(nextGuess > randNum) {
					System.out.println("Your guess is too high");
					highGuess = nextGuess; 
				} else if(nextGuess < randNum) {
					System.out.println("Your guess is too low");
					lowGuess = nextGuess;
				}
			}
			
			while(nextGuess != randNum) {
				System.out.println("Enter your next guess between "+lowGuess+" and "+highGuess);
				nextGuess = input.nextInt();
				
				isValid = RNG.inputValidation(nextGuess, lowGuess, highGuess);
				System.out.println("Number of guesses is "+RNG.getCount());
				
				if(isValid) {
					if(nextGuess > randNum) {
						System.out.println("Your guess is too high");
						highGuess = nextGuess;
					} else if(nextGuess < randNum) {
						System.out.println("Your guess is too low");
						lowGuess = nextGuess;
					}
				}
			}
			
			System.out.println("Congratulations, you guessed correctly");
			System.out.println("Try again? (yes or no)");
			again = input.next();
			
			if(again.equals("no")) {
				repeat = false;
				System.out.println("Thanks for playing...");
			} else if(again.equals("yes")) {
				repeat = true;
				RNG.resetCount();
			}
		
		}
	}
}
