import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static java.sql.DriverManager.getConnection;

public class bai6 extends  JFrame implements  ActionListener
{
    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        bai6.URL = URL;
    }

    private  static String URL ="jdbc:mysql://localhost:3306/data";

    public static String getUserName() {
        return USER_NAME;
    }

    public static void setUserName(String userName) {
        USER_NAME = userName;
    }

    private  static String USER_NAME ="root";

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        bai6.PASSWORD = PASSWORD;
    }

    private  static  String PASSWORD = "";


    JLabel lblInput, lblSearch;
    JTextField txtInput;
    JButton btnSearch, btnReset, btnExit;

    JRadioButton rbId, rbName, rbDate, rbAddress, rbGender;

    JTable tb;
    JPanel pn, pn1, pn2, pn3;
    String column[] = {"ID", "NAME", "DATE", "ADDRESS", "GENDER"};
    DefaultTableModel tableModel;

    public bai6(String st)
    {
        super(st);
        GUI();
    }

    public void GUI()
    {
        lblInput = new JLabel("INPUT INFORMATION");
        lblSearch = new JLabel("SEARCH AS: ");

        txtInput = new JTextField();
        txtInput.setColumns(10);

        btnSearch = new JButton("Search");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");
        btnSearch.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);


        rbId = new JRadioButton("ID");
        rbId.setBounds(100,50,100,30);
        rbName = new JRadioButton("NAME");
        rbName.setBounds(100,50,100,30);
        rbDate = new JRadioButton("DATE");
        rbDate.setBounds(100,50,100,30);
        rbAddress = new JRadioButton("ADDRESS");
        rbAddress.setBounds(100,50,100,30);
        rbGender = new JRadioButton("GENDER");
        rbGender.setBounds(100,50,100,30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbId);
        bg.add(rbName);
        bg.add(rbDate);
        bg.add(rbAddress);
        bg.add(rbGender);

        tableModel = new DefaultTableModel(column,30);
        tb = new JTable(tableModel);

        pn1 = new JPanel( new FlowLayout());
        pn1.add(lblInput);
        pn1.add(txtInput);
        pn1.add(btnSearch);
        pn1.add(btnReset);
        pn1.add(btnExit);

        pn2 = new JPanel(new FlowLayout());
        pn2.add(lblSearch);
        pn2.add(rbId);
        pn2.add(rbName);
        pn2.add(rbDate);
        pn2.add(rbAddress);
        pn2.add(rbGender);

        pn3 = new JPanel(new FlowLayout());
        pn3.add(tb);
        pn3.add( new JScrollPane(tb));

        pn = new JPanel(new FlowLayout());
        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);

        add(pn);
        setSize(600,800);
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
        else if (e.getSource()==btnSearch)
        {
            String term = txtInput.getText();
            try
            {
                tb.removeAll();
                Connection conn = getConnection(URL,USER_NAME,PASSWORD);
                Statement stmt = conn.createStatement();
                if (rbId.isSelected())
                {
                    String query = "SELECT * FROM student WHERE id=\"" +term+"\"";;
                    ResultSet res = stmt.executeQuery(query);
                    DefaultTableModel tableModel = new DefaultTableModel(column,0);
                    while (res.next()) {
                        Vector vector = new Vector();
                        vector.add(res.getInt("id"));
                        vector.add(res.getString("name"));
                        vector.add(res.getString("date"));
                        vector.add(res.getString("address"));
                        vector.add(res.getString("gender"));
                        tableModel.addRow(vector);
                    }
                    tb.setModel(tableModel);
                    conn.close();
                }
                else if (rbName.isSelected())
                {
                    String query = "SELECT * FROM student WHERE name=\"" +term+"\"";;
                    ResultSet res = stmt.executeQuery(query);
                    DefaultTableModel tableModel = new DefaultTableModel(column,0);
                    while (res.next()) {
                        Vector vector = new Vector();
                        vector.add(res.getInt("id"));
                        vector.add(res.getString("name"));
                        vector.add(res.getString("date"));
                        vector.add(res.getString("address"));
                        vector.add(res.getString("gender"));
                        tableModel.addRow(vector);
                    }
                    tb.setModel(tableModel);
                    conn.close();
                }
                else if (rbDate.isSelected())
                {
                    String query = "SELECT * FROM student WHERE date=\"" +term+"\"";;
                    ResultSet res = stmt.executeQuery(query);
                    DefaultTableModel tableModel = new DefaultTableModel(column,0);
                    while (res.next()) {
                        Vector vector = new Vector();
                        vector.add(res.getInt("id"));
                        vector.add(res.getString("name"));
                        vector.add(res.getString("date"));
                        vector.add(res.getString("address"));
                        vector.add(res.getString("gender"));
                        tableModel.addRow(vector);
                    }
                    tb.setModel(tableModel);
                    conn.close();
                }
                else if (rbAddress.isSelected())
                {
                    String query = "SELECT * FROM student WHERE address=\"" +term+"\"";
                    System.out.print(query);
                    ResultSet res = stmt.executeQuery(query);
                    DefaultTableModel tableModel = new DefaultTableModel(column,0);
                    while (res.next()) {
                        Vector vector = new Vector();
                        vector.add(res.getInt("id"));
                        vector.add(res.getString("name"));
                        vector.add(res.getString("date"));
                        vector.add(res.getString("address"));
                        vector.add(res.getString("gender"));
                        tableModel.addRow(vector);
                    }
                    tb.setModel(tableModel);
                    conn.close();
                }
                else if (rbGender.isSelected())
                {
                    String query = "SELECT * FROM student WHERE gender=\"" +term+"\"";;
                    ResultSet res = stmt.executeQuery(query);
                    DefaultTableModel tableModel = new DefaultTableModel(column,0);
                    while (res.next()) {
                        Vector vector = new Vector();
                        vector.add(res.getInt("id"));
                        vector.add(res.getString("name"));
                        vector.add(res.getString("date"));
                        vector.add(res.getString("address"));
                        vector.add(res.getString("gender"));
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
    public static  void main (String[] args)
    {
        new bai6("DATABASE PROGRAMMING");
    }
}