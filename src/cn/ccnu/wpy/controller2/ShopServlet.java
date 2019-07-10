package cn.ccnu.wpy.controller2;

import cn.ccnu.wpy.dao.Impl.ShoppingCartImpl;
import cn.ccnu.wpy.pojo.Product;
import cn.ccnu.wpy.pojo.ResponseBody;
import cn.ccnu.wpy.pojo.ShoppingCart;
import cn.ccnu.wpy.util.ConvertUtil;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/shop",name = "ShopServlet")
public class ShopServlet extends HttpServlet {
    ShoppingCartImpl shoppingDao=new ShoppingCartImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;Charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action=request.getParameter("action");
        if (action.equals("add")){
            add(request,response);
        }else if (action.equals("delete")){
            delete(request,response);
        }else if (action.equals("getShopCar"))
            getShopCar(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public int add(HttpServletRequest request, HttpServletResponse response)  {
        int res=0;
        ResponseBody<ShoppingCart>body=new ResponseBody<>();
        try {
            ShoppingCart cart = ConvertUtil.gson.fromJson(request.getReader(), ShoppingCart.class);
            res = shoppingDao.add(cart);
            body.setMsg("添加成功");
            body.setCode(200);
            response.setStatus(200);
            response.getWriter().println(ConvertUtil.gson.toJson(body));
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    public void delete(HttpServletRequest request, HttpServletResponse response){

        try {
            shoppingDao.delete(Integer.parseInt(request.getParameter("pId")),Integer.parseInt(request.getParameter("uId")));
            response.getWriter().println("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(400);
        }
    }

    public void getShopCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Product>list=null;
        try {
            list=shoppingDao.getShopCart(Integer.parseInt(request.getParameter("userId")));
        }catch (Exception e){
            e.printStackTrace();
        }
        ResponseBody<List<Product>>body=new ResponseBody<>();
        body.setCode(200);
        body.setBody(list);
        body.setMsg("查找成功");
        response.getWriter().println(ConvertUtil.gson.toJson(body));
    }
}
