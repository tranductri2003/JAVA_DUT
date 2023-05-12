import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class WithDrawView extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JButton btn100, btn200, btn300, btn500, btn1000,btnBack;
    private Card card;
    public WithDrawView(String s,Card card1){
        super(s);
        card = card1;
        GUI();
    }

    public void GUI(){
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setSize(600,350);

        lblTitle = new JLabel("RÚT TIỀN");
        btn100 = new JButton("100.000");
        btn200 = new JButton("200.000");
        btn300 = new JButton("300.000");
        btn500 = new JButton("500.000");
        btn1000 = new JButton("1.000.000");
        btnBack = new JButton("BACK");

        lblTitle.setBounds(250,25,200,25);
        btn100.setBounds(0,100,200,25);
        btn500.setBounds(400,100,200,25);
        btn200.setBounds(0,175,200,25);
        btn1000.setBounds(400,175,200,25);
        btn300.setBounds(0,250,200,25);
        btnBack.setBounds(400,250,200,25);

        add(lblTitle);
        add(btn100);
        add(btn200);
        add(btn300);
        add(btn500);
        add(btn1000);
        add(btnBack);
        show();

        btn100.addActionListener(this);
        btn200.addActionListener(this);
        btn300.addActionListener(this);
        btn500.addActionListener(this);
        btn1000.addActionListener(this);
        btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnBack){
            try {
                MainView view = new MainView("DỊCH VỤ NGÂN HÀNG");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        }
        else if (e.getSource()==btn100){
            if (card.getAmount()>=100000){
                card.setAmount(card.getAmount()-100000);
                CardModel cardModel = new CardModel();
                try {
                    cardModel.UpdateInfo(card);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(this,"WITHDRAW SUCCESSFULLY!!!");
            }
            else{
                JOptionPane.showMessageDialog(this,"NOT ENOUGH MONEY!!!");
            }
        }
        else if (e.getSource()==btn200){
            if (card.getAmount()>=200000){
                card.setAmount(card.getAmount()-200000);
                CardModel cardModel = new CardModel();
                try {
                    cardModel.UpdateInfo(card);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(this,"WITHDRAW SUCCESSFULLY!!!");
            }
            else{
                JOptionPane.showMessageDialog(this,"NOT ENOUGH MONEY!!!");
            }
        }
        else if (e.getSource()==btn300){
            if (card.getAmount()>=300000){
                card.setAmount(card.getAmount()-300000);
                CardModel cardModel = new CardModel();
                try {
                    cardModel.UpdateInfo(card);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(this,"WITHDRAW SUCCESSFULLY!!!");
            }
            else{
                JOptionPane.showMessageDialog(this,"NOT ENOUGH MONEY!!!");
            }
        }
        else if (e.getSource()==btn500){
            if (card.getAmount()>=500000){
                card.setAmount(card.getAmount()-500000);
                CardModel cardModel = new CardModel();
                try {
                    cardModel.UpdateInfo(card);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(this,"WITHDRAW SUCCESSFULLY!!!");
            }
            else{
                JOptionPane.showMessageDialog(this,"NOT ENOUGH MONEY!!!");
            }
        }
        else if (e.getSource()==btn1000){
            if (card.getAmount()>=1000000){
                card.setAmount(card.getAmount()-1000000);
                CardModel cardModel = new CardModel();
                try {
                    cardModel.UpdateInfo(card);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(this,"WITHDRAW SUCCESSFULLY!!!");
            }
            else{
                JOptionPane.showMessageDialog(this,"NOT ENOUGH MONEY!!!");
            }
        }

    }



}
