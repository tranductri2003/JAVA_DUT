import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class AmountView extends JFrame implements ActionListener {
    private JLabel lblTitle, lblName, lblCardNumber, lblAmount;
    private JTextField txtName, txtCardNumber, txtAmount;
    private JButton btnBack, btnOk;

    private Card card;
    public AmountView(String s, Card card1){
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
        lblName = new JLabel("Số thẻ chuyển tới");
        txtName = new JTextField(6);
        lblCardNumber = new JLabel("Số tiền");
        txtCardNumber = new JTextField(6);
        lblAmount = new JLabel("Số dư");
        txtAmount = new JTextField(6);
        btnBack = new JButton("BACK");
        btnOk = new JButton("OK");


        lblTitle.setBounds(250,25,200,25);
        lblName.setBounds(100,100,200,25);
        txtName.setBounds(350,100,200,25);
        lblCardNumber.setBounds(100,175,200,25);
        txtCardNumber.setBounds(350,175,200,25);
        lblAmount.setBounds(100,250,200,25);
        txtAmount.setBounds(350,250,200,25);
        btnBack.setBounds(100,325,200,25);
        btnOk.setBounds(350,325,200,25);

        txtCardNumber.setText(card.getCardId());
        txtCardNumber.setEditable(false);
        txtAmount.setText(String.valueOf(card.getAmount()));
        txtAmount.setEditable(false);
        txtName.setText(card.getName());
        txtName.setEditable(false);


        btnBack.addActionListener(this);
        btnOk.addActionListener(this);


        add(lblTitle);
        add(lblName);
        add(txtName);
        add(lblCardNumber);
        add(txtCardNumber);
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
        }
    }

}
