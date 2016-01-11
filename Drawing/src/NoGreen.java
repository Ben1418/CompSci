import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class NoGreen {
	public static void main(String [] args)throws IOException{
		File input = new File("me.jpg");
		BufferedImage image = ImageIO.read(input);
		removeGreen(image);
		File output = new File("noGreen" + input.getName());
		ImageIO.write(image, "jpg", output);
		
	}
	
	public static void removeGreen(BufferedImage p){
		int width = p.getWidth();
		int height = p.getHeight();
		for(int h = 0; h < height; h++){
			for(int w = 0; w < width; w++){
				Color c = new Color(p.getRGB(w, h));
				Color newColor = new Color(c.getRed(), 0, c.getBlue());
				p.setRGB(w, h, newColor.getRGB());
				}
			}
		JOptionPane.showMessageDialog(null, "Image Complete");
		}
	
	}


