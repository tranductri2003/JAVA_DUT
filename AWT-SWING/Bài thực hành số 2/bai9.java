import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class bai9 extends JFrame implements MouseListener {
	JPanel pn;
	
	public void GUI() {
		pn = new JPanel();
		pn.addMouseListener(this);
		add(pn);
		
		setSize(300, 200);
		setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			System.out.println("you left click the mouse at "+ e.getX()+" "+ e.getY() );
		}
		if(e.getButton()==MouseEvent.BUTTON3) {
			System.out.println("you right click the mouse at "+ e.getX()+" "+ e.getY() );
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("you press the window at "+ e.getX()+" "+e.getY() );
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("you released the window at "+ e.getX()+" "+e.getY() );
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("you enter the window at "+ e.getX()+" "+e.getY() );		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("you exit the window at "+ e.getX()+" "+e.getY() );
	}
	public bai9(String str) {
		super(str);
		GUI();
	}
	public static void main(String[] args) {
		new bai9("Mouse Test");
	}
	
}