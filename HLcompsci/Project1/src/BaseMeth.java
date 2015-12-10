import javax.swing.JOptionPane;

public class BaseMeth extends JOptionPane {
	//This is the method class for BaseMaker
	/* THINGS THAT NEED TO BE DONE
	 * Ask for a number in base 10, 2, or 16
	 * Ask what base the user wants it converted to
	 * display two values
	 */
	//global variables
	int desired_base;
	int starting_base;
	//Options for bases to convert to and from
	String [] base_options = {"Binary","Decimal", "Hexadecimal"};
	int [] base_values = {2, 10, 16};
	char [] b16_letters = {'a', 'b', 'c', 'd', 'e', 'f'};
	char[] ch_numbers;
	String number_word;
	String end_word;
	//Get user inputs
	public void input(){
		//ask for what base they want to start with
		starting_base = JOptionPane.showOptionDialog(null, "What Base are you converting from?" , "Start Base" , YES_NO_OPTION, QUESTION_MESSAGE, null, base_options, null);
		//what number are they converting?
		number_word = JOptionPane.showInputDialog("What number are you converting?").toLowerCase();
		//ask for desired base
		desired_base = JOptionPane.showOptionDialog(null, "What base are you converting to?", "Ending Base choice", DEFAULT_OPTION, QUESTION_MESSAGE, null, base_options, null);
		//convert numbers into a char array
		ch_numbers = new char[number_word.length()];
		for(int i = 0; i < ch_numbers.length; i++){
			ch_numbers[i] = number_word.charAt(i);
		}
	}
	//make each character in a char array into base 10 numbers
	public int[] to_b10(char [] array){
		int[] ints_array = new int[array.length];
		for(int i = 0; i < array.length; i++){
			try{
			ints_array[i] = Integer.parseInt("" + array[i]);
			//might need to edit exception
		}catch(NumberFormatException ex){
				boolean letter_missing = true;
				int b = 1;
				while(letter_missing){
					if(array[i] == b16_letters[b-1]){
						letter_missing = false;
						ints_array[i] = 10+b -1;
					}else{
						b++;
					}
				}
				
			}
		}
		return ints_array;
	}
	//put convert whatever number they use want to base 10
	public int to_base_10( int base){
		int number_sums = 0;
		int [] i_array = to_b10(ch_numbers);
		for(int i = 0; i < i_array.length; i++){
			number_sums += i_array[i_array.length-i-1]*Math.pow(base, i);
		}
		return number_sums;
	}
	public String toBase_i(int desired_base, int base10_amount){
		int len = 1;
		System.out.println("Base 10 amount " + base10_amount);
		while(Math.pow(desired_base, len)<=base10_amount){
			len++;
		}
		System.out.println("len " + len);
		int [] desired_basenums = new int[len];
		for(int i = 0; i < desired_basenums.length; i++){
			double place = Math.pow(desired_base, (len - i - 1));
			System.out.println("place " + place);
			int loops = 0;
			while(base10_amount >= place){
				base10_amount -= place;
				loops++;
			}
			System.out.println("loops " + loops);
			desired_basenums[i]= loops;
		}
		String end = "";
		for(int i = 0; i < desired_basenums.length; i++){
			if(desired_basenums[i] >= 10){
				end+= b16_letters[(desired_basenums[i]-10)];
			}else{
				end+= desired_basenums[i];
			}
			System.out.println("" + end);
		}
		System.out.println("2   " + end);
		return end;
	}
	//calculations occur here
	public void calculate(){
		int d_base = base_values[desired_base];
		int amount_b10 = to_base_10( base_values[starting_base]);
		end_word = toBase_i(d_base, amount_b10);
	}
	public void output(){
		JOptionPane.showMessageDialog(null, "Original Number: " + number_word + " in base " + base_values[starting_base]+ "\n Converted Number: " + end_word+ " in base " + base_values[desired_base]);
	}

}
