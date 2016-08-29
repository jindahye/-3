



package skiing.alpine;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameMain extends JFrame implements KeyListener{

	
	GameView gv=new GameView();
	public GameMain() {
		add("Center",gv);
		setSize(330,450);
		setVisible(true);
		addKeyListener(this);
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println(e.getKeyCode());
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			gv.x-=3;
			if(gv.x<20){
				gv.x=20;
			}
				break;
				
		case KeyEvent.VK_RIGHT:
			gv.x+=3;
			if(gv.x>290){
				gv.x=290;
			}
			break;
			
		case KeyEvent.VK_ESCAPE:
		System.exit(0);
		break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	public static void main(String[] args) {
		new GameMain();
	}
	
	
	
}
