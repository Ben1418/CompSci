import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AuctionMethods {
	/*File writer
	 * asks if user is buying or selling
	 * buying shows options to buy 
	 * when selected highest bid shown and asked how much to bid
	 * 
	 * Selling gives options to See the bid history
	 * lowest bid accept
	 * See the bid history
	 * Enter in Item
	 */
	//This method allows you to select a line in the saved text document and write to that line
	int buy_or_sell;
	public void write_to_line(int line, String write){
		PrintWriter outputStream = null;
		Scanner inputStream = null;
		try{
			inputStream = new Scanner(new FileInputStream("Auctions.txt"));
		}catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);
		}
		String [] lines = new String[100];
		for(int i = 0; i < lines.length; i++){
			try{
				lines[i] = inputStream.nextLine();
			}catch(NoSuchElementException ex){
				lines[i] = "";
			}
		}
		try{
			outputStream = new PrintWriter(new FileOutputStream("Auctions.txt"));
		}catch(FileNotFoundException e){
			System.out.println("Cannot open the file Auctions.txt");
			System.exit(0);
		}
		for(int i = 0; i < lines.length; i++){
			if(i+1 != line){
				outputStream.println(lines[i]);
			}else{
				outputStream.println(write);
			}
		}
		inputStream.close();
		outputStream.close();
	}
	//method reads and returns specified line
	public String read_from_line(int desired_line){
		Scanner inputStream = null;
		try{
			inputStream = new Scanner(new FileInputStream("Auctions.txt"));
		}catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);
		}
		String line = "";
		for(int i = 0; i < desired_line; i++){
			if(i != desired_line - 1){
				inputStream.nextLine();
			}else{
				line = inputStream.nextLine();
			}
		}
		inputStream.close();
		return line;
	}
	public void input(){
		String [] bs = {"Buy", "Sell", "Exit"};
		buy_or_sell = JOptionPane.showOptionDialog(null, "Buying or Selling", "B or S" , JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bs, null);
		
	}
	
	public void option2(){
		if(buy_or_sell == 0){
			//The user selected Buy
			//lines 30-50 will be alternating between product and highest bid for product
			//array of buyable items
			String [] items = new String[10];
			for(int i = 0; i < 20; i += 2){
				items[(i/2)] = read_from_line((i +30));
			}
			String [] prices = new String[10];
			for(int i = 0; i < 20; i+=2){
				prices[(i/2)] = read_from_line((i + 31));
			}
			//this will probably break
			String selection = JOptionPane.showInputDialog(null, "Which product?", "Products", JOptionPane.QUESTION_MESSAGE, null, items, items[0]).toString();
			int index = 0;
			for(int i = 0; i < items.length; i++){
				if(!selection.equals(items[i])){
					index++;
				}else{
					i = items.length;
				}
			}
			
			
			String message = selection + "'s highest bid is " + prices[index] + "\n How much do you want to bid?";
			int bid = Integer.parseInt(JOptionPane.showInputDialog(message));
			if(bid >= Integer.parseInt(prices[index])){
				write_to_line((index*2+31),("" + bid));
			}
		}else if(buy_or_sell == 1){
			//the user selected sell
			String item = JOptionPane.showInputDialog("What would you like to sell?");
			int starting_bid = 0;
			try{
			starting_bid = Integer.parseInt(JOptionPane.showInputDialog("What do you want the starting bid to be?"));
			}catch(NumberFormatException ex){
				System.out.println("Not a number");
				System.exit(0);
			}
			int x = 30;
			while(!read_from_line(x).equals("")){
				x++;
			}
			write_to_line(x, item);
			write_to_line(x+1, ""+starting_bid);
		}else{
			System.exit(0);
		}
	}
	

}
