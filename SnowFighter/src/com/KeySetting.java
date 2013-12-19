package com;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import obj.Snow;

public class KeySetting {
	@SuppressWarnings("serial")
	public KeySetting(final MainPanel panel) {
		
		//스페이스
		panel.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "SPACE key");
		panel.getActionMap().put("SPACE key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("SPACE!!");
				Snow snow = new Snow(panel.player.getX(), panel.player.getY(),
						5);
				panel.snows.add(snow);
			}
		});

		//왼쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LEFT key");
		panel.getActionMap().put("LEFT key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("LEFT!!");
				panel.player.move(-1, 0);
			}
		});

		//오른쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT key");
		panel.getActionMap().put("RIGHT key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("RIGHT!!");
				panel.player.move(1, 0);
			}
		});
		
		//위로
		panel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "UP key");
		panel.getActionMap().put("UP key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("UP!!");
				panel.player.move(0, -1);
			}
		});

		//아래로
		panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "DOWN key");
		panel.getActionMap().put("DOWN key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("DOWN!!");
				panel.player.move(0, 1);
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
				Snow snow = new Snow(panel.opponent.getX(), panel.opponent.getY(), 5);
				panel.enemySnows.add(snow);
			}
		});

		//왼쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke('a'), "a key");
		panel.getActionMap().put("a key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("a!!");
				panel.opponent.move(-1, 0);
			}
		});

		//오른쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke('d'), "d key");
		panel.getActionMap().put("d key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("d!!");
				panel.opponent.move(1, 0);
			}
		});
		
		//위로
		panel.getInputMap().put(KeyStroke.getKeyStroke('w'), "w key");
		panel.getActionMap().put("w key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("w!!");
				panel.opponent.move(0, -1);
			}
		});

		//아래로
		panel.getInputMap().put(KeyStroke.getKeyStroke('s'), "s key");
		panel.getActionMap().put("s key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("DOWN!!");
				panel.opponent.move(0, 1);
			}
		});
	}
}
