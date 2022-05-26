import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class batmobile {
	int x;
	int y; 
	
	
	
	public int hp = 80;
	
	
	private Image img; 	
	private AffineTransform tx;
	public static int score = 0;
	public batmobile(int x, int y) {
		this.x = x;
		this.y = y;
	
		img = getImage("/imgs/batmobile.gif"); // load the image for Tree
		
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);

	}
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}

	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		update();

		g2.drawImage(img, tx, null);

	}

	private void update() {
	
	       tx.setToTranslation(x, y);
	       tx.scale(3, 3);
			
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Rock.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}


}

