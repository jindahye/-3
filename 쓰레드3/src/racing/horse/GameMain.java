package racing.horse;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameMain extends JFrame implements ActionListener {

	GameView[] gv = new GameView[5];
	JProgressBar[] bar = new JProgressBar[5];
	JTextArea ta;
	JMenuItem initItem, startItem, exitItem;

	public GameMain() {
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("메뉴");
		initItem = new JMenuItem("준비");
		startItem = new JMenuItem("시작");
		exitItem = new JMenuItem("종료");

		menu.add(initItem);
		menu.add(startItem);
		menu.addSeparator();
		menu.add(exitItem);
		mb.add(menu);

		// 윈도우 메뉴배치
		setJMenuBar(mb);

		ta = new JTextArea();
		JScrollPane js = new JScrollPane(ta);

		Color[] color = { Color.yellow, Color.pink, Color.magenta, Color.CYAN, Color.green };

		setLayout(null);

		for (int i = 0; i < 5; i++) {
			gv[i] = new GameView(this);

			bar[i] = new JProgressBar(0, 1000);
			bar[i].setBackground(Color.white);
			bar[i].setForeground(color[i]);
			bar[i].setStringPainted(true);

			gv[i].setBounds(10, 125 + (i * 100), 1000, 60);
			bar[i].setBounds(10, 185 + (i * 100), 1000, 30);

			add(gv[i]);
			add(bar[i]);
		}

		js.setBounds(10, 15, 1000, 100);
		add(js);

		setSize(1030, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initItem.addActionListener(this);
		startItem.addActionListener(this);
		exitItem.addActionListener(this);

	}

	public static void main(String[] args) {
		new GameMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitItem) {
			dispose();
			System.exit(0);
		} else if (e.getSource() == initItem) {

			ta.setText("");
			GameView.grade = 0;

			for (int i = 0; i < 5; i++) {
				gv[i].x = 0;
				bar[i].setValue(0);

			}

		} else if (e.getSource() == startItem) {

			String[] name = { "박도경말", "흙해영말", "이진상말", "박수경말", "금해영말" };
			for(int i=0;i<5;i++){
				gv[i].ht.threadName(name[i]);
				
			}
		}
		
		
	}
}
