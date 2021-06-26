// *** Your name: Matvey Volkov
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JPanel;

public class CirclePanel extends JPanel {

	private int numCircles = 0;
	private Circle[] circles = new Circle[200];

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < numCircles; i++) {
			if (circles[i] != null) {
				circles[i].draw(g);
			}
		}
	}

	public void addCircle(Circle Circle) {
		if (numCircles == circles.length || Circle == null)
	        return;
	    circles[numCircles] = Circle;
	    numCircles++;
	}
	
	public Circle containsPoint(int x, int y) {
		for (int i = numCircles - 1; i >= 0; i--) {
			if (circles[i] != null) {
				if (circles[i].containsPoint(x, y)) {
					return circles[i];
				}	
			}
		}
		return null;
	}
	
	public Circle[] getCircles() {
		return Arrays.copyOf(circles, numCircles);
	}
	
	public int getNumCircles() {
		return numCircles;
	}
	
	public void removeMostRecentCircle() {
		if (numCircles != 0) {
			numCircles--;
		}
	}
	
	public void removeAllCircles() {
		circles = new Circle[200];
		this.repaint();
	}

}
