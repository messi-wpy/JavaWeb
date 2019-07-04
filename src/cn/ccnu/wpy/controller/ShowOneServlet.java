package cn.ccnu.wpy.controller;

import cn.ccnu.wpy.pojo.Receiver;
import cn.ccnu.wpy.util.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(value = "/showOne",name = "ShowOneServlet")
public class ShowOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        Receiver u=new Receiver();
        try {
            conn=DBHelper.getConnection();
            ps=conn.prepareStatement("select * from tb_Receivers where ID =?");

            ps.setInt(1,id);
            rs=ps.executeQuery();
            rs.next();
            u.setId(rs.getInt("ID"));
            u.setName(rs.getString("Name"));
        }catch (Exception e ){
            e.printStackTrace();

        }finally {
            DBHelper.closeConn(rs,ps,conn);
        }
        request.setAttribute("u",u);
        request.getRequestDispatcher("Update.jsp").forward(request,response);

    }
}
