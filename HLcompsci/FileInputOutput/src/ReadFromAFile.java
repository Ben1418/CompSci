import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromAFile {
	public static void main(String []args){
		System.out.println("Lets read 3 names and 2 numbers from a text file");
		System.out.println("From stuff.txt");
		Scanner inputStream = null;
		try{
			inputStream = new Scanner(new FileInputStream("stuff2.txt"));
		}catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);
		}
		String name1 = inputStream.next();
		String name2 = inputStream.next();
		String name3 = inputStream.next();
		int num1 = inputStream.nextInt();
		int num2 = inputStream.nextInt();
		System.out.println("In the file " + name1+" "+ name2+" " + name3+" "+num1+" "+num2);
		inputStream.close();
		System.out.println("End of file");
	}

}
