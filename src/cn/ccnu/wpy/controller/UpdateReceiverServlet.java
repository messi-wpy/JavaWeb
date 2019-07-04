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

@WebServlet(value = "/UpdateReceiverServlet",name = "UpdateReceiverServlet")
public class UpdateReceiverServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        Connection conn=null;
        PreparedStatement ps=null;
        int row=0;

        try{
            conn= DBHelper.getConnection();
            ps=conn.prepareStatement("update tb_Receivers set Name=? where ID=?");
            ps.setString(1,name);
            ps.setInt(2,id);
            row=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBHelper.closeConn(null,ps,conn);
        }

        if (row>0){
            response.sendRedirect("showReceiverAll");
        }else {
            request.setAttribute("msg","修改失败");
            request.getRequestDispatcher("showOne?id="+id);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
