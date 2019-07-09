package cn.ccnu.wpy.controller2;

import cn.ccnu.wpy.dao.Impl.ReceiverDaoImpl;
import cn.ccnu.wpy.pojo.Receiver;
import cn.ccnu.wpy.pojo.ResponseBody;
import cn.ccnu.wpy.util.ConvertUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/getReceiver",name = "Receiver2Servlet")
public class Receiver2Servlet extends HttpServlet {
    ReceiverDaoImpl receiverDao=new ReceiverDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("userId"));
        List<Receiver>list=null;
        response.setContentType("text/json;Charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            list=receiverDao.getUerReceiver(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResponseBody<List<Receiver>>body=new ResponseBody<>();
        if (list==null){
            response.setStatus(400);
            body.setMsg("查找失败");
            response.getWriter().println(ConvertUtil.gson.toJson(body));
        }else {
            response.setStatus(200);
            body.setBody(list);
            body.setMsg("查找成功");
            response.getWriter().println(ConvertUtil.gson.toJson(body));

        }

    }
}
