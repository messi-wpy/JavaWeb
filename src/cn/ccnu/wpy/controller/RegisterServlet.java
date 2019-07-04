package cn.ccnu.wpy.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(value= "/RegistedServlet",name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String name=request.getParameter("name");
        String sql="insert into test_jdbc(name) values(?)";
        Connection conn=null;
        PreparedStatement ps=null;
        int i=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String url="jdbc:mysql://localhost:3306/bank";
            String user="root";
            String pwd="13569158099";
            conn= DriverManager.getConnection(url,user,pwd);

            ps=conn.prepareStatement(sql);
            ps.setString(1,name);

            i=ps.executeUpdate();
            System.out.println(i);

            if (ps!=null)
                ps.close();
            if (conn!=null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (i>0)
            response.sendRedirect("success.jsp");
        else {
            request.setAttribute("msg","注册失败");
            request.getRequestDispatcher("registed.jsp").forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
