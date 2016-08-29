
package skiing.alpine;

import java.awt.*;
import javax.swing.*;

public class GameView extends JPanel {

	Image img0, img1, img21, img22, img31, img32;
	int backNo; // 알파인 스키의 백그라운드 이미지 표시
	int type = 0; // 알파인 스키의 역동성 위해 타입 구분.

	Image[] front = new Image[4]; // 움직이는 스키선수 이미지들
	int humanNo = 0;
	int x = 153, y = 350; // 스키선수 최초 위치
	int move = 0; // 움직임을 나타내기 위한 변수

	public GameView() {
		img0 = Toolkit.getDefaultToolkit().getImage("image\\img0.png");
		img1 = Toolkit.getDefaultToolkit().getImage("image\\img1.png");
		img21 = Toolkit.getDefaultToolkit().getImage("image\\img21.png");
		img22 = Toolkit.getDefaultToolkit().getImage("image\\img22.png");
		img31 = Toolkit.getDefaultToolkit().getImage("image\\img31.png");
		img32 = Toolkit.getDefaultToolkit().getImage("image\\img32.png");

		for (int i = 0; i < 4; i++) {
			front[i] = Toolkit.getDefaultToolkit().getImage("image\\front0" + (i + 1) + ".png");

		}
		//두개 의 스레드를 뉴만햇지 스타트 안함
		new BackThread().start();
		new HumanThread().start();
	}

	// 알파인 스키 눈 배경 표현 스레드.
	class BackThread extends Thread {

		@Override
		public void run() {
			while (true) {

				try {
					backNo = backNo % 2;
					if (backNo == 0) {
						type = 0;
					} else {
						type = 1;
					}
					backNo++;

					Thread.sleep(100);

					repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}

	// 변경사항을 포함해서 전체를 다시 그려주는 부분
	@Override
	public void paint(Graphics g) {
		g.drawImage(img0, 0, 0, this); // 백그라운드 이미지 위쪽 그림0
		g.drawImage(img1, 0, 90, this); // 백그라운드 이미지 위쪽그림1

		if (type == 0) { // 움직임 표현
			g.drawImage(img21, 0, 190, this);
			g.drawImage(img31, 0, 310, this);
		} else {

			g.drawImage(img22, 0, 190, this);
			g.drawImage(img32, 0, 310, this);

		}

		g.drawImage(front[move], x, y, this); // 스키선수의 움직임

	}

	// 스키선수 스레드
	class HumanThread extends Thread {
		@Override
		public void run() {

			while (true) {

				try {
					humanNo = humanNo % 2; // 움직임 좌우
					move = move % 4; // 스키선수 이미지 4개 반복해서 변경

					if (humanNo == 0) { // 위치를 좌우로 번갈아 움직이게 하기
						x -= 5;

					} else {
						x += 5;
					}

					Thread.sleep(100);
					repaint();

					humanNo++;
					move++;
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}

		}
	}

}
