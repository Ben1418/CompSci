import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class BirthdayCard extends Applet {
	public void paint (Graphics g){
		
		setSize(800, 800);
		setBackground(new Color(255,255,0));
		for(int i = 1; i <= 99; i++){
			
			int x = (int)(Math.random()* 750);
			int y = (int)(Math.random()* 750);
			int w = (int)(Math.random()*150 + 20);
			int r = (int)(Math.random() * 255);
			int g2 = (int)(Math.random()* 255);
			int b = (int)(Math.random()* 255);
			g.setColor(new Color(r, b, g2));
			g.fillOval(x, y, w, w);
			g.drawLine((x+w/2), (y+w), (x+w/2), (y+ w + 50));
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 30));
		g.drawString("Happy Birthday Ben!", 250, 150);
	}

}
