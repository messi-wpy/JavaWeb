package cn.ccnu.wpy.controller;

import cn.ccnu.wpy.pojo.Receiver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/showReceiverAll",name = "ShowReceiverAllServlet")
public class ShowReceiverAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Receiver>list;
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        list = new ArrayList<>();
        conn = null;
        ps = null;
        rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://106.14.199.222:3306/DongGou";
            conn= DriverManager.getConnection(url,"root","Muxistudio304");
            ps=conn.prepareStatement("select * from tb_Receivers");
            rs = ps.executeQuery();

            while (rs.next()){
                Receiver receiver=new Receiver(rs.getInt("ID"),rs.getString("Name"),rs.getString("Province"),
                        rs.getString("City"),rs.getString("Country"),rs.getString("Address"),rs.getString("Phone"),
                        rs.getString("Postcode"),rs.getString("Street"),rs.getInt("UserID"));
                list.add(receiver);


            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try
            {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        request.setAttribute("list",list);
        request.getRequestDispatcher("delete.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
