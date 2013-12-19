package obj;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public Player(int x, int y, int size, Color color){
		this.xPos = x;
		this.yPos = y;
		this.width = size;
		this.height = size;
		this.size = size;
		this.color = color;
	}

	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int size;
	private Color color;

	public void setColor(Color color){
		this.color = color;
	}
	
	public int getSize(){
		return size;
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

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(xPos, yPos, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, width, height);
	}

	// 이동
	public void move(int dx, int dy) {
		this.xPos += dx;
		this.yPos += dy;
	}
}