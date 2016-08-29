
package skiing.alpine;

import java.awt.*;
import javax.swing.*;

public class GameView extends JPanel {

	Image img0, img1, img21, img22, img31, img32;
	int backNo; // ������ ��Ű�� ��׶��� �̹��� ǥ��
	int type = 0; // ������ ��Ű�� ������ ���� Ÿ�� ����.

	Image[] front = new Image[4]; // �����̴� ��Ű���� �̹�����
	int humanNo = 0;
	int x = 153, y = 350; // ��Ű���� ���� ��ġ
	int move = 0; // �������� ��Ÿ���� ���� ����

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
		//�ΰ� �� �����带 �������� ��ŸƮ ����
		new BackThread().start();
		new HumanThread().start();
	}

	// ������ ��Ű �� ��� ǥ�� ������.
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

	// ��������� �����ؼ� ��ü�� �ٽ� �׷��ִ� �κ�
	@Override
	public void paint(Graphics g) {
		g.drawImage(img0, 0, 0, this); // ��׶��� �̹��� ���� �׸�0
		g.drawImage(img1, 0, 90, this); // ��׶��� �̹��� ���ʱ׸�1

		if (type == 0) { // ������ ǥ��
			g.drawImage(img21, 0, 190, this);
			g.drawImage(img31, 0, 310, this);
		} else {

			g.drawImage(img22, 0, 190, this);
			g.drawImage(img32, 0, 310, this);

		}

		g.drawImage(front[move], x, y, this); // ��Ű������ ������

	}

	// ��Ű���� ������
	class HumanThread extends Thread {
		@Override
		public void run() {

			while (true) {

				try {
					humanNo = humanNo % 2; // ������ �¿�
					move = move % 4; // ��Ű���� �̹��� 4�� �ݺ��ؼ� ����

					if (humanNo == 0) { // ��ġ�� �¿�� ������ �����̰� �ϱ�
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
