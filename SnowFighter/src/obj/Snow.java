package obj;

import java.awt.Color;
import java.awt.Graphics;

public class Snow {

	private int xPos = 0;
	private int yPos = 0;
	private int width = 10;
	private int height = 10;
	private int speed = 0;

	public Snow(int xPos, int yPos, int speed) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getX() {
		return xPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public int getY() {
		return yPos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void increase() {
		this.yPos += this.speed;
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(xPos, yPos, width, height);
	}
}
