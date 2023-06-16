package package1;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Strongest extends Superclass{

	
	int lifetime = 10;
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, null);
		if(x >= 450) {
			speed *= -1;
			
		}
		if(x <= 0) {
			speed *= -1;
		
		}
		x += speed;
		//boss
		
		for(bulletobj shell:this.frame.shellist) {
			
			if(this.Rec().intersects(shell.Rec())) {
				//if hit
				
				shell.x = -100;
				shell.y = 100;
				this.frame.outlist.add(shell);
				this.frame.background.hp --;
				lifetime --;
				
			}
			
			if(lifetime <= 0) {
				this.frame.status = 3;
			}
		}
		
	}

	@Override
	public Rectangle Rec() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,50,66);
	}

	public Strongest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Strongest(String img, int x, int y, double speed, MainWindow frame) {
		super(img, x, y, speed, frame);
		// TODO Auto-generated constructor stub
	}

	public Strongest(String img, int x, int y, int width, int height, double speed, MainWindow frame) {
		super(img, x, y, width, height, speed, frame);
		// TODO Auto-generated constructor stub
	}

	public Strongest(String img, MainWindow frame) {
		super(img, frame);
		// TODO Auto-generated constructor stub
	}

	

}
