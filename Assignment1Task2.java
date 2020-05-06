package assignment1;

import java.util.Scanner;

public class Assignment1Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("scissor-rock-paper game");
		System.out.println("please enter a number 0, 1 or 2");
		
		System.out.printf("%s", "scissor(0), rock(1), paper(2): ");
		//user input
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		//computer randomly generates a number 0, 1 or 2
		int computerInput = (int) (Math.random() * 3);
		//display computer input
		System.out.printf("%s","The computer is ");
		switch(computerInput) {
		case 0:
			System.out.printf("%s", "scissor. ");
			break;
		case 1:
			System.out.printf("%s", "rock. ");
			break;
		case 2:
			System.out.printf("%s", "paper. ");
			break;
		default:
			System.out.printf("%s", "error input. ");
			break;
		}
		//display user's input
		System.out.printf("%s","You are ");
		switch(userInput) {
		case 0:
			System.out.printf("%s", "scissor. ");
			break;
		case 1:
			System.out.printf("%s", "rock. ");
			break;
		case 2:
			System.out.printf("%s", "paper. ");
			break;
		default:
			System.out.printf("%s", "error input. ");
			break;
		}
		//display who wins the game
		if(computerInput == userInput) {
			System.out.printf("%s\n", "It is a draw.");
		}else {
			boolean win = (userInput == 0 && computerInput == 2) || 
						(userInput == 1 && computerInput == 0) ||
						(userInput == 2 && computerInput == 1);
			if(win) {
				System.out.printf("%s\n", "You won.");
			}else {
				System.out.printf("%s\n", "You lose.");
			}
		}				
		input.close();		
	}
}
