package com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

import obj.Player;
import obj.Snow;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	// 플레이어
	public Map<String, Player> players = new HashMap<String, Player>();
		
		
	Timer timer;

	public MainPanel() {

		// 플레이어 추가
		Player p1 = new Player("lifenjoy51", 1);
		Player p2 = new Player("osm", 2);

		players.put("p1", p1);
		players.put("p2", p2);

		// 주기적 실행로직
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 다시 그리기 -> paintComponent를 실행한다
				repaint();

				// 돌려돌려
				for (Entry<String, Player> entry : players.entrySet()) {
					Player player = entry.getValue(); 
					for (Snow snow : player.snows) {
						snow.increase();
						snow.detectCollision(players);
					}
					// 플레이어 hp체크
					if (!player.isAlive()) {
						System.out.println(player.getName() + " lose");
					}
				}

			}
		};

		// 주기적으로 실행 (현재 180ms마다)
		timer = new Timer(10, listener);
		timer.start();

		// 외곽선
		setBorder(BorderFactory.createLineBorder(Color.black));

		// 키설정
		new KeySetting(this);
	}

	// 화면 리프레쉬
	public void paintComponent(Graphics g) {
		//System.out.println("paintComponent");
		super.paintComponent(g);
		// 캐릭터 그리고
		for (Entry<String, Player> entry : players.entrySet()) {
			Player player = entry.getValue(); 
			player.paint(g);
			for (Snow snow : player.snows) {
				snow.paint(g);
			}
		}
	}

}