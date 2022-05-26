import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import java.awt.geom.AffineTransform;
import java.net.URL;

public class Gun{
	public int x;
	public double p = 0.85;
	public int y;
	public int vx;
	public int vy=1;
	private int gravity=1;
	public int level = 1;
	//add location attributes
	private Image img; 	
	private AffineTransform tx;

	public Gun(int x, int y) {
		img = getImage("/imgs/gun.gif"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
		this.x = x;
		this.y = y;
		//use your variables
	}
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actualy picture location
		update();
		
		
		
		
		g2.drawImage(img, tx, null);
		
	}
	/* update the picture variable location */
	private void update() {
		
		x+=vx;
		 y+=vy*1.5;
	       vy+=gravity;
		
		tx.setToTranslation(x, y);
		tx.scale(p, p);
	}
	public void Jump() {
		vy-=12;
	}
	public void goLeft() {
		vx=-7;
	}
	public void goRight() {
		vx=7;
	}
	public void stop() {
		vx =0;	
		
	}
	
	
	
	public void resetG() {
		vy= 0;
		y = 150;
	}
	
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.2, 1.2);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Gun.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
