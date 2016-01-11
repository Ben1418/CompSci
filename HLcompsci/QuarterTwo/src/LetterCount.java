
public class LetterCount {
	public static void main(String [] args){
		LetterCountMethods obj = new LetterCountMethods();
		int letterCounter = 11;
		
		int index = 1;
		while(index < 1000){
			letterCounter += obj.eatNumber(index);
			index++;
		}
		//letterCounter -= 27;
		System.out.println("" + letterCounter);
	}

}