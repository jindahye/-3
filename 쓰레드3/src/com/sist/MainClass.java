
package com.sist;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MainClass extends JFrame implements Runnable, ActionListener {

	JLabel la1, la2, la3, la4;
	JProgressBar bar1, bar2, bar3;
	JButton b1, b2;
	JTextField tf1, tf2, tf3;

	public MainClass() {

		la1 = new JLabel("2016�� ���� ����");
		la1.setFont(new Font("���� ���", Font.BOLD, 30));

		la2 = new JLabel("������");
		la3 = new JLabel("������");
		la4 = new JLabel("�ǰ���");

		bar1 = new JProgressBar(0, 100);
		bar1.setStringPainted(true); // �������Բ�
		bar2 = new JProgressBar(0, 100);
		bar2.setStringPainted(true); // �������Բ�
		bar3 = new JProgressBar(0, 100);
		bar3.setStringPainted(true); // �������Բ�

		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();

		b1 = new JButton("start");
		b2 = new JButton("exit");
		// TODO Auto-generated constructor stub

		setLayout(null);
		JPanel p1 = new JPanel();
		p1.add(la1);
		p1.setBounds(10, 15, 570, 40);

		la2.setBounds(10, 65, 50, 30);
		bar1.setBounds(65, 65, 400, 30);
		tf1.setBounds(470, 65, 110, 30);

		la3.setBounds(10, 100, 50, 30);
		bar2.setBounds(65, 100, 400, 30);
		tf2.setBounds(470, 100, 110, 30);

		la4.setBounds(10, 135, 50, 30);
		bar3.setBounds(65, 135, 400, 30);
		tf3.setBounds(470, 135, 110, 30);

		JPanel p2 = new JPanel();
		p2.add(b1);
		p2.add(b2);
		p2.setBounds(10, 170, 570, 35);

		add(p1);

		add(la2);
		add(bar1);
		add(tf1);
		add(la3);
		add(bar2);
		add(tf2);
		add(la4);
		add(bar3);
		add(tf3);
		add(p2);

		setSize(600, 450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		b1.addActionListener(this);
		b2.addActionListener(this);

	}

	public static void main(String[] args) {
		new MainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			new Thread(this).start(); // ���⼭ ���ʺ���� ������ �츮�� ���ʺ� ��ӹް������ϱ� this
										// �ɾ��ָ� ��
		} else if (b2 == e.getSource()) {
			System.exit(0);

		}

		// TODO Auto-generated method stub

	}

	@Override
	public void run() {// �޼ҵ�� ���� ����

		go();
		try {
			Random rnd = new Random();
			int a = rnd.nextInt(101);
			int b = rnd.nextInt(101);
			int c = rnd.nextInt(101);

			for (int i = 0; i <= a; i++) {
				bar1.setValue(i);
				Thread.sleep(10);

				tf1.setText(a + "%");
			}

			for (int i = 0; i <= b; i++) {
				bar2.setValue(i);
				Thread.sleep(10);

				tf2.setText(b + "%");
			}

			for (int i = 0; i <= c; i++) {
				bar3.setValue(i);
				Thread.sleep(10);

				tf3.setText(c + "%");
			}

		} catch (Exception e) {

			e.printStackTrace();

			// TODO: handle exception
		}
	}

	public void go() {

	}

}
