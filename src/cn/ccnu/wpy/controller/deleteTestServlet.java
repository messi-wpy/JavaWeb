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


@WebServlet(value = "/deleteReceiver",name = "deleteTestServlet")
public class deleteTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        boolean update=Boolean.parseBoolean("update");

        Connection conn=null;
        PreparedStatement ps=null;
        int row=0;

        try {
            //反射加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://106.14.199.222:3306/DongGou";
            conn= DriverManager.getConnection(url,"root","Muxistudio304");


            if (update){
                ps = conn.prepareStatement("update tb_Receivers set name=?");


                return;
            }
            //连接对象获取预编译对象
            ps = conn.prepareStatement("delete from tb_Receivers where ID=?");

            //预编译对象执行
            ps.setInt(1, id);
            row=ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                //关闭资源
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }

        }

        if(row>0){
            response.sendRedirect("showReceiverAll");
        }else{

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
