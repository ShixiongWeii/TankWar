package package1;
import java.awt.*;
public abstract class Superclass {
	Image img;
	//coordinate of the tank
	int x;
	int y;
	//the size of the tank
	int width;
	int height;
	//the speed;
	double speed;
	MainWindow frame;
	
	public Superclass() {
		
	}
	
	public Superclass(String img, MainWindow frame) {
		super();
		this.img = Toolkit.getDefaultToolkit().getImage(img);;
		this.frame = frame;
	}

	public Superclass(String img, int x, int y, double speed, MainWindow frame) {
		super();
		this.img = Toolkit.getDefaultToolkit().getImage(img);
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.frame = frame;
	}

	public Superclass(String img, int x, int y, int width, int height, double speed, MainWindow frame) {
		super();
		this.img = Toolkit.getDefaultToolkit().getImage(img);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.frame = frame;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = Toolkit.getDefaultToolkit().getImage(img);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public MainWindow getFrame() {
		return frame;
	}

	public void setFrame(MainWindow frame) {
		this.frame = frame;
	}

	
	

	//Inherite the methods draw themselves
	public abstract void paint(Graphics g) ;
	
	//to make the object a rectangle
	public abstract Rectangle Rec();
	

}
