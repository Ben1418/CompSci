import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TennisCourtMethods {
	public void write_to_line(int line, String write){
		PrintWriter outputStream = null;
		Scanner inputStream = null;
		try{
			inputStream = new Scanner(new FileInputStream("TennisCourts.txt"));
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
			outputStream = new PrintWriter(new FileOutputStream("TennisCourts.txt"));
		}catch(FileNotFoundException e){
			System.out.println("Cannot open the file TennisCourts.txt");
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
	public String read_from_line(int desired_line){
		Scanner inputStream = null;
		try{
			inputStream = new Scanner(new FileInputStream("TennisCourts.txt"));
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
	String [] options1 = {"Edit", "View", "Exit"};
	int choice = 0;
	public void input_1(){
		choice = JOptionPane.showOptionDialog(null, "What do you want to do?", "Option 1" , JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, null);
		if(choice == 2){
			System.exit(0);
		}
	}
	public void part2(){
		if(choice == 0){
			int court = Integer.parseInt(JOptionPane.showInputDialog("What Court # do you want to change?"));
			String player1 = JOptionPane.showInputDialog("What is the name of Player 1");
			String player2 = JOptionPane.showInputDialog("What is the name of Player 2");
			int line = (court-1)*2 +1;
			write_to_line(line, ("Court" + court));
			write_to_line(line+1, (player1 + " vs. " + player2));
		}
		if(choice == 1){
			String [] courts = new String[4];
			for(int i = 0; i < courts.length;i++){
				courts[i] = read_from_line((i+1)*2);
			}
			String view = "";
			for(int i= 0; i < courts.length; i++){
				view += "\n Court" + (i+1) + ": " + courts[i];
			}
			JOptionPane.showMessageDialog(null, view);
		}
	}

}
