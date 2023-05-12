import javax.swing.*;
import java.sql.*;

public class CardModel {
    public Card getCard(String CardId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/data";
        Connection con = DriverManager.getConnection(url, "root", "");
        Statement stmt = con.createStatement();
        String query = String.format("SELECT * FROM `taikhoan` WHERE ID_CARD='%s'",CardId);
        try
        {
            ResultSet res =stmt.executeQuery(query);
            if (res.next()){
                Card card = new Card();
                card.setCardId(res.getString("ID_CARD"));
                card.setName(res.getString("NAME"));
                card.setAmount(res.getFloat("AMOUNT"));
                con.close();
                return card;
            }
            else
            {
                con.close();
                return null;
            }
        }catch (Exception e){
            con.close();
            return null;
        }
    }
    public void UpdateInfo(Card card) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://127.0.0.1:3306/data";
        Connection con= DriverManager.getConnection(url,"root","");
        Statement stmt =con.createStatement();
        String query = String.format("UPDATE `taikhoan` SET `ID_CARD`='%s',`NAME`='%s',`AMOUNT`='%s' WHERE `ID_CARD`='%s'",card.getCardId(),card.getName(),card.getAmount(),card.getCardId());
        stmt.executeUpdate(query);
        stmt.close();
    }
}
