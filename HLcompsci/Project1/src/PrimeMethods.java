import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PrimeMethods {
	//options
	String [] options = {"Check Prime", "Find Primes between", "Prime Factors", "Prime Relativity", "Goldbach conjecture", "Goldbach 2", "Twin Primes Between",  "Exit"};
	//What they choose global variable
	String choice;
	public void input_1(){
		choice =  JOptionPane.showInputDialog(null, "What do you want to do?", "Options", JOptionPane.QUESTION_MESSAGE, null, options, options[0]).toString();
	}
	public boolean check_prime(int num){
		boolean isprime = true;
		for(int i = 2; i < (int)(Math.sqrt(num)) + 1; i++){
			if(num % i == 0){
				isprime = false;
			}
		}
		return isprime;
	}
	public ArrayList<Integer> primes_between(int a, int b){
		ArrayList<Integer> array = new ArrayList<Integer>(0);
		for(int i = a+1; i < b; i++){
			if(check_prime(i)){
				if(i != 1)
					array.add(i);
			}
		}
		return array;
	}
	
	public ArrayList<Integer> prime_factors(int number){
		ArrayList<Integer> factors = new ArrayList<Integer>(0);
		for(int i = number/2; i >= 2; i--){
			if(number % i == 0){
				//
				if(check_prime(i)){
					int counter = number;
					while(counter % i == 0){
						counter /= i;
						factors.add(i);
					}
					
				}
				/*if(check_prime(number/i)){
					factors.add(number/i);
				}*/
				
			}
			
		}
		
		return factors;
	}
	
	public boolean prime_relativity(int a, int b){
		ArrayList<Integer> factors_a = prime_factors(a);
		ArrayList<Integer> factors_b = prime_factors(b);
		boolean relatively_prime = true;
		for(int i = 0; i < factors_a.size(); i++){
			for(int i2 = 0; i2 < factors_b.size(); i2++){
				if(factors_a.get(i) == factors_b.get(i2)){
					relatively_prime = false;
				}
			}
		}
		return relatively_prime;
	}
	
	public int[] primes_for_even(int even){
		int[] primes = new int[2];
		ArrayList<Integer> primes_b;
		primes_b = primes_between(1, even);
		for(int i = 0; i < primes_b.size(); i++){
			int o = even - primes_b.get(i);
			if(check_prime(o)){
				primes[0] = primes_b.get(i);
				primes[1] = o;
			}
		}
		return primes;
	}
	
	public ArrayList<Integer>  find_twins(int a, int b){
		ArrayList<Integer> twins = new ArrayList<Integer>();
		ArrayList<Integer> all_primes = primes_between(a, b);
		for(int i = 0; i < all_primes.size() -1; i++){
			if(all_primes.get(i) == all_primes.get(i+1) -2){
				twins.add(all_primes.get(i));
				twins.add(all_primes.get(i+1));
			}
		}
		return twins;
	}
	
	
	public void operate(){
		if(choice.equals("Check Prime")){
			int number = Integer.parseInt(JOptionPane.showInputDialog("What number do you want to check is prime?"));
			boolean isPrime = check_prime(number);
			if(isPrime){
				JOptionPane.showMessageDialog(null, "" + number + " is prime");
			}else{
				JOptionPane.showMessageDialog(null, "" + number + " is not prime");
			}
		}else if(choice.equals(options[1])){
			int a =  Integer.parseInt(JOptionPane.showInputDialog("What is lower number?"));
			int b = Integer.parseInt(JOptionPane.showInputDialog("What is the higher number?"));
			ArrayList<Integer> primes = primes_between(a, b);
			String out = "";
			for(int i = 0; i < primes.size(); i++){
				out += primes.get(i) + ", ";
			}
			JOptionPane.showMessageDialog(null , "The primes between are " + out);
		}else if(choice.equals(options[2])){
			int number = Integer.parseInt(JOptionPane.showInputDialog("What number do you want to factor?"));
			ArrayList<Integer> factors = prime_factors(number);
			String out = "";
			for(int i = 0; i < factors.size(); i++){
				out += factors.get(i) + ", ";
			}
			JOptionPane.showMessageDialog(null , "The prime factors are " + out);
		}else if(choice.equals(options[3])){
			int a =  Integer.parseInt(JOptionPane.showInputDialog("What is the first number?"));
			int b = Integer.parseInt(JOptionPane.showInputDialog("What is the second number?"));
			boolean primely_relative = prime_relativity(a, b);
			if(primely_relative){
				JOptionPane.showMessageDialog(null, "They are relatively prime");
			}else{
		
				JOptionPane.showMessageDialog(null, "They are not relatively prime");
			}
		}else if(choice.equals(options[4])){
			int even = Integer.parseInt(JOptionPane.showInputDialog("What is the even number?"));
			int [] primes = primes_for_even(even);
			JOptionPane.showMessageDialog(null, "The primes that add up to the number are: " + primes[0] + ", " + primes[1]);
			
		}else if(choice.equals(options[5])){
			boolean searching = true;
			int number = 4;
			while(searching){
				//checks to see that number is a composite number
				if(!check_prime(number)){
					ArrayList<Integer> possible_primes;
					//finds the possible primes
					possible_primes = primes_between(1, number);
					//remember composite_number = prime_number + 2 * a_number^2
					//looping for each prime number
					//boolean prime_found = false;
					for(int i = 0; i < possible_primes.size(); i++){
						//solve for the number and check if its an int... clever method of doing so
						// your welcome
						if(Math.sqrt((number - possible_primes.get(i))/2) % 1 == 0){
							number++;
							i += possible_primes.size();
						}
						if((possible_primes.size() -1) == i){
							searching = false;
						}
						
					}
					
				}else{
					number++;
				}
			}
			JOptionPane.showMessageDialog(null, "The first number that disproves the conjecture is" + number);
		}else if(choice.equals(options[6])){
			int a =  Integer.parseInt(JOptionPane.showInputDialog("What is the first number?"));
			int b = Integer.parseInt(JOptionPane.showInputDialog("What is the second number?"));
			ArrayList<Integer> twins = find_twins(a, b);
			String all = ""; 
			for(int i = 0; i < twins.size(); i +=2){
				all += twins.get(i) + " and " + twins.get((i + 1)) + ", \n";
			}
			JOptionPane.showMessageDialog(null, "The twin primes between are : " + all);
			
		}else if(choice.equals(options[7])){
			
		}else if(choice.equals(options[8])){
			System.exit(0);
		}
		}
		
	}


