package com;

import java.awt.event.ActionEvent;
import java.io.IOException;

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
				
				String command = "throw";
				String player = "p1";
				String snowSpeed = "2";
				
				String params = command + "^" + player + "^" + snowSpeed;
				
				try {
					panel.conn.write(params);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});

		// 왼쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LEFT key");
		panel.getActionMap().put("LEFT key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("LEFT!!");
				
				String command = "move";
				String player = "p1";
				String dx = "-1";
				String dy = "0";
				
				String params = command + "^" + player + "^" + dx + "^" + dy;
				
				try {
					panel.conn.write(params);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		// 오른쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT key");
		panel.getActionMap().put("RIGHT key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("RIGHT!!");
				
				String command = "move";
				String player = "p1";
				String dx = "1";
				String dy = "0";
				
				String params = command + "^" + player + "^" + dx + "^" + dy;
				
				try {
					panel.conn.write(params);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		// 위로
		panel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "UP key");
		panel.getActionMap().put("UP key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("UP!!");
				
				String command = "move";
				String player = "p1";
				String dx = "0";
				String dy = "-1";
				
				String params = command + "^" + player + "^" + dx + "^" + dy;
				
				try {
					panel.conn.write(params);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		// 아래로
		panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "DOWN key");
		panel.getActionMap().put("DOWN key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("DOWN!!");
				
				String command = "move";
				String player = "p1";
				String dx = "0";
				String dy = "1";
				
				String params = command + "^" + player + "^" + dx + "^" + dy;
				
				try {
					panel.conn.write(params);
				} catch (IOException e) {
					e.printStackTrace();
				}
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
				
				String command = "throw";
				String player = "p2";
				String snowSpeed = "-3";
				
				String params = command + "^" + player + "^" + snowSpeed;
				
				try {
					panel.conn.write(params);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		// 왼쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke('a'), "a key");
		panel.getActionMap().put("a key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("a!!");
				
				String command = "move";
				String player = "p2";
				String dx = "-1";
				String dy = "0";
				
				String params = command + "^" + player + "^" + dx + "^" + dy;
				
				try {
					panel.conn.write(params);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		// 오른쪽
		panel.getInputMap().put(KeyStroke.getKeyStroke('d'), "d key");
		panel.getActionMap().put("d key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("d!!");
				
				String command = "move";
				String player = "p2";
				String dx = "1";
				String dy = "0";
				
				String params = command + "^" + player + "^" + dx + "^" + dy;
				
				try {
					panel.conn.write(params);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		// 위로
		panel.getInputMap().put(KeyStroke.getKeyStroke('w'), "w key");
		panel.getActionMap().put("w key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("w!!");
				
				String command = "move";
				String player = "p2";
				String dx = "0";
				String dy = "-1";
				
				String params = command + "^" + player + "^" + dx + "^" + dy;
				
				try {
					panel.conn.write(params);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		// 아래로
		panel.getInputMap().put(KeyStroke.getKeyStroke('s'), "s key");
		panel.getActionMap().put("s key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("DOWN!!");
				
				String command = "move";
				String player = "p2";
				String dx = "0";
				String dy = "1";
				
				String params = command + "^" + player + "^" + dx + "^" + dy;
				
				try {
					panel.conn.write(params);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
