import java.sql.*;

public class begin {
    public static void main (String[] args)throws ClassNotFoundException, SQLClientInfoException {
        try{
            Class.forName("org.sqlite.JDBC");
            String db="D:\\astudy\\javaproject\\work-book.db";
            Connection conn= DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement state = conn.createStatement();
            ResultSet res= state.executeQuery("select * from swiss");
            res.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }//test the database connection
}