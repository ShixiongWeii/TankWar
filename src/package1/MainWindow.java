package package1;
import javax.swing.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MainWindow extends JFrame {

	int num = 1;
	//number of the enemy
	int enenum = 0;
	//temporary picture
	//Image offScreenImage = null;
	int status = 0;
	
	Image ground = Toolkit.getDefaultToolkit().getImage("imgs/battle2.jpeg");
	
	//tank
	tank1 tank = new tank1("imgs/25817.png",290,400,0,this);
	
	//Strongest str_ene =  new Strongest("imgs/senemy.jpeg",250,30,5,this);
	Strongest str_ene = null;
	List<bulletobj> shellist= new ArrayList<>();
	List<Superclass> gamelist = new ArrayList<>();
	List<enemy>enemylist  =  new ArrayList<>();
	List<Superclass>outlist = new ArrayList<>();
	List<eneBullet>eneshellist = new ArrayList<>();
	//tank shell
	bulletobj shell = new bulletobj("imgs/bullet.png",tank.x,tank.y,10, this);
	
	//background 
	startgame background = new startgame("imgs/battleground.png",0,-300,1,this);
	public void start() {
		//make it visible
		setVisible(true);
		//the title
		setTitle("World War II");
		//the position
		setLocationRelativeTo(null);
		//the size
		setSize(500,500);
		gamelist.add(background);
		gamelist.add(tank);
		
		//gamelist.add(str_ene);
		//mouse
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getButton());
				if(e.getButton() == 1) {
					status = 1;
					repaint();
				}
			}
			});
		//pause
		this.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				//pause
				
				
				if(e.getKeyCode() == 32) {
					switch(status) {
					case 1:  
						status = 4;
						break;
					case 4:
						status = 1;
						break;
					case 2:
						num = 1;
						//number of the enemy
						enenum = 0;
						background.boss = 0;
						background.hp = 0;
						status = 0;
						break;
					case 3:
						num = 1;
						//number of the enemy
						enenum = 0;
						background.boss = 0;
						background.hp = 0;
						status = 0;
						break;
					}
				}
				
			}
		});
		while (true) {
			if(status == 1) {
				maketank();
			
			}
			repaint();
			try {
				//duration
				Thread.sleep(25);
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}
	
		}
	public void maketank(){
		//control the speed of the bullet
		if(num % 20 == 0) {
			shellist.add(new bulletobj("imgs/bullet.png",tank.x,tank.y,10, this) );
			gamelist.add(shellist.get(shellist.size()-1));
		}
		if(num % 30 == 0 && str_ene != null) {
			eneshellist.add(new eneBullet("imgs/bullet2.jpg",str_ene.x +40,str_ene.y +70,10,this ));
			gamelist.add(eneshellist.get(eneshellist.size()-1));
		}
		// enemy	
		if(num % 20 == 0) {
		enemylist.add(new enemy("imgs/enemy.jpg",this));
		gamelist.add(enemylist.get(enemylist.size() - 1));
		//enenum ++;
		}
		//
		if(enenum >= 10) {
			if(str_ene == null) {
				str_ene =  new Strongest("imgs/senemy.jpeg",250,30,5,this);
				gamelist.add(str_ene);
				background.boss = 1;
			}
		}
		//
	}

	
	public void paint(Graphics g) {
		//doesn't start yet
		/*
		if(offScreenImage == null){
			offScreenImage = this.createImage(600,600);
		}
		*/
		//Graphics gImage = offScreenImage.getGraphics();
		//gImage.fillRect(0, 0, 600, 600);
		if(status == 0) {
			g.drawImage(ground,0,0,null);
			g.setColor(Color.black);
			g.setFont(new Font("times new roman",Font.BOLD,20));
			g.drawString("Yooo! Click start and let's fight!", 100, 100);
			g.drawString("By David Wei", 200, 200);
			
		}else if (status == 1){
			gamelist.removeAll(outlist);
			for(Superclass object : gamelist) {
				object.paint(g);
			}
			if(enenum >= 10) {
				g.setColor(Color.red);
				g.setFont(new Font("times new roman",Font.BOLD,20));
				g.drawString("The boss is coming!!! ", 30,120);
				
			}
		}else if(status == 2) {
			//g.drawImage(ground,0,0,null);
			g.setColor(Color.red);
			g.setFont(new Font("times new roman",Font.BOLD,30));
			g.drawString("You've been attacked, game over", 50, 300);
			g.setFont(new Font("times new roman",Font.BOLD,20));
			
			
		}else if(status == 3) {
			//g.drawImage(ground,0,0,null);
			g.setColor(Color.red);
			g.setFont(new Font("times new roman",Font.BOLD,20));
			g.drawString("You beat the enemy! Let's gooo.", 50, 300);
			g.setFont(new Font("times new roman",Font.BOLD,20));
			
		}else if(status == 4) {
			g.setColor(Color.red);
			g.setFont(new Font("times new roman",Font.BOLD,30));
			g.drawString("Press the space to resume", 50, 300);
		}
		
		
		//g.drawImage(offScreenImage, 0, 0, null);
		num ++;
	}
	
	public static void main(String[] args) {
		MainWindow window = new MainWindow();
		window.start();
	}
	

}
