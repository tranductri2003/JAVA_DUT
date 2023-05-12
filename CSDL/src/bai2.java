
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class bai2
{
    public static void main(String[] args)
    {
        System.out.println("KET NOI CSDL");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/data";
            Connection con = DriverManager.getConnection(url,"root","");
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM table1";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("ID         Name                    Address       Total");
            while (rs.next())
            {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String address=rs.getString("address");
                int total=rs.getInt("total");
                System.out.printf("%s          %s     %15s        %d",id,name,address,total);
                System.out.println("\n");
            }
            rs.close();
            stmt.close();
        }
        catch (Exception e)
        {
            System.out.println("Error: "+e);
        }
    }

}
