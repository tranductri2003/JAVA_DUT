
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bai3_doiMauNen extends JFrame implements ActionListener 
{
	JButton btnRed,btnGreen,btnBlue,btnExit;
	JPanel pn,pn1;
	public bai3_doiMauNen(String st) 
    {
		super(st);
		GUI();
	}
	public void GUI() 
    {
		btnRed=new JButton("RED");
		btnGreen=new JButton("GREEN");
		btnBlue=new JButton("BLUE");
		btnExit=new JButton("Thoat");
		
		btnRed.addActionListener(this);
		btnGreen.addActionListener(this);
		btnBlue.addActionListener(this);
		btnExit.addActionListener(this);
		
		
		pn=new JPanel(new BorderLayout());
		pn1=new JPanel(new FlowLayout());
		
		pn1.add(btnRed);
		pn1.add(btnGreen);
		pn1.add(btnBlue);
		pn1.add(btnExit);
		
		pn.add(pn1,BorderLayout.SOUTH);
		
		
		add(pn);
		setSize(500,400);
        show();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRed) {
			pn.setBackground(Color.red);
			pn1.setBackground(Color.red);
		}
		if(e.getSource()==btnGreen) {
			pn.setBackground(Color.green);
			pn1.setBackground(Color.green);
		}
		if(e.getSource()==btnBlue) {
			pn.setBackground(Color.blue);
			pn1.setBackground(Color.blue);
		}
		if(e.getSource()==btnExit) System.exit(0);
	}
	public void windowClosing(WindowEvent we) {
		dispose();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new bai3_doiMauNen("Color change");
	}

}
