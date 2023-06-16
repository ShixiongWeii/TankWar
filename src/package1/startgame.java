package package1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class startgame extends Superclass{
	Image ground = Toolkit.getDefaultToolkit().getImage("imgs/battleground.png");
	int score = 0;
	int hp = 5;
	int boss = 0;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.setFont(new Font("times new roman",Font.BOLD,20));
		g.drawString("Game starts! ", 100, 100);
		g.drawImage(ground, x, y, null);
		//background cycle
		if(y >= 0) {
			y = -300;
		}
		//background movement 
		g.setColor(Color.green);
		y += speed;
		g.drawString("The number of enemies you beat: "+ score, 30,400);
		if(boss == 1) {
		g.setColor(Color.green);
		g.drawString("boss's remaining hp: "+ hp, 30,425);	
		if(hp == 0) {
			
			this.frame.status=3;
		}
		}
	}

	@Override
	public Rectangle Rec() {
		// TODO Auto-generated method stub
		return null;
	}

	public startgame() {
		super();
		// TODO Auto-generated constructor stub
	}

	public startgame(String img, int x, int y, double speed, MainWindow frame) {
		super(img, x, y, speed, frame);
		// TODO Auto-generated constructor stub
	}

	public startgame(String img, int x, int y, int width, int height, double speed, MainWindow frame) {
		super(img, x, y, width, height, speed, frame);
		// TODO Auto-generated constructor stub
	}

	public startgame(String img, MainWindow frame) {
		super(img, frame);
		// TODO Auto-generated constructor stub
	}

	

}
