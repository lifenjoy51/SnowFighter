package com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

import obj.Player;
import obj.Snow;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	// 플레이어
	public Player player;
	// 상대편
	public Player opponent;

	// 내가 던지는 눈
	public List<Snow> snows = new LinkedList<Snow>();
	// 상대방이 던지는 눈
	public List<Snow> enemySnows = new LinkedList<Snow>();

	Timer timer;
	
	

	public MainPanel() {
		
		//플레이어 추가
		player = new Player(100,30,20, Color.RED);
		//상대편 추가ㅓ
		opponent = new Player(100,  200, 20, Color.BLUE);

		// 주기적 실행로직
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 다시 그리기 -> paintComponent를 실행한다
				repaint();
				//내 눈 움직이기
				for (Snow snow : snows) {
					snow.increase();
					snow.detectCollision(opponent);
				}
				//상대편 눈 움직이기
				for (Snow snow : enemySnows) {
					snow.decrease();
					snow.detectCollision(player);
				}
				
			}
		};

		// 주기적으로 실행 (현재 180ms마다)
		timer = new Timer(180, listener);
		timer.start();

		// 외곽선
		setBorder(BorderFactory.createLineBorder(Color.black));

		// 키설정
		new KeySetting(this);
	}

	// 화면 리프레쉬
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent");
		super.paintComponent(g);
		//내 캐릭터 그리고
		player.paint(g);
		//상대편 캐릭터도 그리고
		opponent.paint(g);
		//내가던진 눈 그리고
		for (Snow snow : snows) {
			snow.paint(g);
		}
		//상대편이 던진 눈 그리고
		for (Snow snow : enemySnows) {
			snow.paint(g);
		}
	}

	

}