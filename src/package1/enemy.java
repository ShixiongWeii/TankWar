package package1;

import java.awt.Graphics;
import java.awt.Rectangle;

public class enemy extends Superclass{

	int x = (int)(Math.random()*12) * 50;
	int enespeed = 5;
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, null);
		y += enespeed;
		//if tanks are crashed;
		//game over
		for(bulletobj shell :this. frame.shellist) {
			if(this.Rec().intersects(shell.Rec())) {
			shell.x = -100;
			shell.y = 100;
			this.x = -150;
			this.y = 150;
			this.frame.outlist.add(shell);
			this.frame.outlist.add(this);
			this.frame.background.score++;
			this.frame.enenum++;
			}
		}
		if(this.Rec().intersects(this.frame.tank.Rec())) {
			this.frame.status = 2;
		}
	}

	@Override
	public Rectangle Rec() {
		//crash
		return new Rectangle(x,y,57,32);
	}

	public enemy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public enemy(String img, int x, int y, double speed, MainWindow frame) {
		super(img, x, y, speed, frame);
		// TODO Auto-generated constructor stub
	}

	public enemy(String img, int x, int y, int width, int height, double speed, MainWindow frame) {
		super(img, x, y, width, height, speed, frame);
		// TODO Auto-generated constructor stub
	}

	public enemy(String img, MainWindow frame) {
		super(img, frame);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
