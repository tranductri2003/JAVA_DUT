import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.*;

class ICPC_Result
{


    private int Rank;
    private String teamName;
    private String universityName;
    private int totalProblem;
    private int totalTime;

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getTotalProblem() {
        return totalProblem;
    }

    public void setTotalProblem(int totalProblem) {
        this.totalProblem = totalProblem;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
}
class ICPC
{
    private String teamName;
    private String universityName;
    private String ProblemID;
    private int Time;
    private String Result;

    ICPC() {
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getProblemID() {
        return ProblemID;
    }

    public void setProblemID(String problemID) {
        ProblemID = problemID;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }
}
public class bai1 extends JFrame implements ActionListener
{
    private JLabel lblData, lblKeyword;
    private JTextField txtData, txtKeyword;
    private  JButton btnImport, btnRanking, btnSearch, btnWinner;
    private JTextArea txtArea;


    Connection con;
    Statement stmt;

    InputStream inputStream;
    BufferedInputStream bufferIn = null;


    public bai1(String s) throws SQLException, ClassNotFoundException {
        super(s);
        GUI();
//        connectDataBase();
    }
    public void GUI()
    {
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setSize(500,400);

        lblData = new JLabel("Import data");
        lblKeyword = new JLabel("Keyword");

        txtData = new JTextField(6);
        txtKeyword = new JTextField(6);
        txtArea = new JTextArea(10,1);
//        JScrollPane scrollPane = new JScrollPane(txtArea);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);



        btnImport = new JButton("Import file");
        btnImport.setForeground(Color.RED);
        btnRanking = new JButton("Ranking");
        btnRanking.setForeground(Color.RED);
        btnSearch = new JButton("Seach");
        btnSearch.setForeground(Color.RED);
        btnWinner = new JButton("Won teams");
        btnWinner.setForeground(Color.RED);

        lblData.setBounds(20,50,100,30);
        txtData.setBounds(150,50,200,30);
        btnImport.setBounds(375,50,100,30);
        lblKeyword.setBounds(20,120,100,30);
        txtKeyword.setBounds(150,120,325,30);
        btnRanking.setBounds(20,190,100,30);
        btnSearch.setBounds(200,190,100,30);
        btnWinner.setBounds(375,190,100,30);
        txtArea.setBounds(20,250,455,100);

        btnImport.addActionListener(this);
        btnRanking.addActionListener(this);
        btnSearch.addActionListener(this);
        btnWinner.addActionListener(this);

        add(lblData);
        add(lblKeyword);
        add(txtData);
        add(txtKeyword);
        add(txtArea);
        add(btnImport);
        add(btnRanking);
        add(btnSearch);
        add(btnWinner);
//        add(scrollPane);
        show();
    }





    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnImport)
        {

            try {
                connectDataBase();
                importFile();
            } catch (IOException | SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource()==btnRanking)
        {
            try {
                connectDataBase();
                showRanking();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource()==btnSearch)
        {
            try {
                connectDataBase();
                showRankSchool(txtKeyword.getText());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource()==btnWinner)
        {
            try {
                connectDataBase();
                showWinner();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

    public  void connectDataBase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://127.0.0.1:3306/data";
        con= getConnection(url,"root","");
        stmt =con.createStatement();
    }

    public void importFile() throws IOException, SQLException {
        String inputFile=txtData.getText();
        inputStream=new FileInputStream(inputFile);
        bufferIn = new BufferedInputStream(inputStream);
        String s="";
        int c;
        while((c=bufferIn.read())!=-1){
            s+=(char)c;
        }
        ArrayList<String> data=new ArrayList<>();
        String dong="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='\n'){
                dong+=s.charAt(i);
            }
            else{
                data.add(dong);
                dong="";
            }
            if(i==s.length()-1){
                data.add(dong);
                dong="";
            }
        }
        ArrayList<ICPC> listICPC=new ArrayList<>();
        for(int i=0;i<data.size();i++){
            String[] array=data.get(i).split(",");
            ICPC icpc=new ICPC();
            icpc.setTeamName(array[0]);
            icpc.setUniversityName(array[1]);
            icpc.setProblemID(array[2]);
            icpc.setTime(Integer.parseInt(array[3]));
            icpc.setResult(array[4]);
            listICPC.add(icpc);
        }

        for(int i=0;i<listICPC.size();i++){
            String sql=String.format("INSERT INTO icpc (TeamName, UniversityName, ProblemID, Time, Result) VALUES ('%s', '%s', '%s', '%d', '%s')"
                    ,listICPC.get(i).getTeamName(),listICPC.get(i).getUniversityName(),listICPC.get(i).getProblemID(),listICPC.get(i).getTime(),listICPC.get(i).getResult());
            stmt.executeUpdate(sql);
        }
        stmt.close();
        con.close();
    }

    public void showRanking() throws SQLException {
        txtArea.setText("");
        String sql=String.format("SELECT TeamName, UniversityName, Count(ProblemID) AS TotalProblem, SUM(Time) AS TotalTime FROM icpc WHERE Result='%s' GROUP BY TeamName, UniversityName ORDER BY TotalProblem DESC, TotalTime ASC","AC");
        ResultSet res = stmt.executeQuery(sql);


        ArrayList<ICPC_Result> listICPC_Result=new ArrayList<>();

        int currentTotalScore=-1;
        int currentRank=1;
        while (res.next())
        {
            ICPC_Result icpc = new ICPC_Result();
            icpc.setTeamName(res.getString("TeamName"));
            icpc.setUniversityName(res.getString("UniversityName"));
            icpc.setTotalProblem(res.getInt("TotalProblem"));
            icpc.setTotalTime(res.getInt("TotalTime"));
            int currentScore = icpc.getTotalProblem()*1000-icpc.getTotalTime();
            if (currentScore<currentTotalScore)
            {
                currentRank+=1;
            }
            currentTotalScore=currentScore;
            icpc.setRank(currentRank);

            listICPC_Result.add(icpc);
        }

        for (ICPC_Result line:listICPC_Result)
        {
            txtArea.append(line.getRank()+" ,"+line.getTeamName()+" ,"+line.getUniversityName()+" ,"+line.getTotalProblem()+" ,"+line.getTotalTime()+'\n');
        }
        stmt.close();
        con.close();
    }


    public void showRankSchool(String name) throws SQLException {
        txtArea.setText("");
        String sql=String.format("SELECT TeamName, UniversityName, Count(ProblemID) AS TotalProblem, SUM(Time) AS TotalTime FROM icpc WHERE Result='%s' GROUP BY TeamName, UniversityName ORDER BY TotalProblem DESC, TotalTime ASC","AC");
        ResultSet res = stmt.executeQuery(sql);


        ArrayList<ICPC_Result> listICPC_Result=new ArrayList<>();

        int currentTotalScore=-1;
        int currentRank=1;
        while (res.next())
        {
            ICPC_Result icpc = new ICPC_Result();
            icpc.setTeamName(res.getString("TeamName"));
            icpc.setUniversityName(res.getString("UniversityName"));
            icpc.setTotalProblem(res.getInt("TotalProblem"));
            icpc.setTotalTime(res.getInt("TotalTime"));
            int currentScore = icpc.getTotalProblem()*1000-icpc.getTotalTime();
            if (currentScore<currentTotalScore)
            {
                currentRank+=1;
            }
            currentTotalScore=currentScore;
            icpc.setRank(currentRank);

            listICPC_Result.add(icpc);
        }

        for (ICPC_Result line:listICPC_Result)
        {
            if (line.getUniversityName().compareTo(name)==0) {
                txtArea.append(line.getRank() + " ," + line.getTeamName() + " ," + line.getUniversityName() + " ," + line.getTotalProblem() + " ," + line.getTotalTime() + '\n');
            }
        }
        stmt.close();
        con.close();
    }

    public void showWinner() throws SQLException, IOException {
        txtArea.setText("");
        String sql=String.format("SELECT TeamName, UniversityName, Count(ProblemID) AS TotalProblem, SUM(Time) AS TotalTime FROM icpc WHERE Result='%s' GROUP BY TeamName, UniversityName ORDER BY TotalProblem DESC, TotalTime ASC","AC");
        ResultSet res = stmt.executeQuery(sql);


        ArrayList<ICPC_Result> listICPC_Result=new ArrayList<>();

        int currentTotalScore=-1;
        int currentRank=1;
        while (res.next())
        {
            ICPC_Result icpc = new ICPC_Result();
            icpc.setTeamName(res.getString("TeamName"));
            icpc.setUniversityName(res.getString("UniversityName"));
            icpc.setTotalProblem(res.getInt("TotalProblem"));
            icpc.setTotalTime(res.getInt("TotalTime"));
            int currentScore = icpc.getTotalProblem()*1000-icpc.getTotalTime();
            if (currentScore<currentTotalScore)
            {
                currentRank+=1;
            }
            currentTotalScore=currentScore;
            icpc.setRank(currentRank);

            listICPC_Result.add(icpc);
        }

        ArrayList<String> list_Schoolname=new ArrayList<>();
        for (ICPC_Result line:listICPC_Result)
        {
            if (list_Schoolname.contains(line.getUniversityName())==false)
            {
                list_Schoolname.add(line.getUniversityName());
                txtArea.append(line.getRank()+" ,"+line.getTeamName()+" ,"+line.getUniversityName()+" ,"+line.getTotalProblem()+" ,"+line.getTotalTime()+'\n');
            }
        }
        stmt.close();
        con.close();
    }


    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        bai1 bai1 = new bai1("Quan ly ket qua ICPC");
    }
}
