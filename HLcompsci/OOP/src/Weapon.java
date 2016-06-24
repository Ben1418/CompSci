import javax.swing.JOptionPane;

public class Weapon {
	private String weapon;
	int strength;
	double speed;
	
	public Weapon(){
		weapon = "knife";
		strength = 1;
		speed = 2;
	}
	
	public void setWeapon(){weapon = JOptionPane.showInputDialog("What type of weapon do you have?");}
	public String getWeapon(){return weapon;}

}
