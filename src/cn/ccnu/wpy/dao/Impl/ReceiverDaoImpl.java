package cn.ccnu.wpy.dao.Impl;

import cn.ccnu.wpy.dao.IReceiverDao;
import cn.ccnu.wpy.pojo.Receiver;
import cn.ccnu.wpy.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReceiverDaoImpl implements IReceiverDao {

    private Connection conn=null;
    private PreparedStatement ps=null;
    @Override
    public int add(Receiver u) throws Exception {
        String sql="insert into tb_Receivers() values(default ,?,?,?,?,?,?,?,?,?)";
        Connection conn= DBHelper.getConnection();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,u.getName());
        ps.setString(2,u.getProvince());
        ps.setString(3,u.getCity());
        ps.setString(4,u.getCountry());
        ps.setString(5,u.getAddress());
        ps.setString(6,u.getPhone());
        ps.setString(7,u.getPostcode());
        ps.setString(8,u.getStreet());
        ps.setInt(9,u.getUserId());
        int i=ps.executeUpdate();
        DBHelper.closeConn(null,ps,conn);

        return i;
    }

    @Override
    public int delete(int id)throws Exception {
        conn=DBHelper.getConnection();
        String sql="delete from tb_Receivers where ID=?";
        ps=conn.prepareStatement(sql);
        ps.setInt(1,id);
        int row=ps.executeUpdate();
        DBHelper.closeConn(null,ps,conn);

        return row;
    }

    @Override
    public int update(Receiver u) throws Exception{
        conn=DBHelper.getConnection();
        String sql="update tb_Receivers set Name=?,Province=?,City=?,Country=?,Address=?,Phone=?,Postcode=?,Street=?,UserID=? where ID=? ";
        ps=conn.prepareStatement(sql);
        ps.setString(1,u.getName());
        ps.setString(2,u.getProvince());
        ps.setString(3,u.getCity());
        ps.setString(4,u.getCountry());
        ps.setString(5,u.getAddress());
        ps.setString(6,u.getPhone());
        ps.setString(7,u.getPostcode());
        ps.setString(8,u.getStreet());
        ps.setInt(9,u.getUserId());
        ps.setInt(10,u.getId());
        int row=ps.executeUpdate();
        DBHelper.closeConn(null,ps,conn);
        return row;
    }

    @Override
    public List<Receiver> showAll()throws Exception{
        List<Receiver>list=new ArrayList<>();
        conn=DBHelper.getConnection();
        String sql="select *from tb_Receivers ";
        ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Receiver receiver=new Receiver(rs.getInt("ID"),rs.getString("Name"),rs.getString("Province"),
                    rs.getString("City"),rs.getString("Country"),rs.getString("Address"),rs.getString("Phone"),
                    rs.getString("Postcode"),rs.getString("Street"),rs.getInt("UserID"));
            list.add(receiver);
        }
        DBHelper.closeConn(rs,ps,conn);
        return list;
    }

    @Override
    public Receiver showOne(int id) throws Exception {
        conn=DBHelper.getConnection();
        String sql="select *from tb_Receivers where ID=?";
        ps=conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        rs.next();
        Receiver receiver=new Receiver(rs.getInt("ID"),rs.getString("Name"),rs.getString("Province"),
                rs.getString("City"),rs.getString("Country"),rs.getString("Address"),rs.getString("Phone"),
                rs.getString("Postcode"),rs.getString("Street"),rs.getInt("UserID"));

        return receiver;
    }
}
