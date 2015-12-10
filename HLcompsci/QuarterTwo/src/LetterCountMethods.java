
public class LetterCountMethods {
	
	public int getlength(int number){
		String s = "";
		s+=number;
		int length = s.length();
		return length;
	}
	
	public int eatNumber(int number){
		int letters = 0;
		int intlength = getlength(number);
		String sform = "" + number;
		int previous = 0;
		for(int i = 0; i < intlength; i++){
			int character = Integer.parseInt("" + sform.charAt((intlength - i-1)));
			if(i ==  0){
				if(character == 1 || character == 2 || character == 6){
					letters += 3;
				}else if(character == 4 || character == 5 || character == 9){
					letters += 4;
				}else if(character == 3 || character == 7 || character == 8){
					letters += 5;
				}
			}else if(i == 1){
				if(character == 1){
					letters = 0;
					if(previous == 1 || previous == 2){
						letters += 6;
					}else if(previous == 3 || previous == 4|| previous == 9){
						letters += 8;
					}else if(previous == 5|| previous == 6){
						letters += 7;
					}else if(previous == 7 || previous == 8){
						letters += 9;
					}
				}else if(character == 2 || character == 3  || character == 9|| character == 8){
					letters += 6;
				}else if(character == 5 || character == 6|| character == 4){
					letters += 5;
				}else if(character == 7 ){
					letters += 7;
				}
			}else if(i == 2){
				letters += 10;
				if(character == 1 || character == 2 || character == 6){
					letters += 3;
				}else if(character == 4 || character == 5 || character == 9){
					letters += 4;
				}else if(character == 3 || character == 7 || character == 8){
					letters += 5;
				}
			}
			previous = character;
		}
		return letters;
	}

}
