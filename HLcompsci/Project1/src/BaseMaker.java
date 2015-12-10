import javax.swing.JOptionPane;

public class BaseMaker extends JOptionPane{
	/* THINGS THAT NEED TO BE DONE
	 * Ask for a number in base 10, 2, or 16
	 * Ask what base the user wants it converted to
	 * display two values
	 */
	public static void main(String [] args){
		BaseMeth meths = new BaseMeth();
		meths.input();
		meths.calculate();
		meths.output();
	}

}
