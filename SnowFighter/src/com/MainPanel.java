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
	public Player player = new Player();
	// 상대편
	public Player opponent = new Player();

	// 내가 던지는 눈
	public List<Snow> snows = new LinkedList<Snow>();
	// 상대방이 던지는 눈
	public List<Snow> enemySnows = new LinkedList<Snow>();

	Timer timer;

	public MainPanel() {

		// 주기적 실행로직
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 다시 그리기 -> paintComponent를 실행한다
				repaint();
				// 눈 움직이기
				for (Snow snow : snows) {
					snow.increase();
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
		player.paintSquare(g);
		for (Snow snow : snows) {
			snow.paint(g);
		}
	}

	

}