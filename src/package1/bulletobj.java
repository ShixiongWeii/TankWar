package package1;

import java.awt.Graphics;
import java.awt.Rectangle;

public class bulletobj extends Superclass{

	
	public bulletobj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public bulletobj(String img, int x, int y, double speed, MainWindow frame) {
		super(img, x, y, speed, frame);
		// TODO Auto-generated constructor stub
	}

	public bulletobj(String img, int x, int y, int width, int height, double speed, MainWindow frame) {
		super(img, x, y, width, height, speed, frame);
		// TODO Auto-generated constructor stub
	}

	public bulletobj(String img, MainWindow frame) {
		super(img, frame);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, null);
		 y -= 5;
	}

	@Override
	public Rectangle Rec() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,11,17);
	}

}
