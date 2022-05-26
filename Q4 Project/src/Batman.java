import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Batman {
	int x;
	int y; 
	int level = 0;
	public int vx;
	public int vy = 1;
	private int ay= 1;
	
	public int hp = 200;
	public int ult = 0;
	private Image img; 	
	private AffineTransform tx;
	public static int score = 0;
	public Batman(int x, int y) {
		this.x = x;
		this.y = y;
	
		img = getImage("/imgs/batman.gif"); // load the image for Tree
		
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); //initialize the location of the image
		// use your variables
	}
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}

	public void paint(Graphics g) {
		// these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;

		// call update to update the actually picture location
		update();

		g2.drawImage(img, tx, null);

	}
      
	/* update the picture variable location */
	private void update() {
		x+=vx;
		 y+=vy*1.5;
	       vy+=ay;
		score++;
		  
		  
	
	       tx.setToTranslation(x, y);
	       tx.scale(1 , 1);
			
		

	}
	
	public void jump() {
		vy-=12;
		
	}
	public void goLeft() {
		vx=-7;
	}
	public void goRight() {
		vx=+7;
	}
	public void stop() {
		vx =0;	
		
	}
	
	
	public void goDown() {
		vy+= 5;
	}
	public void goUp() {
		vy-= 5;
	}
	
	

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Batman.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	public void resetG() {
		y = 130;
		vy = 0;
		
	}

}

