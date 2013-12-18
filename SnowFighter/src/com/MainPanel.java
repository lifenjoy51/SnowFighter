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

	// ��
	public Player player = new Player();
	// �����
	public Player opponent = new Player();

	// ���� ���� ��
	public List<Snow> snows = new LinkedList<Snow>();
	// ������� ���� ��
	public List<Snow> enemySnows = new LinkedList<Snow>();

	Timer timer;

	public MainPanel() {

		// ���η����� ������
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �ִϸ��̼� �ٽ� �׸���
				repaint();
				// ���� ���õ� ������
				for (Snow snow : snows) {
					snow.increase();
				}
			}
		};

		// Ÿ�̸ӿ� ���缭 ������ ����(���� 180ms����)
		timer = new Timer(180, listener);
		timer.start();

		// ����� �����
		setBorder(BorderFactory.createLineBorder(Color.black));

		// Ű���� ����
		new KeySetting(this);
	}

	// ui�� �׸��°�
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent");
		super.paintComponent(g);
		player.paintSquare(g);
		for (Snow snow : snows) {
			snow.paint(g);
		}
	}

	

}