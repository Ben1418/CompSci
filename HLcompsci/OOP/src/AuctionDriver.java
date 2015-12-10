import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class AuctionDriver {
	public static void main(String [] args){
		AuctionMethods auction = new AuctionMethods();
		while(true){
		auction.input();
		auction.option2();
		}
	}


}
