import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bai1_PhuongTrinhBacNhat extends JFrame implements ActionListener
{
    JPanel pn, pn1, pn2, pn3;
    JLabel lb, lb1, lb2, lb3;
    JTextField txta, txtb, txtkq;
    JButton tinh, reset, thoat, exitbtn;
    public bai1_PhuongTrinhBacNhat(String st)
    {
        super(st);
        GUI();
    }
    public void GUI()
    {
        lb = new JLabel("GIAI PHUONG TRINH BAC NHAT");
        lb1 = new JLabel("Nhap a: ");
        lb2 = new JLabel("Nhap b: ");
        lb3 = new JLabel("Ket quan: ");

        txta = new JTextField(7);
        txtb = new JTextField(7);
        txtkq = new JTextField(7);

        tinh = new JButton("Tinh");
        reset = new JButton("Reset");
        thoat = new JButton("Thoat");

        tinh.addActionListener(this);
        reset.addActionListener(this);
        thoat.addActionListener(this);

        pn = new JPanel(new GridLayout(3,1));
        pn1 = new JPanel(new FlowLayout());
        pn2 = new JPanel(new GridLayout(3,2));
        pn3 = new JPanel(new GridLayout(1,3));

        pn1.add(lb);
			
		pn2.add(lb1);
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtb);
		pn2.add(lb3);
		pn2.add(txtkq);
			
		pn3.add(tinh);
		pn3.add(reset);
		pn3.add(thoat);
			
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);

        add(pn);
        setSize(800,600);
        show();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==tinh)
        {
            int a = Integer.parseInt(txta.getText());
            int b = Integer.parseInt(txtb.getText());
            if (a!=0)
            {
                txtkq.setText(Float.toString((float)-b/a));
            }
            else
            {
                if (b==0)
                {
                    txtkq.setText("Phuong trinh co vo so nghiem");
                }
                else
                {
                    txtkq.setText("Phuong trinh vo nghiem");
                }
            }
        }
        if (e.getSource()==reset)
        {
            txta.setText("");
            txtb.setText("");
            txtkq.setText("");
        }
        if (e.getSource()==thoat)
        {
            System.exit(0);
        }
    }
    public void windowClosing(WindowEvent we) 
    {
        dispose();
        System.exit(0);
    }
    public static void main(String[] args)
    {
        new bai1_PhuongTrinhBacNhat("Giai phuong trinh bac nhat");
    }

}