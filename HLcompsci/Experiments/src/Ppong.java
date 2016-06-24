import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Ppong extends Applet implements Runnable, KeyListener{
	
	int py = 150;
	int pyVel = 0;
	
	int bx = (int)(Math.random()* 100 + 100);
	int by = (int)(Math.random()* 100 + 100);
	int fbx1 = (int)(Math.random()* 100 + 100);
	int fbx2 = (int)(Math.random()* 100 + 100);
	int fby1 = (int)(Math.random()* 100 + 100);
	int fby2 = (int)(Math.random()* 100 + 100);
	int bxVel = 1;
	int byVel = 1;
	int hitCounter = 0;
	int speedMultiplier = 1;
	
	int lives = 5;
	boolean isAlive = true;
	
	int vRectX = 60;
	public void init() {
		setSize(600, 400);
		setBackground(Color.BLACK);
		addKeyListener(this);
	}
	
	public void start() {
		Thread th = new Thread(this);
		th.start();
	}
	
	public void stop() {}
	
	public void paint(Graphics g){
		if(lives > 0){
			isAlive = true;
		}else{
			isAlive = false;
		}
		if(isAlive){
			g.setColor(Color.LIGHT_GRAY);
			//top
			g.fillRect(vRectX, 5, 540, 20);
			//right
			g.fillRect(580, 20, 20, 360);
			//bottom
			g.fillRect(vRectX, 380, 540, 20);
			//paddle
			g.setColor(Color.GRAY);
			g.fillRect(50, py, 20, 100);
			//ball
			g.fillOval(bx, by, 20, 20);
			/*
			//fake balls
			g.fillOval(fbx1, fby1, 20, 20);
			g.fillOval(fbx2, fby2, 20, 20);
			//lives
			 */
			 
			g.setColor(Color.WHITE);
			g.setFont(new Font("Marker Felt Wide", Font.BOLD, 20));
			g.drawString("Lives: " + lives, 400, 190);
			g.drawString("Score: " + hitCounter, 400, 220);
			
			
		}else{
			g.setColor(Color.WHITE);
			g.setFont(new Font("Marker Felt Wide", Font.BOLD, 30));
			g.drawString("Game Over", 200, 190);
		}
		
	}
	
	public void run(){
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		while(true){
			//Ball and paddle movement
			bx += bxVel* speedMultiplier;
			by += byVel * speedMultiplier;
			py = by;//pyVel * speedMultiplier;
			fbx1 += bxVel* speedMultiplier;
			fby1 += byVel * speedMultiplier;
			fbx2 += bxVel* speedMultiplier;
			fby2 += byVel * speedMultiplier;
			//paddle boundaries
			if(py <= 30){
				py = 31;
			}else if(py + 100 >= 380){
				py = 280;
			}
			//ghost ball boundaries
			if(fbx1 >= 630){
				fbx1 = -20;}
			if(fbx2 >= 630){
				fbx2 = -20;}
			if(fbx1 <= - 30){
				fbx1 = 620;}
			if(fbx2 <= - 30){
					fbx2 = 620;}
			if(fby1 >= 430){
				fby1 = -10;
			}
			if(fby1 >= 430){
				fby1 = -10;
			}
			
			
			
			//Rectangle boundaries top, right, bottom
			if(/*bx + 10 >= vRectX && bx + 10 <= 600 &&*/ by <= 25){
				by = 25;
				byVel = byVel * -1;
			}
			if(by + 10 >= 20 && by + 10 <= 400 && bx + 20 >= 580){
				bx = 560;
				bxVel = bxVel* -1;
			}
			if(/*bx + 10 >= vRectX && bx + 10 <= 600 &&*/ by + 20 >= 380 ){
				by = 360;
				byVel = byVel * -1;
			}
			//paddle
			if(by + 10 <= py + 100 && by + 10 >= py && bx <= 70 /*&& bx >= 50*/ ){
				bxVel = bxVel * -1;
				bx = 70;
				hitCounter++;
				if(hitCounter % 2 == 0){
					speedMultiplier++;
				}
			}
			//lose life boundary
			if(bx <= -50){
				lives--;
				bx = 200;
				by = 200;
				speedMultiplier = 1;
			}
			repaint();
			try{
				Thread.sleep(3);
			} catch(InterruptedException Ex){}
			
			
		}
		
		
	}
	
	public void keyPressed(KeyEvent e){}
	
	public void keyTyped(KeyEvent e) {
		char a = e.getKeyChar();
		if(a == 'w'){
			pyVel = -1;
		}else if(a == 's'){
			pyVel = 1;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		pyVel = 0;
	}
	
	}
