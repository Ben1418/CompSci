import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class TextFileOutput {
	public static void main(String [] args){
		PrintWriter outputStream = null;
		try{
			outputStream = new PrintWriter(new FileOutputStream("stuff2.txt"));
		}catch(FileNotFoundException e){
			System.out.println("Cannot open the file stuff.txt");
			System.exit(0);
		}
		System.out.println("I am now going to writeto the file stuff.txt");
		outputStream.println("Sam is now in this class");
		outputStream.println("I really wish he was not");
		String name = JOptionPane.showInputDialog("What is your name");
		outputStream.println(name);
		outputStream.close();
		System.out.println("End of Program");
	}

}
