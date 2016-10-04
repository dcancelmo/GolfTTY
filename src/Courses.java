/*
 *Daniel Cancelmo
 *Project 2 -- TTY Golf
 *Lab: Tues. & Thurs. 12:30-1:45
 *TA: Patrick Conway
 *I did not collaborate with anyone on this assignment.
 */

public class Courses extends Golf {
	
	//Method that will run the first course option (Waynesborough Course)
	public int waynesCourse() {
		System.out.println("\nYou are playing at Waynesborough Country Club.");
		//For loop that calls the method hole 18 times, passing in the yardage and par for each hole.
		for (int i = 0; i <= 18; i++) {
			System.out.println("Hole " + (i + 1));
			//Two arrays holding the necessary information on each of the 18 holes.
			int[] yardage= {369, 407, 441, 188, 420, 220, 547, 373, 447, 457, 420, 341, 401, 175, 554, 436, 254, 539};
			int[] par = {4, 4, 5, 3, 4, 3, 5, 4, 4, 5, 4, 4, 4, 3, 5, 4, 3, 5};
			userPar += hole(yardage[i], par[i]);
			System.out.println("Your score for the round so far is: " + userPar + "\n");
			dialogue(userPar);
			//If statement checks if the user entered zero for strength to quit (because if they did quit would equal n). Breaks the loop if they decided to quit.
			if (quit.equalsIgnoreCase("n")) {
				break;
			}
		}
		return userPar;	
	}
	
	//Method that will run the second course option (Castle Course)
	public int castleCourse() {
		System.out.println("\nYou are playing at The Castle Course at St. Andrews.");
		//For loop that calls the method hole 18 times, passing in the yardage and par for each hole.
		for (int i = 0; i <= 18; i++) {
			System.out.println("Hole " + (i + 1));
			//Two arrays holding the necessary information on each of the 18 holes.
			int[] yardage= {346, 404, 202, 540, 536, 421, 456, 141, 381, 167, 402, 454, 179, 400, 585, 406, 184, 555};
			int[] par = {4, 4, 3, 5, 5, 4, 4, 3, 4, 3, 4, 4, 3, 4, 5, 4, 3, 5};
			userPar += hole(yardage[i], par[i]);
			System.out.println("Your score for the round so far is: " + userPar + "\n");
			dialogue(userPar);
			//If statement checks if the user entered zero for strength to quit (because if they did quit would equal n). Breaks the loop if they decided to quit.
			if (quit.equalsIgnoreCase("n")) {
				break;
			}
		}
		return userPar;
	}
	
	//Method that is called for each hole. 
	public int hole(int yardage, int par) {
		int distance = yardage;
		int shots = 0;
		System.out.println("The hole is " + yardage + " yards and par is " + par + ".");
		//While loop allows the player to keep trying the hole until they get the ball in (within 1 foot).
		while (Math.abs(distance*3) > 1) {
			//If-else-if statement checks all the possible results of a shot that did not make it in and prints the appropriate message, absolute values it if it went past the hole and calls either fairway or green methods.
			if (distance > 20) {
				System.out.println("Your ball is currently " + distance + " yards from the hole.");
				System.out.println("\nThis is stroke " + (shots+1) + " at this hole.");
				distance = fairway(shots, distance);
			} else if (Math.abs(distance) > 20) {
				distance = Math.abs(distance);
				System.out.println("Your ball went past the hole and is currently " + distance + " yards from the hole.");
				System.out.println("\nThis is stroke " + (shots+1) + " at this hole.");
				distance = fairway(shots, distance);
			} else if (distance < 20 && distance > 1) {
				System.out.println("Your ball is currently " + distance*3 + " feet from the hole.");
				System.out.println("\nThis is stroke " + (shots+1) + " at this hole.");
				distance = green(distance);
			} else {
				distance = Math.abs(distance);
				System.out.println("Your ball went past the hole and is currently " + distance*3 + " feet from the hole.");
				System.out.println("\nThis is stroke " + (shots+1) + " at this hole.");
				distance = green(distance);
			}
			//If the user choose to quit the round, this will exit the method hole.
			if (quit.equals("n")) {
				return userPar;
			}
			shots += 1;
			userPar = shots - par;
		}
		System.out.println("You made it in the hole!\n");
		//If statement that prints "par" if they currently have a score of par. Otherwise their current score is printed.
		if (userPar == 0) {
			String score = "par";
			System.out.println("Your score on this hole is : " + score);
		} else {
			int score = userPar;
			System.out.println("Your score on this hole is: " + score);
		}
		return userPar;
	}
	
	//Method that is run when the ball is within 20 yards of the hole and therefore on the green.
	public int green(int distance) {
		System.out.println("\nYou are in the green and are now using the putter.");
		System.out.print("Please enter a strength [1-10]: ");
		int strength = scan.nextInt();
		//Calls method putter in class Clubs. Returns the remaining distance.
		return distance = Clubs.putter(strength, distance);
	}

	//Method that is run for every shot not in the green.
	public int fairway(int shots, int distance) {
		//If-else statement identifies determines if at tee (no shot taken yet) or not.
		if (shots == 0) {
			System.out.println("\nYou are at the tee.");
		} else {
			System.out.println("\nYou are in the fairway.");
		}
		System.out.print("Please enter a club [1-10]: ");
		int club = scan.nextInt();
		System.out.print("Please enter a strength [1-10]: ");
		int strength = scan.nextInt();
		//Calls method clubChoice in class Clubs. Returns the remaining distance.
		return distance = Clubs.clubChoice(club, strength, distance);

	}
}
