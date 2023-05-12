import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

class student{
    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    private String StudentID;
    private String Name;
    private String DateOfBirth;
    private int Gender;

}
public class bai2 extends JFrame implements ActionListener {

    Connection con;
    Statement stmt;
    InputStream inputStream;
    OutputStream outputStream;

    BufferedInputStream bufferIn = null;
    BufferedOutputStream bufferOut = null;

    private JLabel lblTitle, lblMssv, lblTen, lblNgaySinh, lblGioitinh;
    private JTextField txtMssv, txtTen, txtNgaySinh, txtGioiTinh;
    private JButton btnSearch;



    public bai2(String s) {
        super(s);
        try {
            connectDatabase();
            GUI();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void connectDatabase() throws ClassNotFoundException, SQLException, IOException, ParseException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/data";
        con = DriverManager.getConnection(url, "root", "");
        stmt = con.createStatement();

        inputStream = new FileInputStream("input.txt");
        outputStream  = new FileOutputStream("error.txt");
        bufferIn = new BufferedInputStream(inputStream);
        bufferOut = new BufferedOutputStream(outputStream);

        String s = "";
        int c;
        while ((c=bufferIn.read())!=-1) {
            s += (char) c;
        }

        ArrayList<String> data = new ArrayList<>();
        String line = "";
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)!='\n'){
                line += s.charAt(i);
            }else{
                data.add(line);
                line="";
            }
            if (i==s.length()-1){
                data.add(line);
                line="";
            }
        }
        ArrayList<student> listStudent = new ArrayList<>();
        for (int i=0;i < data.size();i++){
            String [] tempString = data.get(i).split(";");
            student tempStudent = new student();
            tempStudent.setStudentID(tempString[0]);
            tempStudent.setName(tempString[1]);
            tempStudent.setDateOfBirth(tempString[2]);
            tempStudent.setGender(Integer.parseInt(tempString[3].trim()));


            listStudent.add(tempStudent);
        }
        for (int i=0;i<listStudent.size();i++){

            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            inputDateFormat.setLenient(false);
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = inputDateFormat.parse(listStudent.get(i).getDateOfBirth());
                String outputDate = outputDateFormat.format(date);
                listStudent.get(i).setDateOfBirth(outputDate);

                String sql = String.format("INSERT INTO `dat`(`ID`, `Name`, `DateOfBirth`, `Gender`) VALUES ('%s','%s','%s',%d)",listStudent.get(i).getStudentID(),listStudent.get(i).getName(),listStudent.get(i).getDateOfBirth(),listStudent.get(i).getGender());

                stmt.executeUpdate(sql);
            } catch (ParseException e) {
                String error = String.format("Dong %s: Sai dinh dang ngay sinh\n",i+1);
                bufferOut.write(error.getBytes());
            }
        }

//        stmt.close();
//        con.close();
        bufferIn.close();
        bufferOut.close();
    }

    public void GUI(){
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setSize(600,350);

        lblTitle = new JLabel("THÔNG TIN SINH VIÊN");
        lblMssv = new JLabel("MÃ SỐ SINH VIÊN");
        lblTen = new JLabel("HỌ VÀ TÊN");
        lblNgaySinh = new JLabel("NGÀY SINH");
        lblGioitinh = new JLabel("GIỚI TÍNH");

        txtMssv = new JTextField(6);
        txtTen = new JTextField(6);
        txtNgaySinh = new JTextField(6);
        txtGioiTinh = new JTextField(6);
        txtTen.setEditable(false);
        txtNgaySinh.setEditable(false);
        txtGioiTinh.setEditable(false);

        btnSearch = new JButton("SEARCH");

        lblTitle.setBounds(250,25,200,25);
        lblMssv.setBounds(100,75,200,25);
        lblTen.setBounds(100,175,200,25);
        lblNgaySinh.setBounds(100,225,200,25);
        lblGioitinh.setBounds(100,275,200,25);
        btnSearch.setBounds(250,125,200,25);
        txtMssv.setBounds(300,75,200,25);
        txtTen.setBounds(300,175,200,25);
        txtNgaySinh.setBounds(300,225,200,25);
        txtGioiTinh.setBounds(300,275,200,25);
        add(lblTitle);
        add(lblTen);
        add(lblMssv);
        add(lblNgaySinh);
        add(lblGioitinh);
        add(btnSearch);
        add(txtMssv);
        add(txtTen);
        add(txtNgaySinh);
        add(txtGioiTinh);

        btnSearch.addActionListener(this);
        show();
    }
    public  static  void main(String [] args){
//        System.setProperty("file.encoding", "UTF-8");
        bai2 bai2 = new bai2("QUAN LY SINH VIEN");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnSearch){
            try {
                String sql = String.format("SELECT * FROM `dat` WHERE ID = '%s' LIMIT 1", txtMssv.getText());
                ResultSet res = stmt.executeQuery(sql);
                if (res.last()){
                    res = stmt.executeQuery(sql);
                    while (res.next()){
                        txtTen.setText(res.getString("Name"));
                        txtGioiTinh.setText(res.getString("Gender"));
                        txtNgaySinh.setText(res.getString("DateOfBirth"));
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "KHÔNG TỒN TẠI SINH VIÊN CÓ MÃ SỐ NHƯ TRÊN");
                }

            }
            catch (Exception q){
                System.out.println(q);
                JOptionPane.showMessageDialog(this,"THÔNG TIN KHÔNG HỢP LỆ!");
            }
        }
    }
}
