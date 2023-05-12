import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class TransferView extends JFrame implements ActionListener {
    private JLabel lblTitle, lblTarget, lblAmount;
    private JTextField txtTarget, txtAmount;
    private JButton btnBack, btnOk;
    private  Card card;

    public TransferView(String s, Card card1){
        super(s);
        card = card1;
        GUI();
    }

    public void GUI(){
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setSize(600,400);

        lblTitle = new JLabel("CHUYỂN KHOẢN");
        lblTarget = new JLabel("Số thẻ chuyển tới");
        txtTarget = new JTextField(6);
        lblAmount = new JLabel("Số tiền");
        txtAmount = new JTextField(6);
        btnBack = new JButton("BACK");
        btnOk = new JButton("OK");


        lblTitle.setBounds(250,25,200,25);
        lblTarget.setBounds(100,100,200,25);
        txtTarget.setBounds(350,100,200,25);
        lblAmount.setBounds(100,175,200,25);
        txtAmount.setBounds(350,175,200,25);
        btnBack.setBounds(100,325,200,25);
        btnOk.setBounds(350,325,200,25);

        btnBack.addActionListener(this);
        btnOk.addActionListener(this);

        add(lblTitle);
        add(lblTarget);
        add(txtTarget);
        add(lblAmount);
        add(txtAmount);
        add(btnBack);
        add(btnOk);
        show();

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
        } else if (e.getSource()==btnOk) {
            CardModel cardModel = new CardModel();
            Card target = null;
            try {
                target = cardModel.getCard(txtTarget.getText());
                if (target!=null){
                    if (card.getAmount()>=Float.parseFloat(txtAmount.getText())){
                        card.setAmount(card.getAmount()-Float.parseFloat(txtAmount.getText()));
                        target.setAmount(target.getAmount()+Float.parseFloat(txtAmount.getText()));
                        cardModel.UpdateInfo(card);
                        cardModel.UpdateInfo(target);
                        JOptionPane.showMessageDialog(this,"TRANSFER SUCCESSFULLY!!!");
                    }else{
                        JOptionPane.showMessageDialog(this,"NOT ENOUGH MONEY!!!");
                    }
                }else{
                    JOptionPane.showMessageDialog(this,"INVALID RECEIVER!!!");
                }
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }

    }

}
