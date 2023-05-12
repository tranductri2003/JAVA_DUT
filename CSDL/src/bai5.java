
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static java.sql.DriverManager.getConnection;


public class bai5 extends JFrame implements ActionListener
{
    private static String DB_URL = "jdbc:mysql://localhost:3306/data";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    private static String SQL = "select * from table1";

    public static String getDbUrl() {
        return DB_URL;
    }
    public static void setDbUrl(String dbUrl) {
        DB_URL = dbUrl;
    }


    public static String getPASSWORD() {
        return PASSWORD;
    }
    public static void setUserName(String userName) {
        USER_NAME = userName;
    }

    public static String getUserName() {
        return USER_NAME;
    }
    JLabel lblHead, lblUrl, lblAccount, lblPass, lblSql ;
    JTextField txtUrl, txtAccount, txtPass, txtSql;
    JButton btnok, btnreset, btnexit;

    JRadioButton rbSelect, rbInsert, rbDelete, rbUpdate;
    JTable tb;
    JPanel pn1, pn2, pn3, pn4, pnRadio,  pn;
    String column[] = { "ID", "NAME", "ADDRESS", "TOTAL" };
    DefaultTableModel tableModel;

    public bai5(String st)
    {
        super(st);
        GUI();
    }
    public void GUI()
    {
        lblHead = new JLabel("TRUY XUẤT CƠ SỞ DỮ LIỆU");
        lblUrl = new JLabel("INPUT INFORMATION: ");
        lblAccount = new JLabel("USER NAME: ");
        lblPass = new JLabel("PASSWORD: ");
        lblSql = new JLabel("SQL QUERY: ");

        txtUrl = new JTextField(DB_URL);
        txtAccount= new JTextField(USER_NAME);
        txtPass = new JTextField(PASSWORD);
        txtSql = new JTextField(SQL);

        btnok = new JButton("OK");
        btnreset = new JButton("RESET");
        btnexit = new JButton("EXIT");

        btnok.addActionListener(this);
        btnreset.addActionListener(this);
        btnexit.addActionListener(this);

        rbSelect = new JRadioButton("Select");
        rbSelect.setBounds(100, 50, 100, 30);
        rbInsert = new JRadioButton("Insert");
        rbInsert.setBounds(100, 50, 100, 30);
        rbDelete = new JRadioButton("Delete");
        rbDelete.setBounds(100, 50, 100, 30);
        rbUpdate = new JRadioButton("Update");
        rbUpdate.setBounds(100, 50, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbSelect);
        bg.add(rbInsert);
        bg.add(rbDelete);
        bg.add(rbUpdate);



        tableModel = new DefaultTableModel(column,5);
        tb = new JTable(tableModel);



        pn1 = new JPanel( new GridLayout(1,3));
        pn1.add(new Label(""));
        pn1.add(lblHead);
        pn1.add(new Label(""));

        pn2 = new JPanel(new GridLayout(4,2));
        pn2.add(lblUrl);
        pn2.add(txtUrl);
        pn2.add(lblAccount);
        pn2.add(txtAccount);
        pn2.add(lblPass);
        pn2.add(txtPass);
        pn2.add(lblSql);
        pn2.add(txtSql);

        pnRadio = new JPanel (new FlowLayout());
        pnRadio.add(rbSelect);
        pnRadio.add(rbInsert);
        pnRadio.add(rbDelete);
        pnRadio.add(rbUpdate);



        pn3 = new JPanel(new FlowLayout());
        //JScrollPane scrollPane  = new JScrollPane(tb);
        pn3.add(tb);
        pn3.add(new JScrollPane(tb));


        pn4 = new JPanel(new FlowLayout());
        pn4.add(btnok);
        pn4.add(btnreset);
        pn4.add(btnexit);



        pn = new JPanel(new GridLayout(5,4));
        pn.add(pn1);
        pn.add(pn2);
        pn.add(pnRadio);
        pn.add(pn3);
        pn.add(pn4);

        add(pn);

        setSize(900, 800);
        setVisible(true);


    }


    public void actionPerformed(ActionEvent e)
    {


        if (e.getSource()==btnexit)
        {
            System.exit(0);
        }
        else if (e.getSource()==btnreset)
        {
            tb.removeAll();
            tb.setModel(tableModel);
        }
        else if (e.getSource()==btnok)
        {
            String url = txtUrl.getText();
            String userName = txtAccount.getText();
            String passWord = txtPass.getText();
            String query = txtSql.getText();

            try {
                tb.removeAll();
                // connnect to database 'testdb'
                Connection conn = getConnection(url, userName, passWord);
                // crate statement
                Statement stmt = conn.createStatement();
                // get data from table 'student'
                if (rbSelect.isSelected()) {
                    ResultSet res = stmt.executeQuery(query);
                    DefaultTableModel tableModel = new DefaultTableModel(column,0);
                    while (res.next()) {
                        Vector vector = new Vector();
                        vector.add(res.getInt("id"));
                        vector.add(res.getString("name"));
                        vector.add(res.getString("address"));
                        vector.add(res.getInt("total"));
                        tableModel.addRow(vector);
                    }
                    tb.setModel(tableModel);
                    conn.close();
                }
                else
                {
                    // connnect to database 'testdb'
                    stmt.executeUpdate(query);
                    conn = getConnection(url, userName, passWord);
                    // crate statement
                    stmt = conn.createStatement();
                    ResultSet res = stmt.executeQuery(SQL);
                    DefaultTableModel tableModel = new DefaultTableModel(column,0);
                    while (res.next()) {
                        Vector vector = new Vector();
                        vector.add(res.getInt("id"));
                        vector.add(res.getString("name"));
                        vector.add(res.getString("address"));
                        vector.add(res.getInt("total"));
                        tableModel.addRow(vector);
                    }
                    tb.setModel(tableModel);
                    conn.close();
                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args)
    {
        new bai5("TRUY XUẤT DỮ LIỆU");
    }
}
