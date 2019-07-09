package cn.ccnu.wpy.controller2;

import cn.ccnu.wpy.dao.Impl.ProductDaoImpl;
import cn.ccnu.wpy.pojo.Product;
import cn.ccnu.wpy.pojo.ResponseBody;
import cn.ccnu.wpy.service.ICommonService;
import cn.ccnu.wpy.service.impl.ProductServiceImpl;
import cn.ccnu.wpy.util.ConvertUtil;
import cn.ccnu.wpy.util.DBHelper;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/product",name = "CategoryServlet")
public class CategoryServlet extends HttpServlet {

    ProductServiceImpl service=new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;Charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("categoryId"));
        List<Product>res=null;
        try {
            res=((ProductDaoImpl)service.getDao()).getCategoryProduct(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResponseBody<List<Product>>body=new ResponseBody<>();
        if (res==null){
            body.setCode(400);
            body.setMsg("类别查询为空");
            response.setStatus(400);
            response.getWriter().println(ConvertUtil.gson.toJson(body));
            return;
        }else {
            body.setCode(200);
            body.setMsg("查找成功");
            body.setBody(res);
            response.setStatus(200);
            response.getWriter().println(ConvertUtil.gson.toJson(body));

        }

    }
}
