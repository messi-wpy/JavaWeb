package cn.ccnu.wpy.controller2;

import cn.ccnu.wpy.dao.Impl.UserDaoImpl;
import cn.ccnu.wpy.pojo.ResponseBody;
import cn.ccnu.wpy.pojo.User;
import cn.ccnu.wpy.service.ICommonService;
import cn.ccnu.wpy.service.impl.CommonServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(value = "/login",name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    ICommonService<User>loginService=new CommonServiceImpl<>(new UserDaoImpl());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        JsonObject jsonObject= new JsonParser().parse(request.getReader()).getAsJsonObject();
        Gson gson = new Gson();

        if (action!=null&&action.equals("registed")){
            User user=gson.fromJson(request.getReader(),User.class);
            try {
                loginService.add(user);
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(400);
                ResponseBody body=new ResponseBody();
                body.setCode(400);
                body.setMsg("错误");
                response.getWriter().println(gson.toJson(body));
                return;
            }
            response.setStatus(200);
            ResponseBody body=new ResponseBody();
            body.setCode(200);
            body.setMsg("注册成功!");
            response.getWriter().println(gson.toJson(body));
            return;

        }

        int account=jsonObject.get("account").getAsInt();
        String password=jsonObject.get("password").getAsString();
        User user=null;
        try {
            user=loginService.showOne(account);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        if (user==null){
            response.setStatus(400);
            ResponseBody body=new ResponseBody();
            body.setCode(400);
            body.setMsg("用户名不存在");
            response.getWriter().println(gson.toJson(body));
        }else if (!password.equals(user.getPasswordhash())){
            response.setStatus(400);
            ResponseBody body=new ResponseBody();
            body.setCode(400);
            body.setMsg("密码错误");
            response.getWriter().println(gson.toJson(body));
        }else {
            response.getWriter().println(gson.toJson(user));
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
