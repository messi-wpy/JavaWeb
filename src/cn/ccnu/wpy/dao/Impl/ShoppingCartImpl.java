package cn.ccnu.wpy.dao.Impl;

import cn.ccnu.wpy.dao.ICommonDao;
import cn.ccnu.wpy.pojo.Product;
import cn.ccnu.wpy.pojo.ShoppingCart;
import cn.ccnu.wpy.util.DBHelper;
import sun.security.pkcs11.Secmod;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ICommonDao<ShoppingCart> {


    private java.sql.Connection conn = null;
    private java.sql.PreparedStatement ps = null;
    private String sql = null;
    @Override
    public int add(ShoppingCart u) throws Exception {
        conn= DBHelper.getConnection();
        sql="insert into tb_ShoppingCarts values(default ,?,?,?)";
        ps=conn.prepareStatement(sql);
        ps.setInt(1,u.getProductId());
        ps.setInt(2,u.getUserId());
        ps.setInt(3,u.getNumber());
        int row=ps.executeUpdate();
        DBHelper.closeConn(null,ps,conn);
        return row;
    }

    @Override
    public int delete(int id) throws Exception {
        sql="delete from tb_ShoppingCarts where ID=?";
        conn=DBHelper.getConnection();
        ps=conn.prepareStatement(sql);
        ps.setInt(1,id);
        int row=ps.executeUpdate();
        DBHelper.closeConn(null,ps,conn);

        return row;
    }

    public List<Product> getShopCart(int userId)throws Exception{
        sql="select *from tb_ShoppingCarts,tb_products where ProductID=tb_products.ID and UserID=? ";
        conn=DBHelper.getConnection();
        ps=conn.prepareStatement(sql);
        ps.setInt(1,userId);
        ResultSet rs =ps.executeQuery();
        List<Product>list=new ArrayList<>();
        while (rs.next()){
            Product product=new Product();
            product.setId(rs.getInt("ProductID"));
            product.setCategoryid(rs.getInt("CategoryID"));
            product.setName(rs.getString("Name"));
            product.setNum(rs.getInt("Number"));
            product.setDesc(rs.getString("descri"));
            product.setImagUrl(rs.getString("imagUrl"));
            list.add(product);

        }

        DBHelper.closeConn(rs,ps,conn);
        return list;
    }

    @Override
    public int update(ShoppingCart u) throws Exception {
        return 0;
    }

    @Override
    public List<ShoppingCart> showAll() throws Exception {
        return null;
    }

    @Override
    public ShoppingCart showOne(int id) throws Exception {
        return null;
    }
}
