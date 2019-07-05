package cn.ccnu.wpy.controller;

import cn.ccnu.wpy.pojo.Receiver;
import cn.ccnu.wpy.service.IReceiverService;
import cn.ccnu.wpy.service.impl.ReceiverServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/receiverServlet", name = "ReceiverServlet")
public class ReceiverServlet extends HttpServlet {

    private IReceiverService receiverService = new ReceiverServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 获取action类型
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            add(request, response);
        } else if ("delete".equals(action)) {
            delete(request, response);
        } else if ("update".equals(action)) {
            update(request, response);
        } else if ("showAll".equals(action)) {
            showAll(request, response);
        } else if ("showOne".equals(action)) {
            showOne(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /*private int id;
    private String name;
    private String province;
    private String city;
    private String country;
    private String address;
    private String phone;
    private String postcode;
    private String street;
    private int userId;*/
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String postcode = request.getParameter("postcode");
        String street = request.getParameter("street");
        String userId = request.getParameter("userId");
        Receiver receiver = new Receiver(0, name, province, city, country, address, phone, postcode, street, Integer.parseInt(userId));
        int row = 0;
        try {
            row = receiverService.add(receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (row > 0) {
            response.sendRedirect("receiverServlet?action=showAll");
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int row = 0;
        try {
            row = receiverService.delete(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (row < 0) {
            request.setAttribute("msg", "删除失败");
        }
        request.getRequestDispatcher("receiverServlet?action=showAll").forward(request, response);

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String postcode = request.getParameter("postcode");
        String street = request.getParameter("street");
        String userId = request.getParameter("userId");
        Receiver receiver = new Receiver(Integer.parseInt(request.getParameter("id")), name, province, city, country, address, phone, postcode, street, Integer.parseInt(userId));
        int row = 0;
        try {
            row = receiverService.update(receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (row > 0) {
            response.sendRedirect("receiverServlet?action=showAll");
        } else {
            request.setAttribute("msg", "修改失败");
            request.getRequestDispatcher("receiver/update.jsp").forward(request, response);
        }

    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Receiver> list = null;
        try {
            list = receiverService.showAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list", list);
        request.getRequestDispatcher("receiver/showAll.jsp").forward(request, response);

    }

    private void showOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Receiver receiver = null;
        try {
            receiver = receiverService.showOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("info", receiver);
        request.getRequestDispatcher("receiver/update.jsp").forward(request, response);
    }

}
