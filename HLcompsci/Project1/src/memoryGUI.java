import javax.swing.JOptionPane;


public class memoryGUI extends JOptionPane {
	public static boolean run;
	
	public static void main(String [] args){
		run = true;
		String [] options = {"Colors", "Numbers"};
		String [] colors = {"Green", "Red", "Blue", "Yellow", "Pink", "Black"};
		String [] nums = new String[colors.length];
		String [] chosen;
		for(int i =0; i < nums.length; i++){
			nums[i] = "" + i;
		}
		String m = "Work with numbers or colors?";
		while(run){
			int optionChosen = JOptionPane.showOptionDialog(null, m, "Memory" , OK_CANCEL_OPTION, PLAIN_MESSAGE, null, options, null);
			if(optionChosen == 0){
				chosen = colors;
			}else{
				chosen = nums;
			}
			int places;
			try{
			places = Integer.parseInt(JOptionPane.showInputDialog(("How many " + options[optionChosen] + " do you want?")));
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "Please choose a positive integer");
				run = false;
				return;
			}
			String [] memorize = new String[places];
			String mixed = "";
			for(int i = 0; i < memorize.length; i++){
				memorize[i] = chosen[(int)(Math.random()*places)];
				mixed += memorize[i] + ", ";
			}
			JOptionPane.showMessageDialog(null, "Memorize " + mixed, "Memorize", QUESTION_MESSAGE);
			for(int i = 0; i < memorize.length; i++){
				int choice = JOptionPane.showOptionDialog(null, "Choose the correct sequence", "Choose", OK_CANCEL_OPTION, PLAIN_MESSAGE, null, chosen, null);
				if(memorize[i] == chosen[choice]){
					if(i == memorize.length-1){
						JOptionPane.showMessageDialog(null, "You Win!");
					}
				}else{
					JOptionPane.showMessageDialog(null, "You Lose");
					i = memorize.length;
				}
			}
			String [] yn = {"y", "n"};
			int again = JOptionPane.showOptionDialog(null, "Play Again?", "again again again", YES_NO_OPTION, QUESTION_MESSAGE, null, yn, null);
			if(again == 0){}
			else{run = false;}
			
		}
	}
	

}
