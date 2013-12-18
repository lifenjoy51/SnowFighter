package com;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	// GUI 화면 생성
	private static void createAndShowGUI() {
		JFrame f = new JFrame("Snow Fighter");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MainPanel());
		f.setSize(300, 400);
		f.setVisible(true);
	}

}
