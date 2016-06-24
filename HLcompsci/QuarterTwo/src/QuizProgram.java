import javax.swing.JOptionPane;

public class QuizProgram {
	
	public static void main(String [] args){
		QuizProgramMethod obj = new QuizProgramMethod();
		
		int lotto = 1;
		obj.getTicket();
		boolean won = false;
		while(!won){
			obj.fillArray();
			 won = obj.checkWin();
			 lotto++;
			 if(lotto % 50000000 == 0)
				 System.out.println("" + lotto);
		}
		JOptionPane.showMessageDialog(null,"You won on lottery #"+ lotto);
	}

}
