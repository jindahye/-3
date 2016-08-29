
package racing.horse;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GameView extends JPanel {

	Image horse;
	int x, y;
	GameMain gm; // has a ���� ���Ӹ����� ������� ���ٴ�
	static int grade;
	HoresThread ht;

	// �ּҰ�
	public GameView(GameMain gm) {
		this.gm = gm;
		horse = Toolkit.getDefaultToolkit().getImage("image\\horse.gif");

		ht = new HoresThread();

	}

	/*
	 * 
	 * update() { clearRect(), paint() } repaint g=>�׸��� �׸��� ����
	 * 
	 * 
	 */

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight()); // �����Ա׸���
		g.drawImage(horse, x, y, this);

	}

	class HoresThread extends Thread {
		@Override
		public void run() {
			try {
				for (int i = 0; i <= 1000; i++) {
					if (Thread.currentThread().getName().equals("�ڵ��渻")) {
						x += 10;
						gm.bar[0].setValue(x);
						if (x > 1000) {
							x = 1300;
							grade++;
							
							String res = "�ڡڡڹڵ��渻�ڡڡڢ�" + grade + "��\n";
							gm.ta.append(res);
							interrupt(); // ��������

						}
						Random rnd = new Random();
						int s = rnd.nextInt(301) + 50;
						Thread.sleep(s);
					}
					if (Thread.currentThread().getName().equals("���ؿ���")) {

						x += 10;
						gm.bar[1].setValue(x);
						if (x > 1000) {
							x = 1300;
							grade++;
							String res = "�ڡڡ����ؿ����ڡڡڢ�" + grade + "��\n";
							gm.ta.append(res);
							interrupt(); // ��������
						}
						Random rnd = new Random();
						int s = rnd.nextInt(301) + 50;
						Thread.sleep(s);
					}
					if (Thread.currentThread().getName().equals("������")) {
						x += 10;
						gm.bar[2].setValue(x);
						if (x > 1000) {
							x = 1300;
							grade++;
							String res = "�ڡڡ������󸻡ڡڡڢ�" + grade + "��\n";
							gm.ta.append(res);
							interrupt(); // ��������
						}
						Random rnd = new Random();
						int s = rnd.nextInt(301) + 50;
						Thread.sleep(s);
					}
					if (Thread.currentThread().getName().equals("�ڼ��渻")) {

						x += 10;
						gm.bar[3].setValue(x);
						if (x > 1000) {
							x = 1300;
							grade++;
							String res = "�ڡڡڹڼ��渻�ڡڡڢ�" + grade + "��\n";
							gm.ta.append(res);
							interrupt(); // ��������
						}
						Random rnd = new Random();
						int s = rnd.nextInt(301) + 50;
						Thread.sleep(s);
					}
					if (Thread.currentThread().getName().equals("���ؿ���")) {
						x += 10;
						gm.bar[4].setValue(x);
						if (x > 1000) {
							x = 1300;
							grade++;
							String res = "�ڡڡڱ��ؿ����ڡڡڢ�" + grade + "��\n";
							gm.ta.append(res);
							interrupt(); // ��������
						}
						Random rnd = new Random();
						int s = rnd.nextInt(301) + 50;
						Thread.sleep(s);
					}
				}
			} catch (InterruptedException e) {
				return; // �ش罺��������
				// TODO: handle exception
			}
		}
		
		public void threadName(String name){
			ht=new HoresThread();
			ht.setName(name);
			ht.start();
		}
	}
}