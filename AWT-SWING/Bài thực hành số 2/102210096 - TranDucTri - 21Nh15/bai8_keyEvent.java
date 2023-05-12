
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bai8_keyEvent extends JFrame implements KeyListener {

	JLabel txt;
	JPanel pn;
	public bai8_keyEvent(String t) {
		super(t);
		GUI();
	}
	public void GUI() {
		txt=new JLabel("KeyCharEvent show here");
		pn=new JPanel(new GridBagLayout());
		addKeyListener(this);
		pn.add(txt,new GridBagConstraints());
		add(pn);

		setSize(500,500);
		show();
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		txt.setText(String.valueOf(e.getKeyChar()));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowClosing(WindowEvent we) {
		dispose();
		System.exit(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new bai8_keyEvent("Key Event Test");
	}

	


}
