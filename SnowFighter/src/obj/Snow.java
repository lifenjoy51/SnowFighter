package obj;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;
import java.util.Map.Entry;

public class Snow {

	private Player owner;
	private int xPos = 0;
	private int yPos = 0;
	private int width = 10;
	private int height = 10;
	private int speed = 0;

	public Snow(Player owner, int speed) {
		this.owner = owner;
		this.xPos = owner.getX();
		this.yPos = owner.getY();
		this.speed = speed;
	}

	public void increase() {
		this.yPos += this.speed;
	}

	public void decrease() {
		this.yPos -= this.speed;
	}

	public void detectCollision(Map<String, Player> players) {

		for (Entry<String, Player> entry : players.entrySet()) {
			Player player = entry.getValue();
			// 눈과 대상의 거리를 구한다.
			int dx = xPos - player.getX();
			int dy = yPos - player.getY();
			int dst = (int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
			//System.out.println(dst);
			if (dst <= player.getSize()) {
				player.isBeaten(this);
				owner.snows.remove(this);
			} else {
				// player.setColor(Color.BLUE);
			}
		}

	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(xPos, yPos, width, height);
		
		System.out.format("%d %d %d %d", xPos, yPos, width, height);
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
