import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bai7_itemEvent extends JFrame implements ItemListener {

	Checkbox male,female;
	JLabel lb;
	Choice choice;
	List list;
	JPanel panel;
	
	public bai7_itemEvent(String t) {
		super(t);
		GUI();
	}
	public void GUI() {
		lb=new JLabel("The event display here");
		
		male=new Checkbox("Male");
		female=new Checkbox("Female");
		
		choice =new Choice();
		choice.add("MS-DOS");
		choice.add("Window 95");
		choice.add("Window 98");
		choice.add("Window XP");
		choice.add("Window Vista");
		choice.add("Window 7");
		choice.add("Window 8");
		choice.add("Window 10");
		choice.add("Window 11");
		
		list=new List(3,false);
		list.add("Tiger");
		list.add("Elephant");
		list.add("Lion");
		list.add("Cat");
		list.add("Dog");
		
		male.addItemListener(this);
		female.addItemListener(this);
		
		choice.addItemListener(this);
		list.addItemListener(this);
		
		
		panel=new JPanel(new FlowLayout());
		panel.add(male);
		panel.add(female);
		panel.add(choice);
		panel.add(list);
		panel.add(lb);
		
		add(panel);
		setSize(400,300);
		show();
		
		
		
	}
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==male) 
		{
			if (male.getState())
				lb.setText("You already chose Male checkbox");
			else
				lb.setText("You deselected Male checkbox");

		}
		if(e.getSource()==female) {
			if (female.getState())
				lb.setText("You already chose FeMale checkbox");
			else
				lb.setText("You deselected FeMale checkbox");		}
		if(e.getSource()==choice) {
			lb.setText("You already chose item in Choice "+choice.getSelectedItem());
		}
		if(e.getSource()==list) {
			lb.setText("You already chose item in List "+list.getSelectedItem());
		}
	}
	public void windowClosing(WindowEvent we) {
		dispose();
		System.exit(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new bai7_itemEvent("Item event test");
	}
}
