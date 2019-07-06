package cn.ccnu.wpy.controller;

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

@WebServlet(value = "/login",name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("username");
        String password=request.getParameter("password");

        request.setCharacterEncoding("utf-8");
        Connection conn=null;
        PreparedStatement ps=null;
        int row=0;
        ResultSet rs=null;


        try{
            conn= DBHelper.getConnection();
            ps=conn.prepareStatement("select PasswordHash from tb_users where Name=?");
            ps.setString(1,userName);
            rs=ps.executeQuery();

            if (rs.next()){
                if (rs.getString("PasswordHash").equals(password))
                    response.sendRedirect("receiverServlet?action=showAll");
                else
                    request.getRequestDispatcher("login.jsp?error=1").forward(request,response);

            }else {
                request.getRequestDispatcher("login.jsp?error=2").forward(request,response);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBHelper.closeConn(rs,ps,conn);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
