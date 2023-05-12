import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.*;
import java.util.Queue;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static java.sql.DriverManager.getConnection;


public class bai3 extends JFrame implements  ActionListener
{
    private static String DB_URL = "jdbc:mysql://localhost:3306/data";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    private static String SQL = "select * from table1";
    JLabel lblHead, lblId, lblName, lblAddress, lblTotal;
    JButton btnOk, btnReset, btnExit;
    JTable tb;
    String[] column = { "ID", "NAME", "ADDRESS", "TOTAL" };
    DefaultTableModel tableModel;
    JPanel pn, pn1, pn2, pn3;

    public bai3 (String t)
    {
        super(t);
        GUI();
    }
    public void GUI()
    {
        lblHead = new JLabel("DATABASE PROGRAMMING");
        lblId = new JLabel("ID");
        lblName = new JLabel("NAME");
        lblAddress = new JLabel("ADDRESS");
        lblTotal = new JLabel("TOTAL");

        btnOk = new JButton("OK");
        btnExit = new JButton("EXIT");
        btnReset = new JButton("RESET");
        btnOk.addActionListener(this);
        btnExit.addActionListener(this);
        btnReset.addActionListener(this);

        tableModel = new DefaultTableModel(column,5);
        tb = new JTable(tableModel);

        pn1 = new JPanel(new FlowLayout());
        pn1.add(lblHead);
        pn2 = new JPanel(new FlowLayout());
        pn2.add(btnOk);
        pn2.add(btnReset);
        pn2.add(btnExit);
        pn3 = new JPanel(new FlowLayout());
        pn3.add(tb);
        pn3.add(new JScrollPane(tb));
        pn = new JPanel(new GridLayout(3,1));
        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);
        add(pn);
        setSize(500,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnExit)
        {
            System.exit(0);
        }
        else if (e.getSource()==btnReset)
        {
            tb.removeAll();
            tb.setModel(tableModel);
        }
        else
        {
            try
            {
                tb.removeAll();
                Connection conn = getConnection(DB_URL,USER_NAME,PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery(SQL);
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

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public static void main(String[] args)
    {
        new bai3("DATABASE PROGRAMMING");
    }
}