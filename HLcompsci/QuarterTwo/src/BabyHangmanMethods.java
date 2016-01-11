import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JButton;

public class BabyHangmanMethods {
	
	String letters = "wsertyudfhggyuibnsdgdshdfgsdfg";
	
	public void write_to_line(int line, String write){
		PrintWriter outputStream = null;
		Scanner inputStream = null;
		
		try{
			inputStream = new Scanner(new FileInputStream("BabyHangman.txt"));
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
			outputStream = new PrintWriter(new FileOutputStream("BabyHangman.txt"));
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
			inputStream = new Scanner(new FileInputStream("BabyHangman.txt"));
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
	String word;
	JButton [] buttons = new JButton[7];
	String [] lets;
	boolean [] guessed = new boolean[7];
	boolean [] index_used;
	public void makeButtons(){
		int random = (int)(Math.random() * 6 + 1);
		System.out.println("random =" + random);
		word = read_from_line(random);
		System.out.println(word);
		index_used = new boolean[7];
		for(int i = 0; i < index_used.length; i++){
			index_used[i] = false;
		}
		lets = new String[word.length()];
		int index = 0;
		for(int i = 0; i < buttons.length; i++){
			int ran =(int)(Math.random()*7 );
			
			while(index_used[ran]){
				ran  =(int)(Math.random()*7 );
				//.println("" +System.out ran);
			}
			index_used[ran] = true;
			guessed[i] = false;
			try{
			
			
			
			buttons[ran] = new JButton("" + word.charAt(i));
			lets[i] = buttons[ran].getActionCommand();
			index++;
			
			}catch(StringIndexOutOfBoundsException ex){
	
				boolean unused = true;
				int rannum = (int)(Math.random()*15);
				for(int b = 0; b < lets.length; b++){
					if((""+letters.charAt(rannum)).equals(lets[b])){
						unused = false;
					}
					if(unused == false){
						rannum = (int)(Math.random() * 15);
						b = 0;
						unused = true;
					}
				}
				buttons[ran] = new JButton("" + letters.charAt(rannum));
			}
		} 
			
	}
	

}
