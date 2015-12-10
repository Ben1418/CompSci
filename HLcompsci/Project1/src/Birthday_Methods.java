import java.util.Scanner;

public class Birthday_Methods {
	/* Methods for calculating Liklihood of same Birthday program
	 * global variables below
	 */
	int people;
	int days;
	Scanner kb = new Scanner(System.in);
	public void input(){
		System.out.println("How many people are in the class");
		people = kb.nextInt();
		System.out.println("How many days in a year?");
		days = kb.nextInt();
		
	}
	int chance_counter;
	double chance;
	public void calculate(){
		chance_counter = 0;
		for(int i = 1; i < people; i++){
			chance_counter += people - i;
		}
		chance = chance_counter/(days * 1.0);
		System.out.println("chance " + chance);
	}
	public void output(){
		System.out.println("The chance of birthdays coinsiding is " + (chance*100) + "% chance");
	}

}
