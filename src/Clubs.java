/*
 *Daniel Cancelmo
 *Project 2 -- TTY Golf
 *Lab: Tues. & Thurs. 12:30-1:45
 *TA: Patrick Conway
 *I did not collaborate with anyone on this assignment.
 */

public class Clubs extends Golf {
	
	//Method called from fairway to allow the selection of a club.
	public static int clubChoice (int club, int strength, int distance) {
		//If statement where if the user chooses to quit by entering zero. No new distance is calculated and quit is assigned n.
		if (strength == 0) {
			quit = "n";
			return distance;
		}
		int mean = 0;
		int stddev= 0;
		//Switch-case statement assigns the values of mean and standard deviation (stddev) based on the user's club choice.
		switch (club) {
			//1 is the driver
			case 1:
				mean = 230;
				stddev = 30;
				break;
			//2 is the 3-wood
			case 2:
				mean = 215;
				stddev = 20;
				break;
			//3 is the 3-iron
			case 3:
				mean = 180;
				stddev = 20;
				break;
			//4 is the 4-iron
			case 4:
				mean = 170;
				stddev = 17;
				break;
			//5 is the 5-iron
			case 5:
				mean = 155;
				stddev = 15;
				break;
			//6 is the 6-iron
			case 6:
				mean = 145;
				stddev = 15;
				break;
			//7 is the 7-iron
			case 7:
				mean = 135;
				stddev = 15;
				break;
			//8 is the 8-iron
			case 8:
				mean = 125;
				stddev = 15;
				break;
			//9 is the 9-iron
			case 9:
				mean = 110;
				stddev =10;
				break;
			//10 is the wedge
			case 10:
				mean = 50;
				stddev = 10;
				break;
			default:
				System.out.println("A valid club was not entered. You will be penalized one stroke.");
				break;
		}
		//If statement prevents user from entering an invalid strength.
		if (strength > 10) {
			System.out.println("A valid strength was not entered. You will be penalized one stroke.");
			return distance;
		}
		//ShotDistance is called to calculate the distance of the shot. This is printed and then subtracted out of distance remaining.
		int shotDistance = nextDistance(mean, stddev, strength);
		System.out.println("Your stroke went " + shotDistance + " yards.");
		distance -= shotDistance;
		return distance;
	}
	
	//Method called from green, skipping over club selection.
	public static int putter(int strength, int distance) {
		//Converts distance to feet.
		distance *= 3;
		int mean = 0;
		int stddev= 0;
		//Switch case statement assigns the mean and standard deviation (stddev) values that will be used in the distance calculations depending on the strength entered.
		switch (strength) {
			//Assigns the value n to quit if the user enters zero.
			case 0:
				quit = "n";
				break;
			case 1: 
				mean = 1;
				stddev = 1;
				break;
			case 2: 
				mean = 2;
				stddev = 1;
				break;
			case 3:
				mean = 4;
				stddev = 2;
				break;
			case 4:
				mean = 8;
				stddev = 2;
				break;
			case 5:
				mean = 12;
				stddev = 3;
				break;
			case 6:
				mean = 16;
				stddev = 3;
				break;
			case 7:
				mean = 20;
				stddev = 4;
				break;
			case 8:
				mean = 25;
				stddev = 4;
				break;
			case 9:
				mean = 30;
				stddev = 5;
				break;
			case 10:
				mean = 40;
				stddev = 5;
				break;
			default:
				System.out.println("A valid strength was not entered. You will be penalized one stroke.");
				break;
		}
		//If 0 was entered for strength, this if statement ends the method.
		if (quit.equals("n")) {
			return userPar;
		}
		//nextDistance is called, passing in mean, stddev, and strength.
		int shotDistance = nextDistance(mean, stddev, strength);
		System.out.println("Your stroke went " + shotDistance + " feet.");
		distance -= shotDistance;
		//Converts distance back to yards.
		distance /= 3;
		return distance;
	}
	
	//Method to calculate the distance of a shot. Incorporated into code from given code in assignment.
	public static int nextDistance(int mean, int stddev, int strength) {
	    double mean_adj = mean * strength / 10.0;
	    double stddev_adj = stddev * strength / 10.0;
	    int shotDistance;
	    do {
	        double val = (rand.nextGaussian() * stddev_adj) + mean_adj;
	        shotDistance = (int)val;
	    } while (shotDistance < 0);
	    return shotDistance;
	}
}
