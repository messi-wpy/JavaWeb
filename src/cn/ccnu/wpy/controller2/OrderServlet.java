package cn.ccnu.wpy.controller2;

import cn.ccnu.wpy.dao.ICommonDao;
import cn.ccnu.wpy.dao.IReceiverDao;
import cn.ccnu.wpy.dao.Impl.OrderDaoImpl;
import cn.ccnu.wpy.dao.Impl.ProductDaoImpl;
import cn.ccnu.wpy.dao.Impl.ReceiverDaoImpl;
import cn.ccnu.wpy.dao.Impl.UserDaoImpl;
import cn.ccnu.wpy.pojo.*;
import cn.ccnu.wpy.util.ConvertUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/order",name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    private OrderDaoImpl orderDao=new OrderDaoImpl();
    private ICommonDao<User> userDao=new UserDaoImpl();
    private IReceiverDao receiver=new ReceiverDaoImpl();
    private ICommonDao<Product>productDao=new ProductDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;Charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        add(request,response);
        response.getWriter().close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;Charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        getOrder(request,response);
        response.getWriter().close();
    }

    public void add(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        JsonObject jsonObject= new JsonParser().parse(request.getReader()).getAsJsonObject();
        JsonArray array =jsonObject.getAsJsonArray("productId");
        int[]products=new int[array.size()];
        for (int i = 0; i <products.length ; i++) {
            products[i]=array.get(i).getAsInt();
        }
        JsonArray array2 =jsonObject.getAsJsonArray("nums");
        int[]nums=new int[array2.size()];
        for (int i = 0; i <products.length ; i++) {
            nums[i]=array2.get(i).getAsInt();
        }
        Order order=new Order();
        order.setAddressId(jsonObject.get("addressId").getAsInt());
        order.setSumPrice(jsonObject.get("sumPrice").getAsDouble());
        order.setOrderId(jsonObject.get("orderId").getAsInt());
        order.setUserId(jsonObject.get("userId").getAsInt());
        try {
            orderDao.add(products,nums,order);
            response.getWriter().println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("error");
            response.setStatus(400);
        }
    }

    public void getOrder(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        Map<Integer, List<Order>>map=null;
        try {
            map=orderDao.getAll();

        List<OrderBody>res=new ArrayList<>();
        if (map==null){
            response.setStatus(400);
        }
        map.forEach((k,v)->{
            OrderBody orderBody=new OrderBody();
            Order order=v.get(0);
            List<Product>productList=new ArrayList<>();
            try {
                User user= userDao.showOne(order.getUserId());
                Receiver r=receiver.showOne(order.getAddressId());
                orderBody.setReceiver(r);
                orderBody.setUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
                v.forEach(order1 -> {
                    try {
                        Product product=productDao.showOne(order1.getProductId());
                        product.setNum(order1.getNumber());
                        productList.add(product);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            orderBody.setProducts(productList);
            orderBody.setSum(order.getSumPrice());
            res.add(orderBody);
        });


        response.setStatus(200);
        response.getWriter().println(ConvertUtil.gson.toJson(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
