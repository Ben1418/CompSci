package shapes;

import java.awt.Color;

public class Shape {
	Color color;
	protected int length;
	protected int width;
	protected int xv, yv, xa, ya, arv;
	
	public Shape(){
		color = Color.white;
		length = 1;
		width = 1;
	}
	
	public void setColor(Color color){this.color=color;}
	public void setlength(int length){this.length=length;}
	public void setwidth(int width){this.width=width;}
	
}
