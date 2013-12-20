package com;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import obj.Player;
import obj.Snow;

public class KeySetting {
	@SuppressWarnings("serial")
	public KeySetting(final MainPanel panel) {

		final Player p1 = panel.players.get("p1");
		final Player p2 = panel.players.get("p2");

		// 스페이스
		panel.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "SPACE key");
		panel.getActionMap().put("SPACE key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("SPACE!!");
				Snow snow = new Snow(p1, 5);
				p1.snows.add(snow);
				System.out.println();
			}
		});

		// 왼쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LEFT key");
		panel.getActionMap().put("LEFT key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("LEFT!!");
				p1.move(-1, 0);
			}
		});

		// 오른쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT key");
		panel.getActionMap().put("RIGHT key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("RIGHT!!");
				p1.move(1, 0);
			}
		});

		// 위로
		panel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "UP key");
		panel.getActionMap().put("UP key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("UP!!");
				p1.move(0, -1);
			}
		});

		// 아래로
		panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "DOWN key");
		panel.getActionMap().put("DOWN key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("DOWN!!");
				p1.move(0, 1);
			}
		});

		/**
		 * 상대편 컨트롤
		 */
		panel.getInputMap().put(KeyStroke.getKeyStroke('t'), "TAB key");
		panel.getActionMap().put("TAB key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("TAB!!");
				Snow snow = new Snow(p2, 4);
				p2.snows.add(snow);
			}
		});

		// 왼쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke('a'), "a key");
		panel.getActionMap().put("a key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("a!!");
				p2.move(-1, 0);
			}
		});

		// 오른쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke('d'), "d key");
		panel.getActionMap().put("d key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("d!!");
				p2.move(1, 0);
			}
		});

		// 위로
		panel.getInputMap().put(KeyStroke.getKeyStroke('w'), "w key");
		panel.getActionMap().put("w key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("w!!");
				p2.move(0, -1);
			}
		});

		// 아래로
		panel.getInputMap().put(KeyStroke.getKeyStroke('s'), "s key");
		panel.getActionMap().put("s key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("DOWN!!");
				p2.move(0, 1);
			}
		});
	}
}
