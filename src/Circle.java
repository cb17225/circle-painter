// *** Your name: Matvey Volkov
import java.awt.Color;
import java.awt.Graphics;

public class Circle {
	
	private int x;
	private int y;
	private int radius;
	private Color color;
	
	public Circle(int x, int y, int radius, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 2 * radius, 2 * radius);
		g.setColor(Color.black);
		g.drawOval(x, y, 2 * radius, 2 * radius);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return 2 * radius;
	}
	
	public int getHeight() {
		return 2 * radius;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public boolean containsPoint(int x, int y) {
		double distanceFromCenter = Math.sqrt((this.x + this.radius - x) * (this.x + this.radius - x) + (this.y + this.radius - y) * (this.y + this.radius - y));
		return ((this.radius >= distanceFromCenter) && x > this.x && x < this.x + 2 * this.radius && y > this.y && y < this.y + 2 * this.radius);
	}
}
