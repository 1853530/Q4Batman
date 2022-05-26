
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	int score = 0;
	int stage = 1;
	boolean gameOver = false;
	//CREATE THE OBJECT (STEP 1)
	int banehp = 370;
	Background b = new Background(0,30);
	Boss goku 	 = new Boss(800, 50);
	Batman hero  = new Batman(10,300);
	Gun scar = new Gun(30,340);
	Rock rock = new Rock( 500, 250);
	Rock rock2 = new Rock(400, 250);
	Bane bane = new Bane(2000, 800);
	finalSmash f = new finalSmash(800, 200);
	batmobile k = new batmobile(1000, 50);
	//DinoMusic musicSpawn = new DinoMusic ("spawn.wav", false);
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0,0, 800, 700);
		
		String s = "green";
		
		
		
		b.paint(g);
		goku.paint(g);
		hero.paint(g);
		scar.paint(g);
		rock.paint(g);
		rock2.paint(g);
		bane.paint(g);
		f.paint(g);
		
		g.setColor(Color.green);
		g.fillRect(rock.x + 10, rock.y-30, rock.hp, 20);
		
		g.fillRect(rock2.x + 10, rock2.y-30, rock2.hp, 20);
		//boss hp
		g.fillRect(goku.x + 50, goku.y-30, goku.hp, 20);
		//batman hp
		g.fillRect(100, 5, hero.hp, 20);
		//bane hp
		g.fillRect(bane.x-20, bane.y-30, bane.hp, 20);
		g.setColor(Color.white);
		g.fillRect(300, 5, 20, 20);
		g.drawString("score:" + score, 20, 20);
		
		k.paint(g);
		
		
		
	if(!gameOver) {	
		
		//GAME OVER
				if(hero.hp <= 0) {
					  b.changePicture("/imgs/gameover.jpg");     
					  gameOver = true;
					  rock.y = 2000;
					  rock2.y = 2000;
					  hero.y = 200;
					  scar.y = 1000;
					  goku.x = 800;
					  goku.y = 50;
					  goku.hp = 0;
					  g.setColor(Color.white);
					  g.drawString("press 'r' to restart", 400, 400);
				}
		
		if(hero.y<=0) {
			hero.vy = 1;
			scar.vy = 1;
		}
		if(hero.x<=0) {
			hero.x = 0;
			scar.x = 20;
		}
		if(hero.x>= 805) {
			hero.x = 0;
			scar.x = 0;
		}
		
		if(hero.y>=300) {
			hero.resetG();
			hero.y = 300;
		}
		if(scar.y>= 330) {
			scar.resetG();
			scar.y =330;
		}
		
		if(hero.y<-100) {
			hero.y = 10;
			scar.y = 10;
		}
		
		if(f.x<=0 || f.x>= 700){
			f.vx *= -1;
			
		} 
		if(f.x-50<=hero.x && hero.x<= f.x + 50) {
		k.x = 0;
		hero.ult = 1;
		goku.hp -= 1;
		score += 5;
		
		}
		if(score >= 1400) {
			k.x = 2000;
			hero.ult = 0;
		}
		
		
		
		
		
		if(stage ==1) {
			
		
		//collisions
		if(rock.x-50<=hero.x&&hero.x<=rock.x+50 && hero.ult==0){
			if(hero.y>=300) {
				hero.hp -= 10;	
			}
		
		}
		if(rock2.x-50<=hero.x&&hero.x<=rock2.x+50 && hero.ult==0){
			if(hero.y>=300) {
				hero.hp -= 10;	
			}
		
		}
		
		
		
		
		
		//shoot people;
		if(hero.x< rock.x && 150<= hero.y && hero.y<=300 && hero.level == 0) {
			rock.hp --;
			score++;
		}
		
		if(hero.x> rock.x && 150<= hero.y && hero.y<=300 && hero.level == 1) {
			rock.hp --;
			score++;
		}
		if(hero.x< rock2.x && 150<= hero.y && hero.y<=300 && hero.level == 0) {
			rock2.hp --;
			score++;
		}
		
		if(hero.x> rock2.x && 150<= hero.y && hero.y<=300 && hero.level == 1) {
			rock2.hp --;
			 score++;
		}
		
		
		
		
		if(rock.hp == 0) {
			rock.x = 800;
			rock.hp = 110;
			rock.vx = -4;
		}
		if(rock2.hp == 0) {
			rock2.x = 1;
			rock2.hp = 110;
		}
		
		
		
		
		if(rock.x<=0) {
			rock.vx *= -1;
		}
		if(rock.x>=800) {
			rock.vx *= -1;
		}
		if(rock2.x<=0) {
			rock2.vx *= -1;
		}
		if(rock2.x>=800) {
			rock2.vx *= -1;
		}
		
		
		if(hero.y<-100) {
			hero.y = 10;
			scar.y = 10;
		}
		
		
		// boss fight / GOKU STUFF
		if(score>=1000) {
			goku.vx= 1;
			f.vx = 4;
		if(goku.hp>0) {
			if(hero.x<goku.x && hero.level==0) {
				goku.hp --;
			}
		
			if(hero.x> goku.x-20 && hero.x <goku.x +200) {
				hero.hp -= 11;
			}
		}	
			if(goku.hp == 0) {
				goku.y= 1000;
			}
		}
		
		if(score>= 200  && goku.hp<=0 && hero.hp>0) {
			nextLevel();
		}
		//SECOND STAGE/LEVEL
		//start here:
		}
	if(stage == 2) {
		if(bane.x<=0) {
			bane.vx *= -1;
		}
		if(bane.x>=620) {
			bane.vx *= -1;
		}
	
		
		if(hero.x< bane.x && 150<= hero.y && hero.y<=300 && hero.level == 0) {
			bane.hp --;
			score++;
		}
		if(hero.x> bane.x && 150<= hero.y && hero.y<=300 && hero.level == 1) {
			bane.hp --;
			score++;
		}
		if(bane.x-60<=hero.x&&hero.x<=bane.x+60 ){
			if(hero.y>=250) {
				hero.hp -= 20;	
			}
		}
		if(bane.hp <=0) {
			bane.x= 600;
			bane.hp = banehp;
			banehp -= 50;
		if(banehp<= 0) {
			bane.y = 2000;
		}
		}
	}	
		
	}	
	}
		
	public void restart() {
		b.y = 30;
		b.changePicture("/imgs/maxresdefault.jpg");
		gameOver = false;
		rock.x = 500;
		rock.y = 250;
		rock.hp = 80;
		rock2.x = 400;
		rock2.y = 250;
		rock2.hp = 80;
		score =0;
		hero.hp = 200;
		goku.hp = 400;
		goku.x = 800;
		goku.vx = 0;
		hero.x = 10;
		scar.x = 10;
	}
	
	public void nextLevel(){
		b.y = 30;
		b.changePicture("/imgs/background2.jpg");
	
		score = 0;
		hero.hp = 200;
		hero.x = 1;
		scar.x = 21;
		stage++;
		rock.y = 1000;
		rock2.y = 1000;
		goku.y = 1500;
		
		bane.x = 600;
		bane.y = 200;
		
		
		
		
		
	}
	public static void main(String[] args) {
		Frame f = new Frame();
	}

	
	public Frame() {
		JFrame f = new JFrame("Im batman");
		f.setSize(new Dimension(800, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			System.out.println(arg0.getKeyCode());
			
			if( arg0.getKeyCode()==65) {
				hero.goLeft();
				hero.level = 1;
				scar.goLeft();
				scar.p = 0.065;
			
				scar.changePicture("/imgs/leftGun.gif");
				
				
			}
			if( arg0.getKeyCode()==68) {
				hero.goRight();
				hero.level = 0;
				scar.goRight();
				scar.p = 0.85;
				scar.changePicture("/imgs/gun.gif");
			
			}
			
			if(arg0.getKeyCode()==87) {
				hero.jump();
				scar.Jump();
				
				
			}
		if(gameOver) {
			if(arg0.getKeyCode()==82) {
				restart();
			}
		}	
			
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if( arg0.getKeyCode()==65) {
			hero.stop();
			scar.stop();
		
		}
		if( arg0.getKeyCode()==68) {
			hero.stop();
			scar.stop();
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}


