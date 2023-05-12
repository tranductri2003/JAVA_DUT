
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bai6_actionEvent extends JFrame implements ActionListener {
	JButton btnok;
	JTextField txt;
	List list;
	JLabel lb;
	JPanel panel;
	public bai6_actionEvent(String st) {
		super(st);
		GUI();
	}
	public void GUI() {
		
		btnok=new JButton("OK");
		txt=new JTextField(7);
		lb=new JLabel("The event display here");
		list=new List(3,false);
		
		btnok.addActionListener(this);
		txt.addActionListener(this);
		list.addActionListener(this);
		
		list.add("Tiger");
		list.add("Elephant");
		list.add("Lion");
		list.add("Cat");
		list.add("Dog");
		
		panel=new JPanel(new FlowLayout());
		
		panel.add(btnok);
		panel.add(txt);
		panel.add(list);
		panel.add(lb);
		
		add(panel);
		
		setSize(300,200);
		
		show();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnok) {
			lb.setText("You already click button");
		}
		if(e.getSource()==txt) {
			lb.setText("You already enter in the TextField");
		}
		if(e.getSource()==list) {
			lb.setText("You already select in list "+list.getSelectedItem());
		}
	}
	public void windowClosing(WindowEvent we) {
		dispose();
		System.exit(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new bai6_actionEvent("Action Event Test");
	}

}
