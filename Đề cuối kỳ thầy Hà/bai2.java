import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class student
{
    private String StudentID;
    private String StudentName;
    private String DateOfBirth;
    private String StudenGender;
    private String StudentScore;

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getStudenGender() {
        return StudenGender;
    }

    public void setStudenGender(String studenGender) {
        StudenGender = studenGender;
    }

    public String getStudentScore() {
        return StudentScore;
    }

    public void setStudentScore(String studentScore) {
        StudentScore = studentScore;
    }
}
public class bai2 {
    Connection con;
    Statement stmt;
    InputStream inputStream;
    OutputStream outputStream;
    BufferedInputStream bufferIn = null;
    BufferedOutputStream bufferOut = null;


    public bai2() {
        try {
            connectDatabase();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void connectDatabase() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/data";
        con = DriverManager.getConnection(url, "root", "");
        stmt = con.createStatement();


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


        ArrayList<student> listStudent = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            student temp = new student();
            temp.setStudentID(data.get(i).substring(0, 10).trim());
            temp.setStudentName(data.get(i).substring(10, 60).trim());
            temp.setDateOfBirth(data.get(i).substring(60, 70).trim());
            temp.setStudenGender(data.get(i).substring(70, 73).trim());
            if (i == data.size() - 1) {
                if (data.get(i).length() < 77) {
                    temp.setStudentScore(data.get(i).substring(73, 76).trim());
                } else {
                    temp.setStudentScore(data.get(i).substring(73, 77).trim());
                }
            } else {
                temp.setStudentScore(data.get(i).substring(73, 77).trim());
            }
            listStudent.add(temp);
        }

        for (int i=0;i<listStudent.size();i++){

            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            inputDateFormat.setLenient(false);
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = inputDateFormat.parse(listStudent.get(i).getDateOfBirth());
                String outputDate = outputDateFormat.format(date);
                listStudent.get(i).setDateOfBirth(outputDate);
                String sql = String.format("INSERT INTO `hocvien`(`MaHocVien`, `TenHocVien`, `NgaySinh`, `GioiTinh`, `DiemThi`) VALUES ('%s','%s','%s','%s','%s')",listStudent.get(i).getStudentID(),listStudent.get(i).getStudentName(),listStudent.get(i).getDateOfBirth(),listStudent.get(i).getStudenGender(),listStudent.get(i).getStudentScore());
                stmt.executeUpdate(sql);
            } catch (ParseException e) {
                String error = String.format("Dong %s: Sai dinh dang ngay sinh\n",i+1);
                bufferOut.write(error.getBytes());
            }
        }
        stmt.close();
        con.close();
        bufferIn.close();
        bufferOut.close();
    }
    public static void main (String[] args){
        bai2 solution = new bai2();
    }
}
