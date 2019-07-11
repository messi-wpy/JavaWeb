package cn.ccnu.wpy.dao.Impl;

import cn.ccnu.wpy.pojo.Order;
import cn.ccnu.wpy.util.DBHelper;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl {

    private java.sql.Connection conn = null;
    private java.sql.PreparedStatement ps = null;
    private String sql = null;
    public void  add(int []products, int[]nums,Order u)throws Exception{
        conn= DBHelper.getConnection();
        sql="insert into tb_Orders value(default,null,?,?,?,?,?,null,?)";
        ps=conn.prepareStatement(sql);
        for (int i = 0; i <products.length ; i++) {
            ps.setInt(1,products[i]);
            ps.setInt(2,nums[i]);
            ps.setDouble(3,u.getSumPrice());
            ps.setInt(4,u.getUserId());
            ps.setInt(5,u.getAddressId());
            ps.setInt(6,u.getOrderId());
            ps.executeUpdate();
        }
        DBHelper.closeConn(null,ps,conn);

    }

    public Map<Integer,List<Order>> getAll()throws Exception{
        Map<Integer,List<Order>>map=new HashMap<>();
        conn=DBHelper.getConnection();
        sql="select * from tb_Orders";
        ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Order order=new Order();
            order.setSumPrice(rs.getDouble("SumPrice"));
            order.setUserId(rs.getInt("UserID"));
            order.setNumber(rs.getInt("Number"));
            order.setAddressId(rs.getInt("AddressID"));
            order.setProductId(rs.getInt("ProductID"));
            if (map.get(rs.getInt("orderId"))==null){
                map.put(rs.getInt("orderId"),new ArrayList<>());
            }
            List<Order>list=map.get(rs.getInt("orderId"));
            list.add(order);
        }
        return map;

    }





}
