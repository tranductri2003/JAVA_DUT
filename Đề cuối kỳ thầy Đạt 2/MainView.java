import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

public class MainView extends JFrame implements ActionListener {
    String url;
    Connection con;
    Statement stmt;
    InputStream inputStream;
    OutputStream outputStream;
    BufferedInputStream bufferIn = null;
    BufferedOutputStream bufferOut = null;
    private JLabel lblTitle, lblCardNumber;
    private JTextField txtCardNumber;
    private JButton btnWithdraw, btnTransfer, btnDeposit, btnAmount;

    public MainView(String s) throws SQLException, IOException, ParseException, ClassNotFoundException {
        super(s);

        try {
            connectDatabase();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        GUI();
//        CLOSE();
    }
    public void OPEN() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        url = "jdbc:mysql://127.0.0.1:3306/data";
        con = DriverManager.getConnection(url, "root", "");
        stmt = con.createStatement();
    }

    public void CLOSE() throws SQLException {
        stmt.close();
        con.close();
    }
    public void connectDatabase() throws ClassNotFoundException, SQLException, IOException, ParseException {
        OPEN();

        inputStream = new FileInputStream("input.txt");
        outputStream = new FileOutputStream("error.txt");
        bufferIn = new BufferedInputStream(inputStream);
        bufferOut = new BufferedOutputStream(outputStream);

        String s = "";
        int c;
        while ((c = bufferIn.read()) != -1) {
            s += (char) c;
        }

        ArrayList<String> data = new ArrayList<>();
        String line = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '\n') {
                line += s.charAt(i);
            } else {
                data.add(line);
                line = "";
            }
            if (i == s.length() - 1) {
                data.add(line);
                line = "";
            }
        }
        for (int i = 0; i < data.size(); i++) {
            try {
                String[] tempString = data.get(i).split(";");
                Card tempCard = new Card();
                tempCard.setCardId(tempString[0]);
                tempCard.setName(tempString[1]);
                tempCard.setAmount(Float.parseFloat(tempString[2]));

                String sql = String.format("INSERT INTO `taikhoan`(`ID_CARD`, `NAME`, `AMOUNT`) VALUES ('%s','%s',%s)",tempCard.getCardId(),tempCard.getName(),tempCard.getAmount());
                try{
                    stmt.executeUpdate(sql);
                }catch (Exception e){

                }

            }catch (Exception e){
                String error = String.format("Dong %s: Sai dinh dang thong tin\n",i+1);
                bufferOut.write(error.getBytes());
            }
        }
        bufferIn.close();
        bufferOut.close();
        CLOSE();
    }

    public void GUI() throws SQLException, ClassNotFoundException {
        OPEN();
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setSize(600,350);

        lblTitle = new JLabel("DỊCH VỤ NGÂN HÀNG");
        lblCardNumber = new JLabel("SỐ THẺ");
        txtCardNumber = new JTextField(6);
        btnWithdraw = new JButton("RÚT TIỀN");
        btnTransfer = new JButton("CHUYỂN KHOẢN");
        btnDeposit = new JButton("NẠP TIỀN");
        btnAmount = new JButton("XEM SỐ DƯ");

        lblTitle.setBounds(250,25,200,25);
        lblCardNumber.setBounds(100,100,200,25);
        txtCardNumber.setBounds(350,100,200,25);
        btnWithdraw.setBounds(100,175,200,25);
        btnTransfer.setBounds(350,175,200,25);
        btnDeposit.setBounds(100,250,200,25);
        btnAmount.setBounds(350,250,200,25);

        add(lblTitle);
        add(lblCardNumber);
        add(txtCardNumber);
        add(btnWithdraw);
        add(btnTransfer);
        add(btnDeposit);
        add(btnAmount);
        show();

        btnAmount.addActionListener(this);
        btnDeposit.addActionListener(this);
        btnTransfer.addActionListener(this);
        btnWithdraw.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnWithdraw){
            CardModel cardModel = new CardModel();
            Card card = null;
            try {
                card=cardModel.getCard(txtCardNumber.getText());
                if (card!=null){
                    JOptionPane.showMessageDialog(this,"SIGN IN SUCESSFULLY!");
                    WithDrawView view = new WithDrawView("RÚT TIỀN",card);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Invalid Card Number");
                    MainView bai = new MainView("DỊCH VỤ NGÂN HÀNG");
                }
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }

            dispose();
        }
        else if (e.getSource()==btnDeposit){
            CardModel cardModel = new CardModel();
            Card card = null;
            try {
                card = cardModel.getCard(txtCardNumber.getText());
                if (card!=null){
                    JOptionPane.showMessageDialog(this,"SIGN IN SUCESSFULLY!");
                    DepositView view = new DepositView("NẠP TIỀN",card);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Invalid Card Number");
                    MainView bai = new MainView("DỊCH VỤ NGÂN HÀNG");
                }
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }

            dispose();
        }
        else if (e.getSource()==btnTransfer){
            CardModel cardModel = new CardModel();
            Card card = null;
            try {
                card =cardModel.getCard(txtCardNumber.getText());
                if (card!=null){
                    JOptionPane.showMessageDialog(this,"SIGN IN SUCESSFULLY!");
                    TransferView view = new TransferView("CHUYỂN KHOẢN",card);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Invalid Card Number");
                    MainView bai = new MainView("DỊCH VỤ NGÂN HÀNG");
                }
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }

            dispose();
        }
        else if (e.getSource()==btnAmount){
            CardModel cardModel = new CardModel();
            Card card = null;
            try {
                card = cardModel.getCard(txtCardNumber.getText());
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                if (card!=null){
                    JOptionPane.showMessageDialog(this,"SIGN IN SUCESSFULLY!");
                    AmountView view = new AmountView("XEM SỐ DƯ",card);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Invalid Card Number");
                    MainView bai = new MainView("DỊCH VỤ NGÂN HÀNG");
                }
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }

            dispose();
        }
        try {
            CLOSE();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void main (String[] args) throws SQLException, IOException, ParseException, ClassNotFoundException {
        MainView bai = new MainView("DỊCH VỤ NGÂN HÀNG");
    }
}
