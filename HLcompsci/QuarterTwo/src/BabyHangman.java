import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BabyHangman extends JFrame implements ActionListener {
	JPanel nPanel;
	JPanel cPanel;
	public static void main(String [] args){
		BabyHangman obj = new BabyHangman();
		obj.setVisible(true);
	}
	
	public BabyHangman(){
		BabyHangmanMethods baby = new BabyHangmanMethods();
		baby.makeButtons();
		setLayout(new BorderLayout());
		setSize(400,400);
		//System.out.println("WHAT?");
		JButton [] hButtons = baby.buttons;
		//System.out.println("WHAT?");
		nPanel = new JPanel();
			for(int i = 0; i < baby.buttons.length; i++){
				
				System.out.println("" + baby.buttons[i]);
				baby.buttons[i].addActionListener(this);
				nPanel.add(baby.buttons[i]);
				
				
			}
		add(nPanel, BorderLayout.NORTH);
		cPanel = new JPanel();
		
		add(cPanel, BorderLayout.CENTER);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	

}
