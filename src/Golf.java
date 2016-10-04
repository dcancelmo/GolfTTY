/*
 *Daniel Cancelmo
 *Project 2 -- TTY Golf
 *Lab: Tues. & Thurs. 12:30-1:45
 *TA: Patrick Conway
 *I did not collaborate with anyone on this assignment.
 */

import java.util.Scanner;
import java.util.Random;

public class Golf {

	protected static String quit = "temporary";
	protected static Scanner scan = new Scanner(System.in);
	protected static Random rand = new Random();
	protected static int userPar = 0;

	public static void main(String[] args) {
		
		//Introduction and game set-up
		System.out.println("Welcome to A Little Birdie!");
		System.out.println("When at the tee and in the fairway you can use any club ranging from 1 to 10.");
		System.out.println("1 is a driver, 2 is a 3-wood, 3 is a 3-iron, 4 is a 4-iron and so on ending with 10 representing a wedge.");
		System.out.println("When on the green, you will use a putter.");
		System.out.println("You also choose the strength of your stroke from 1 to 10, with 10 being the hardest.");
		System.out.println("To exit a round before you are done all 18 holes, enter 0 for the strength of your stroke.");
		
		//While loop to keep the game running until the user quits.
		while(!quit.equalsIgnoreCase("n")) {
			System.out.println("\nCourses available:\n0. Quit Game\n1. Waynesbourough Country Club Course\n2. The Castle Course at St. Andrews");
			System.out.print("Please enter your desried course [0-2]: ");
			int course = scan.nextInt();
			userPar = 0;
			int inputValid = 1;
			//Switch-case-break statements to allow selection of courses or to quit.
			switch (course) {
				case 0: 
					quit = "N";
					inputValid = 0;
					break;
				case 1: 
					Courses course1 = new Courses();
					userPar = course1.waynesCourse();
					System.out.println("Your final score for the round is: " + userPar + "\n");
					break;
				case 2:
					Courses course2 = new Courses();
					userPar = course2.castleCourse();
					System.out.println("Your final score for the round is: " + userPar + "\n");
					break;
				default: 
					System.out.println("A valid course number was not entered.");
					inputValid = 0;
					break;
			}
			dialogue(userPar);
			//While loop prevents the user from entering an invalid value.
			while (inputValid != 0) {
				System.out.print("Would you like to play another round [Y/N]: ");
				quit = scan.next();
				if (quit.equalsIgnoreCase("y")) {
					inputValid = 0;
				} else if (quit.equalsIgnoreCase("n")) {
					inputValid = 0;
				} else {
					System.out.println("\nA valid response was not entered.");
					inputValid = 1;
				}
			}
		}
		System.out.println("\nThank you for playing!");
	}

	//Method to create random responses based on how well the user is doing.
	public static void dialogue(int userPar) {
		int dialogue = rand.nextInt(2);
		//Switch-case statement creates random dialogue.
		switch (dialogue) {
			case 0: 
				//If-else-if statement determines how well the player did.
				if (userPar == 0) {
					System.out.println("Congratulations! You made par! A stellar achievement.\n");
				} else if (userPar < 0) {
					System.out.println("Wow, you did better than par!\n");
				} else {
					System.out.println("Good job!\n");
				}
				break;
			case 1: 
				//If-else-if statement determines how well the player did.
				if (userPar == 0) {
					System.out.println("An even game!\n");
				} else if (userPar < 0) {
					System.out.println("You beat par! *golf clap*\n");
				} else {
					System.out.println("Nice playing!\n");
				}	
				break;
			case 2: 
				//If-else-if statement determines how well the player did.
				if (userPar == 0) {
					System.out.println("Your score was zero! Nice, par!\n");
				} else if (userPar < 0) {
					System.out.println("In this game being subpar is a good thing! Congrats!\n");
				} else {
					System.out.println("Better luck next time. You'll get par eventually!\n");
				}
				break;
		}
	}
}