package Java_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public class operation_in_db {
    public static void main (String[] args)throws ClassNotFoundException, SQLClientInfoException {

    }
    public static void insertCafafa(String proteins,String sequence){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement st=con.createStatement();
            st.execute("insert into cafafa values ('"+proteins+"','"+sequence+"')");
            st.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }//1
        public static void insertswisstsv(int x1,String x2, String x3,String x4, String x5,String x6,String x7 ){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement st=con.createStatement();
            st.execute("insert into swisstsv values ('"+x1+"','"+x2+"','"+x3+"','"+x4+"','"+x5+"','"+x6+"','"+x7+"')");
            st.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }//2
    public static void insertswissfa(String proteins, String sequence){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement st=con.createStatement();
            st.execute("insert into swissfa values ('"+proteins+"','"+sequence+"')");
            st.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }//3
    public static void insertcafatsv(int x1,String x2, String x3,String x4 ){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement st=con.createStatement();
            st.execute("insert into cafatsv values ('"+x1+"','"+x2+"','"+x3+"','"+x4+"')");
            st.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }//2
}