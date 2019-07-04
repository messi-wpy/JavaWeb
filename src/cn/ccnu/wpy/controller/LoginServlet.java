package cn.ccnu.wpy.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login",name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("username");
        String password=request.getParameter("password");

        if (userName.equals("wangpengyu")){
            if (password.equals("123456")){
                request.getRequestDispatcher("welcome.jsp").forward(request,response);
            }else {
                response.sendRedirect("login.jsp?error=1");
            }

        }else {
            response.sendRedirect("login.jsp?error=2");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
