package obj;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class Player {

	public Player(String name, int team) {
		this.name = name;
		this.team = team;
		
		//초기화 공통
		this.size = 20;
		this.hp = 10;
		
		//초기화 팀별
		switch (team) {
		case 1:
			this.x = 100;
			this.y = 100;
			this.color = Color.red;
			break;
		case 2:
			this.x = 100;
			this.y = 200;
			this.color = Color.blue;
			break;

		default:
			break;
		}
	}

	private int x;
	private int y;
	private int size;
	private Color color;

	// 팀
	private int team;
	// 플레이어 체력
	private int hp;
	// 이름
	private String name;
	// 눈들
	public final List<Snow> snows = new LinkedList<Snow>();

	public void isBeaten(Snow snow) {
		this.hp -= 1;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, size, size);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, size, size);
	}

	// 이동
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	// 생존여부 체크
	public boolean isAlive() {
		//System.out.println(this.hp);
		if (this.hp < 0) {
			return false;
		} else {
			return true;
		}
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Snow> getSnows() {
		return snows;
	}
}