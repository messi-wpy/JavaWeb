package cn.ccnu.wpy.controller;

import cn.ccnu.wpy.pojo.Receiver;
import cn.ccnu.wpy.pojo.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/shoppingCart",name = "ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ShoppingCart> list;
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


            ps=conn.prepareStatement("insert into tb_ShoppingCarts values (?,?,?,?)");
            ps.setInt(1,Integer.valueOf(request.getParameter("id")));
            ps.setInt(2,Integer.valueOf(request.getParameter("productId")));
            ps.setInt(3,Integer.valueOf(request.getParameter("userId")));
            ps.setInt(4,Integer.valueOf(request.getParameter("number")));
            ps.executeUpdate();


            ps=conn.prepareStatement("select * from tb_ShoppingCarts");
            rs = ps.executeQuery();
            while (rs.next()){
                ShoppingCart cart=new ShoppingCart(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
                list.add(cart);

            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try
            {

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
        request.getRequestDispatcher("showShoppingCart.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
