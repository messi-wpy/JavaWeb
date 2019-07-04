package cn.ccnu.wpy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper {

    public static final String DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String URL="jdbc:mysql://106.14.199.222:3306/DongGou";
    public static final String USER="root";
    public static final String PASSWORD="Muxistudio304";


    public static Connection getConnection() throws  Exception{
        Class.forName(DRIVER);
        Connection conn= DriverManager.getConnection(URL,USER,PASSWORD);
        return  conn;
    }

    public static void closeConn(ResultSet rs, PreparedStatement ps, Connection conn) {
       try {
           if (rs != null) {
               rs.close();
           }

           if (ps != null) {
               ps.close();
           }
           if (conn != null) {
               conn.close();
           }
       }catch (Exception e){
           e.printStackTrace();
       }

    }
}
