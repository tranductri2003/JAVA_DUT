import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.nio.file.FileAlreadyExistsException;

public class bai1 extends JFrame implements ActionListener
{
    private JLabel lblA, lblB, lblC, lblRes;
    private JTextField txtA, txtB, txtC, txtRes;
    private  JButton btnArea, btnChuvi;

    public bai1(String s)
    {
        super(s);
        GUI();
    }
    public void GUI()
    {
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setSize(600,400);

        lblA = new JLabel("Độ dài cạnh a: ");
        lblB = new JLabel("Độ dài cạnh b: ");
        lblC = new JLabel("Độ dài cạnh c: ");
        lblRes = new JLabel("Kết quả: ");
        lblA.setHorizontalAlignment(SwingConstants.RIGHT);
        lblB.setHorizontalAlignment(SwingConstants.RIGHT);
        lblC.setHorizontalAlignment(SwingConstants.RIGHT);
        lblRes.setHorizontalAlignment(SwingConstants.RIGHT);

        txtA = new JTextField(6);
        txtB = new JTextField(6);
        txtC = new JTextField(6);
        txtRes = new JTextField(6);
        txtRes.setEditable(false);

        btnArea = new JButton("Tính diện tích");
        btnChuvi = new JButton("Tính chu vi");

        lblA.setBounds(0,40,200,30);
        lblB.setBounds(0,90,200,30);
        lblC.setBounds(0,140,200,30);
        lblRes.setBounds(0,190,200,30);

        txtA.setBounds(240,40,200,30);
        txtB.setBounds(240,90,200,30);
        txtC.setBounds(240,140,200,30);
        btnArea.setBounds(240,190,200,30);
        btnChuvi.setBounds(240,240,200,30);
        txtRes.setBounds(240,290,200,30);

        btnArea.addActionListener(this);
        btnChuvi.addActionListener(this);

        add(lblA);
        add(lblB);
        add(lblC);
        add(lblRes);
        add(txtA);
        add(txtB);
        add(txtC);
        add(txtRes);
        add(btnArea);
        add(btnChuvi);

        show();
    }

    public void windowClosing (WindowEvent we)
    {
        dispose();
        System.exit(0);
    }

    public boolean check(double a, double b, double c)
    {
        if (a>=b+c || b>=a+c || c>=a+b)
        {
            return false;
        }
        else
        {
            return true;
        }
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {


        if (e.getSource()==btnArea)
        {

            try
            {
                double a = Double.parseDouble(txtA.getText());
                double b = Double.parseDouble(txtB.getText());
                double c = Double.parseDouble(txtC.getText());
                if (check(a,b,c))
                {
                    double p1 = (a+b+c)/2;
                    double s = Math.sqrt(p1*(p1-a)*(p1-b)*(p1-c));
                    txtRes.setText(Double.toString(s));
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "3 cạnh không tạo thành tam giác");
                }
            }
            catch (Exception p)
            {
                JOptionPane.showMessageDialog(this, "Thông tin của bạn không hợp lệ");
            }
        }
        else if (e.getSource()==btnChuvi)
        {
            try
            {
                double a = Double.parseDouble(txtA.getText());
                double b = Double.parseDouble(txtB.getText());
                double c = Double.parseDouble(txtC.getText());
                if (check(a,b,c))
                {
                    double p =a+b+c;
                    txtRes.setText(Double.toString(p));
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "3 cạnh không tạo thành tam giác");
                }
            }
            catch (Exception p)
            {
                JOptionPane.showMessageDialog(this, "Thông tin của bạn không hợp lệ");
            }
        }
    }

    public static void main(String args[])
    {
        bai1 bai1 = new bai1("BAI 1");
    }
}
