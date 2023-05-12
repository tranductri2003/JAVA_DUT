import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bai4_xuLiChuoiKiTu extends JFrame implements ActionListener
{
    JLabel lb1,lb2,lb3,lb4,lb5;
    JTextField txt,txtUC,txtLC,txtLU,txtnum;
    JButton btnOk,btnReset,btnExit;
    JPanel pn,pn1,pn2,pn3,pn4,pn5,pn6;
    public bai4_xuLiChuoiKiTu(String t) {
        super(t);
        GUI();
    }
    public void GUI() {
        lb1=new JLabel("Enter a String");
        lb2=new JLabel("To UpperCase");
        lb3=new JLabel("To LowerCase");
        lb4=new JLabel("To LowerUpper");
        lb5=new JLabel("Number of word");
        
        txt=new JTextField(7);
        txtUC=new JTextField(7);
        txtLC=new JTextField(7);
        txtLU=new JTextField(7);
        txtnum=new JTextField(7);
        
        txtUC.setEditable(false);
        txtLC.setEditable(false);
        txtLU.setEditable(false);
        
        btnOk=new JButton("OK");
        btnReset=new JButton("Reset");
        btnExit=new JButton("Exit");
        
        btnOk.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);
        
        pn=new JPanel(new GridLayout(6,1));
        pn1=new JPanel(new GridLayout(1,2));
        pn2=new JPanel(new GridLayout(1,2));
        pn3=new JPanel(new GridLayout(1,2));
        pn4=new JPanel(new GridLayout(1,2));
        pn5=new JPanel(new GridLayout(1,2));
        pn6=new JPanel(new GridLayout(1,3));
        
        pn1.add(lb1);
        pn1.add(txt);
        
        pn2.add(lb2);
        pn2.add(txtUC);
        
        pn3.add(lb3);
        pn3.add(txtLC);
        
        pn4.add(lb4);
        pn4.add(txtLU);
        
        pn5.add(lb5);
        pn5.add(txtnum);
        
        JPanel pn61,pn62,pn63;
        pn61=new JPanel(new FlowLayout());
        pn61.add(btnOk);
        pn62=new JPanel(new FlowLayout());
        pn62.add(btnReset);
        pn63=new JPanel(new FlowLayout());
        pn63.add(btnExit);
        
        pn6.add(pn61);
        pn6.add(pn62);
        pn6.add(pn63);
        
        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);
        pn.add(pn4);
        pn.add(pn5);
        pn.add(pn6);
        
        add(pn);
        setSize(400,250);
        
        show();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==btnOk) 
        {
            String str=txt.getText();
            txtLC.setText(str.toLowerCase());
            txtUC.setText(str.toUpperCase());
            String str1="";
            int num=1;
            boolean space = false;
            
            for (int i=0;i<str.length();i++) 
            {
                if(str.charAt(i)>='A' &&  str.charAt(i)<='Z')
                {
                    if (space==true)
                    {
                        num+=1;
                        space=false;
                    }
                    char a = str.charAt(i);
                    a+=32;
                    str1+=a;
                }
                else if (str.charAt(i)==' ')
                {
                    str1+=' ';
                    space=true;
                }
                else
                {
                    if (space==true)
                    {
                        num+=1;
                        space=false;
                    }
                    char a = str.charAt(i);
                    a-=32;
                    str1+=a; 
                }
            }
			txtLU.setText(str1);
			txtnum.setText(Integer.toString(num));
        }
        if(e.getSource()==btnReset) {
            txt.setText("");
            txtLC.setText("");
            txtUC.setText("");
            txtLU.setText("");
            txtnum.setText("");
        }
        if(e.getSource()==btnExit) System.exit(0);
    }
    public void windowClosing(WindowEvent we) {
        dispose();
        System.exit(0);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new bai4_xuLiChuoiKiTu("Xử lý chuỗi kí tự");
    }
    

}
