package cn.ccnu.wpy.dao.Impl;

import cn.ccnu.wpy.dao.ICommonDao;
import cn.ccnu.wpy.pojo.Category;
import cn.ccnu.wpy.util.DBHelper;

import java.util.List;

public class CategoryDaoImpl implements ICommonDao<Category> {

    private java.sql.Connection conn = null;
    private java.sql.PreparedStatement ps = null;
    private String sql= null;
    @Override
    public int add(Category u) throws Exception {
        sql="insert into tb_categories values(?,?,?)";
        conn= DBHelper.getConnection();
        ps=conn.prepareStatement(sql);
        ps.setInt(1,u.id);
        ps.setString(2,u.name);
        ps.setInt(3,u.fatherId);
        int row=ps.executeUpdate();
        DBHelper.closeConn(null,ps,conn);
        return row;
    }

    @Override
    public int delete(int id) throws Exception {
        return 0;
    }

    @Override
    public int update(Category u) throws Exception {
        return 0;
    }

    @Override
    public List<Category> showAll() throws Exception {
        return null;
    }

    @Override
    public Category showOne(int id) throws Exception {
        return null;
    }
}
