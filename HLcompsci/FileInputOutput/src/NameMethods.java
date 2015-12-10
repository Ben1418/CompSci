import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class NameMethods {
	
	String name;
	String people;
	public NameMethods(String name){
		this.name = name;
	}
	
	public void read_from_text(){
		Scanner inputStream = null;
		try{
			inputStream = new Scanner(new FileInputStream("Names.txt"));
		}catch(FileNotFoundException ex){
			System.out.println("File not Found");
			System.exit(0);
		}
		while(inputStream.hasNext()==true){
			if(inputStream.nextLine().equals(name)){
				people = inputStream.nextLine();
				JOptionPane.showMessageDialog(null, name + " was used " + people);
			}
		}
	}

}
