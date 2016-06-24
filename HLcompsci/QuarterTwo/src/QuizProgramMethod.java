import javax.swing.JOptionPane;

public class QuizProgramMethod {
	int [] array = new int[6];
	int [] ticket = new int[6];
	public void getTicket(){
		for(int i = 0; i < ticket.length; i++){
			if(i < ticket.length-1)
				ticket[i] = (Integer.parseInt(JOptionPane.showInputDialog("What do you want for number " + (i+1)+"?")));
			else
				ticket[i] = (Integer.parseInt(JOptionPane.showInputDialog("What do you want for number the power ball?")));
		}
		
	}
	public void fillArray(){
		for(int i = 0; i < array.length - 1; i++){
			int number = (int)(Math.random()*69+1);
			
			for(int b = 0; b < i; b++){
				//System.out.println("" + b);
				if(number == array[b]){
					b = -1;
					number = (int)(Math.random()*69+1);
					
				}
				
			}
			array[i] = number;
		}
		array[array.length-1] = (int)(Math.random()*26+1);
		/*
		String numbers = "";
		for(int x: array){
			numbers += x + ", ";
		}
		System.out.println("The numbers are " + numbers);
		*/
	}
	public boolean checkWin(){
		boolean win = true;
		for(int i = 0; i < ticket.length - 1; i++){
			if(ticket[ticket.length-1] != array[array.length-1]){
				i = ticket.length;
				win = false;
			}
			
			int tindex = 0;
			int aindex = 0;
			if(win){
				for(int b = 0; b < ticket.length-1; b++){
					if(ticket[i] > ticket[b]){
						tindex++;
					}
					if(array[i] > array[b] )
						aindex++;
				}
				int temp1 = ticket[tindex];
				int temp2 = array[aindex];
				ticket[tindex] = ticket[i];
				ticket[i] = temp1;
				array[aindex] = array[i];
				array[i] = temp2;
			}
			
	}	
		if(win){
			for(int i = 0; i < ticket.length; i++){
				if(ticket[i] != array[i]){
					win = false;
					if(i > 4)
						System.out.println("Had " + i + " numbers and the powerball.");
				}
			}
		}
		return win;
	

}
}