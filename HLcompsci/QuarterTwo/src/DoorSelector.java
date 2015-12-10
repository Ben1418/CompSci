import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DoorSelector extends JFrame implements ActionListener{
	int randomNumber;
	int gamesWon = 0;
	int totalGames = 0;
	JLabel result;
	String [] doors = {"DOOR ONE","DOOR TWO","DOOR THREE"};
	int random = (int)(Math.random()*3);
	int selection = 0;
	JTextField answerBox;
	public static void main(String [] args){
		DoorSelector obj = new DoorSelector();
		obj.setVisible(true);
		
	}
	
	public DoorSelector(){
		setTitle("Select the correct door");
		setSize(600, 300);
		setBackground(new Color(20, 20, 155));
		setLayout(new BorderLayout());
		JPanel northPanel = new  JPanel();
			JButton door1 = new JButton("DOOR ONE");
			door1.addActionListener(this);
			northPanel.add(door1);
			JButton door2 = new JButton("DOOR TWO");
			door2.addActionListener(this);
			northPanel.add(door2);
			JButton door3 = new JButton("DOOR THREE");
			door3.addActionListener(this);
			northPanel.add(door3);
		add(northPanel, BorderLayout.NORTH);
		JPanel southPanel = new JPanel();
			JButton check = new JButton("Check if Win or Loss");
			check.addActionListener(this);
			southPanel.add(check);
		add(southPanel, BorderLayout.SOUTH);
		JPanel centerPanel = new JPanel();
			result = new JLabel("You have won " + gamesWon + " games out of " + totalGames);
			centerPanel.add(result);
		add(centerPanel, BorderLayout.CENTER);
		
			
		
		
	} 
	public void actionPerformed(ActionEvent e){
		String actionCommand = e.getActionCommand();
		int i = 0;
		for(String door: doors){
			if(door.equals(actionCommand)){
				selection = i;
			}
			i++;
		}
		if(actionCommand.equals("Check if Win or Loss")){
			totalGames++;
			random = (int)(Math.random()*3);
			if(selection == random){
				gamesWon++;
			}
			result.setText("You have won " + gamesWon + " games out of " + totalGames);
		}
		if(gamesWon >= 10){
			result.setText("It took " + totalGames + " games to win 10 times.");
		}
	}

}
