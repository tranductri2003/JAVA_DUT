import java.awt.*;
import java.awt.event.*;
import javax.swing.*;;



public class bai2_PhepToanSoHoc extends JFrame implements ActionListener
{
    JPanel pn, pn1, pn2, pn3, pn4;
    JLabel lb, lb1, lb2, lb3;
    JTextField txt1, txt2, txtkq;
    JButton btnadd, btnsub, btnmul, btndiv, btnre, btnexit;
    public bai2_PhepToanSoHoc(String st)
    {
        super(st);
        GUI();
    }
    public void GUI()
    {
        lb = new JLabel("Basic Arithmetic Operations");
        lb1 = new JLabel("Number 1: ");
        lb2 = new JLabel("Number 2: ");
        lb3 = new JLabel("Result: ");

        txt1 = new JTextField(7);
        txt2 = new JTextField(7);
        txtkq = new JTextField(7);
        txtkq.setEditable(false);

		btnadd=new JButton("Addition");
		btnsub=new JButton("Subtraction");
		btnmul=new JButton("Multiplication");
		btndiv=new JButton("Division");
		btnre=new JButton("Reset");
		btnexit=new JButton("Exit");

		btnadd.addActionListener(this);
		btnsub.addActionListener(this);
		btnmul.addActionListener(this);
		btndiv.addActionListener(this);
		btnre.addActionListener(this);
		btnexit.addActionListener(this);

		pn=new JPanel(new GridLayout(4,1));
		pn1=new JPanel(new FlowLayout());
		pn2=new JPanel(new GridLayout(3,2));
		pn3=new JPanel(new FlowLayout());
		pn4=new JPanel(new FlowLayout());        

		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txt1);
		
		pn2.add(lb2);
		pn2.add(txt2);
		
		pn2.add(lb3);
		pn2.add(txtkq);
		
		pn3.add(btnadd);
		pn3.add(btnsub);
		pn3.add(btnmul);
		pn3.add(btndiv);
		
		pn4.add(btnre);
		pn4.add(btnexit);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		add(pn);
		setSize(500,400); 
        show();
    }
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnadd) {
			float a=Float.parseFloat(txt1.getText());
			float b=Float.parseFloat(txt2.getText());
			txtkq.setText(Float.toString(a+b));
		}
		if(e.getSource()==btnsub) {
			float a=Float.parseFloat(txt1.getText());
			float b=Float.parseFloat(txt2.getText());
			txtkq.setText(Float.toString(a-b));
		}
		if(e.getSource()==btnmul) {
			float a=Float.parseFloat(txt1.getText());
			float b=Float.parseFloat(txt2.getText());
			txtkq.setText(Float.toString(a*b));
		}
		if(e.getSource()==btndiv) {
			float a=Float.parseFloat(txt1.getText());
			float b=Float.parseFloat(txt2.getText());
			if(b!=0) txtkq.setText(Float.toString(a/b));
			else txtkq.setText("Cannot division to 0");
		}
		if(e.getSource()==btnre) {
			txt1.setText("");
			txt2.setText("");
			txtkq.setText("");
		}
		if(e.getSource()==btnexit) System.exit(0);
	}
	public void windowClosing(WindowEvent we) 
    {
		dispose();
		System.exit(0);
	}
    public static void main(String[] args)
    {
        new bai2_PhepToanSoHoc("Arithmetic Operations");
    }
}
