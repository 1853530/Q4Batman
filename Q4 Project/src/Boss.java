import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Boss{
	
	//add location attributes
	public int x;
	public int y;
	public int vx = 0;
	public int hp = 400;
	private Image img; 	
	private AffineTransform tx;

	public Boss(int x, int y) {
		img = getImage("/imgs/goku. drippy.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
		
		this.x = x;
		this.y = y;
		//use your variables
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
		x-=vx;

		
		
	    tx.setToTranslation(x, y);
	       tx.scale(0.25 , 0.25);
			
			
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.25, .25);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
