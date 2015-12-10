import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ChainMethods {
	String [] options = {"Show chain", "Find Biggest Chain"};
	int option1;
	int startTime;
	public void input1(){
		option1 = JOptionPane.showOptionDialog(null, "What do you want to do?", "Option 1", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		System.out.println("" + option1);
	}
	public ChainMethods(){}
	public ArrayList<Integer> getChain(int start){
		ArrayList<Integer> links = new ArrayList<Integer>(0);
		while(start != 1){
			if(start % 2 == 0){
				start /= 2;
				links.add(start);
			}else{
				start *= 3;
				start += 1;
				links.add(start);
			}
		}
		return links;
	}
	public void findBiggestChain(int a, int b){
		int big_length = 0;
		int biggest = 0;
		for(int i = a; i < b; i++){
			ArrayList<Integer> links = getChain(i);
			if(links.size() > big_length){
				big_length = links.size();
				biggest = i;
			}
		}
		JOptionPane.showMessageDialog(null,"The number with the biggest chain is:" + biggest);
	}
	
	public void operate(){
		System.out.println("" + option1);
		if(option1 == 0){
			ArrayList<Integer> links;
			int a = Integer.parseInt(JOptionPane.showInputDialog("What number do you want to see the chain of?"));
			links = getChain(a);
			String out = "";
			for(int i = 0; i < links.size(); i++){
				out +=  links.get(i) + ", ";
			}
			JOptionPane.showMessageDialog(null, out);
		}else if(option1 == 1){
			int a = Integer.parseInt(JOptionPane.showInputDialog("First Number"));
			int b = Integer.parseInt(JOptionPane.showInputDialog("Second Number"));
			findBiggestChain(a, b);
		}
			
	}
	
}
