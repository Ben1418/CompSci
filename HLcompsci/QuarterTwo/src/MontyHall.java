import javax.swing.JOptionPane;

public class MontyHall extends JOptionPane{
	public static void main(String [] args){
		int wins = 0;
		int losses = 0;
		boolean playing = true;
		String[] doors = {"Door 1", "Door 2", "Door 3"};
		while(playing){
			int tgames = Integer.parseInt(JOptionPane.showInputDialog("How many games would you like to run?"));
			int cdoor = (int)(Math.random()*3);
			int g1 = JOptionPane.showOptionDialog(null, "What door do you choose?", "G1", DEFAULT_OPTION, QUESTION_MESSAGE, null, doors, 0);
			System.out.println("cdoor "+(cdoor+1));
			System.out.println("g1 " + g1);
			String[] ndoors = new String[2];
			int b = ndoors.length;
			ndoors[0] = doors[g1];
			if(g1 == cdoor){
				int odoor = (int)(Math.random()*3);
				while(odoor == cdoor){
					odoor = (int)(Math.random()*3);
				}
				ndoors[1] = doors[odoor];
			}else{
				ndoors[1] = doors[cdoor];
			}
			cdoor++;
			String scdoor= "Door " + cdoor;
			int g2 = JOptionPane.showOptionDialog(null, "What door do you choose?", "G2", DEFAULT_OPTION, QUESTION_MESSAGE, null, ndoors, 0);
			System.out.println("g2 "+g2);
			if(ndoors[g2].equals(scdoor)){
				wins++;
			}else{
				losses++;
			}
			JOptionPane.showMessageDialog(null, "Wins: " + wins + " Losses: " + losses);
			
		}
		
	}

}
