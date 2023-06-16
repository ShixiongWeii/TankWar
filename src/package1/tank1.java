package package1;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class tank1 extends Superclass{

	
	public tank1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public tank1(String img, int x, int y, double speed, MainWindow frame) {
		super(img, x, y, speed, frame);
		// TODO Auto-generated constructor stub
	}

	public tank1(String img, int x, int y, int width, int height, double speed, MainWindow frame) {
		super(img, x, y, width, height, speed, frame);
		// TODO Auto-generated constructor stub
	}

	public tank1(String img, MainWindow frame) {
		super(img, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img,x,y,null);
		//mouse action
		this.frame.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseMoved(e);
				//coordinates
				x = e.getX();
				y = e.getY();
			}
			
		}
		);
		// tank with enemy's bullet
		for(eneBullet enebu:this.frame.eneshellist) {
			if(this.Rec().intersects(enebu.Rec())) {
				this.frame.status = 2;
			}
			
		}
	}

	@Override
	public Rectangle Rec() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,40,27);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
