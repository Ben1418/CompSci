import javax.swing.JOptionPane;

public class NameDriver {
	public static void main(String [] args){
		
		NameMethods obj = new NameMethods(getName());
		obj.read_from_text();
		
	}
	
	//static method --> no object
	public static String getName(){
		String name = JOptionPane.showInputDialog("What name are we searching?");
		return name;
	}

}
