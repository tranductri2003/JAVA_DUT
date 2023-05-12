
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


public class bai4 extends JFrame implements ActionListener
{
    private static String DB_URL = "jdbc:mysql://localhost:3306/data";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    private static String SQL = "select * from table1";

    JLabel lblUrl, lblSql ;
    JTextField txtUrl, txtSql;
    JButton btnok, btnreset, btnexit;

    JTable tb;
    JPanel pn1, pn2, pn3, pn;
    String column[] = { "ID", "NAME", "ADDRESS", "TOTAL" };
    DefaultTableModel tableModel;

    public bai4(String st)
    {
        super(st);
        GUI();
    }
    public void GUI()
    {
        lblUrl = new JLabel("INPUT INFORMATION: ");
        lblSql = new JLabel("SQL QUERY: ");

        txtUrl = new JTextField(DB_URL);
        txtSql = new JTextField(SQL);

        btnok = new JButton("OK");
        btnreset = new JButton("RESET");
        btnexit = new JButton("EXIT");

        btnok.addActionListener(this);
        btnreset.addActionListener(this);
        btnexit.addActionListener(this);

        tableModel = new DefaultTableModel(column,5);
        tb = new JTable(tableModel);

        pn1 = new JPanel(new GridLayout(2,2));
        pn1.add(lblUrl);
        pn1.add(txtUrl);
        pn1.add(lblSql);
        pn1.add(txtSql);


        pn2 = new JPanel(new FlowLayout());
        //JScrollPane scrollPane  = new JScrollPane(tb);
        pn2.add(tb);
        pn2.add(new JScrollPane(tb));


        pn3 = new JPanel(new FlowLayout());
        pn3.add(btnok);
        pn3.add(btnreset);
        pn3.add(btnexit);



        pn = new JPanel(new FlowLayout());
        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);

        add(pn);

        setSize(600, 800);
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
            String query = txtSql.getText();

            try {
                tb.removeAll();
                Connection conn = getConnection(url,USER_NAME,PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery(query);
                DefaultTableModel tableModel = new DefaultTableModel(column,0);
                while (res.next())
                {
                    Vector vector = new Vector();
                    vector.add(res.getInt("id"));
                    vector.add(res.getString("name"));
                    vector.add(res.getString("address"));
                    vector.add(res.getInt("total"));
                    tableModel.addRow(vector);
                }
                tb.setModel(tableModel);
                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args)
    {
        new bai4("TRUY XUẤT DỮ LIỆU");
    }
}
