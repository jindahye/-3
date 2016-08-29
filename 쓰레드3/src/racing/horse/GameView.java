
package racing.horse;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GameView extends JPanel {

	Image horse;
	int x, y;
	GameMain gm; // has a 관계 게임메인의 멤버들을 쓰겟다
	static int grade;
	HoresThread ht;

	// 주소값
	public GameView(GameMain gm) {
		this.gm = gm;
		horse = Toolkit.getDefaultToolkit().getImage("image\\horse.gif");

		ht = new HoresThread();

	}

	/*
	 * 
	 * update() { clearRect(), paint() } repaint g=>그림을 그리는 도구
	 * 
	 * 
	 */

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight()); // 꽉차게그리기
		g.drawImage(horse, x, y, this);

	}

	class HoresThread extends Thread {
		@Override
		public void run() {
			try {
				for (int i = 0; i <= 1000; i++) {
					if (Thread.currentThread().getName().equals("박도경말")) {
						x += 10;
						gm.bar[0].setValue(x);
						if (x > 1000) {
							x = 1300;
							grade++;
							
							String res = "★★★박도경말★★★☞" + grade + "등\n";
							gm.ta.append(res);
							interrupt(); // 강제종료

						}
						Random rnd = new Random();
						int s = rnd.nextInt(301) + 50;
						Thread.sleep(s);
					}
					if (Thread.currentThread().getName().equals("흙해영말")) {

						x += 10;
						gm.bar[1].setValue(x);
						if (x > 1000) {
							x = 1300;
							grade++;
							String res = "★★★흙해영말★★★☞" + grade + "등\n";
							gm.ta.append(res);
							interrupt(); // 강제종료
						}
						Random rnd = new Random();
						int s = rnd.nextInt(301) + 50;
						Thread.sleep(s);
					}
					if (Thread.currentThread().getName().equals("이진상말")) {
						x += 10;
						gm.bar[2].setValue(x);
						if (x > 1000) {
							x = 1300;
							grade++;
							String res = "★★★이진상말★★★☞" + grade + "등\n";
							gm.ta.append(res);
							interrupt(); // 강제종료
						}
						Random rnd = new Random();
						int s = rnd.nextInt(301) + 50;
						Thread.sleep(s);
					}
					if (Thread.currentThread().getName().equals("박수경말")) {

						x += 10;
						gm.bar[3].setValue(x);
						if (x > 1000) {
							x = 1300;
							grade++;
							String res = "★★★박수경말★★★☞" + grade + "등\n";
							gm.ta.append(res);
							interrupt(); // 강제종료
						}
						Random rnd = new Random();
						int s = rnd.nextInt(301) + 50;
						Thread.sleep(s);
					}
					if (Thread.currentThread().getName().equals("금해영말")) {
						x += 10;
						gm.bar[4].setValue(x);
						if (x > 1000) {
							x = 1300;
							grade++;
							String res = "★★★금해영말★★★☞" + grade + "등\n";
							gm.ta.append(res);
							interrupt(); // 강제종료
						}
						Random rnd = new Random();
						int s = rnd.nextInt(301) + 50;
						Thread.sleep(s);
					}
				}
			} catch (InterruptedException e) {
				return; // 해당스레드종료
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