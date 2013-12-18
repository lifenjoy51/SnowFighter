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

	// 나
	public Player player = new Player();
	// 상대편
	public Player opponent = new Player();

	// 내가 던진 눈
	public List<Snow> snows = new LinkedList<Snow>();
	// 상대편이 던진 눈
	public List<Snow> enemySnows = new LinkedList<Snow>();

	Timer timer;

	public MainPanel() {

		// 메인루프를 돌린다
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 애니메이션 다시 그리고
				repaint();
				// 눈에 관련된 로직들
				for (Snow snow : snows) {
					snow.increase();
				}
			}
		};

		// 타이머에 맞춰서 루프를 돌림(현재 180ms마다)
		timer = new Timer(180, listener);
		timer.start();

		// 껍대기 씌우고
		setBorder(BorderFactory.createLineBorder(Color.black));

		// 키관련 셋팅
		new KeySetting(this);
	}

	// ui를 그리는곳
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent");
		super.paintComponent(g);
		player.paintSquare(g);
		for (Snow snow : snows) {
			snow.paint(g);
		}
	}

	

}