package cn.ccnu.wpy.dao.Impl;

import cn.ccnu.wpy.dao.ICommonDao;
import cn.ccnu.wpy.pojo.Product;
import cn.ccnu.wpy.util.DBHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl implements ICommonDao<Product> {
	
	private java.sql.Connection conn = null;
	private java.sql.PreparedStatement ps = null;
	private String sql = null;
	
	public ProductDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int add(Product product) throws Exception {
		// TODO Auto-generated method stub
//		Product(id,name,catagoryid,num,,price)
		this.sql = "insert into tb_products values(default,?,?,?,?,?,?)";
		this.conn = DBHelper.getConnection();
		int i = 0;
		this.ps = this.conn.prepareStatement(sql);
		
		this.ps.setString(1, product.getName());
		this.ps.setInt(2, product.getCategoryid());
		this.ps.setInt(3, product.getNum());
		this.ps.setDouble(4, product.getPrice());
		ps.setString(5,product.getDesc());
		ps.setString(6,product.getImagUrl());
		i = this.ps.executeUpdate();
		DBHelper.close(conn, null, ps);
		return i;
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		this.sql = "delete from tb_products where ID=?";
		this.conn = DBHelper.getConnection();
		int i = 0;
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, id);

		i = this.ps.executeUpdate();
		DBHelper.close(conn, null, null);
		return i;
	}

	@Override
	public int update(Product product) throws Exception {
		// TODO Auto-generated method stub
//		Product(id,name,catagoryid,num,,price)
		this.sql = "update tb_products set Name=?,CategoryID=?,Num=?,Price=?,descri=?,imagUrl=? where ID=?";
		this.conn = DBHelper.getConnection();
		int i = 0;
		this.ps = this.conn.prepareStatement(sql);
		
		this.ps.setString(1, product.getName());
		this.ps.setInt(2, product.getCategoryid());
		this.ps.setInt(3, product.getNum());
		this.ps.setDouble(4, product.getPrice());
		ps.setString(5,product.getDesc());
		ps.setString(6,product.getImagUrl());
		this.ps.setInt(7, product.getId());

		i = this.ps.executeUpdate();
		DBHelper.close(conn, null, ps);
		return i;
	}

	@Override
	public List<Product> showAll() throws Exception {
		// TODO Auto-generated method stub
//		Product(id,name,catagoryid,num,,price)
		this.sql = "select * from tb_products";
		List<Product> list = new ArrayList<Product>();
		Product product = null;
		ResultSet rSet = null;
		this.conn = DBHelper.getConnection();
		this.ps = this.conn.prepareStatement(sql);
		rSet = this.ps.executeQuery();
		while(rSet.next()){
			product = new Product();
			product.setId(rSet.getInt("ID"));
			product.setName(rSet.getString("Name"));
			product.setCategoryid(rSet.getInt("CategoryId"));
			product.setNum(rSet.getInt("Num"));
			product.setPrice(rSet.getDouble("Price"));
			product.setDesc(rSet.getString("descri"));
			product.setImagUrl(rSet.getString("imagUrl"));
			list.add(product);
		}
		DBHelper.close(conn, rSet, ps);
		return list;
	}

	@Override
	public Product showOne(int id) throws Exception {
		// TODO Auto-generated method stub
//		Product(id,name,catagoryid,num,,price)
		this.sql = "select * from tb_products where ID=?";
		Product product = null;
		ResultSet rSet = null;
		this.conn = DBHelper.getConnection();
		this.ps = this.conn.prepareStatement(sql);
		
		this.ps.setInt(1, id);
		rSet = this.ps.executeQuery();
		while(rSet.next()){
			product = new Product();
			product.setId(rSet.getInt("ID"));
			product.setName(rSet.getString("Name"));
			product.setCategoryid(rSet.getInt("CategoryId"));
			product.setNum(rSet.getInt("Num"));
			product.setPrice(rSet.getDouble("Price"));
			product.setDesc(rSet.getString("descri"));
			product.setImagUrl(rSet.getString("imagUrl"));
		}
		return product;
	}

	public Product seekProduct(String name) throws Exception {
		// TODO Auto-generated method stub
//		Product(id,name,catagoryid,num,,price)
		this.sql = "select * from tb_products where Name=?";
		Product product = null;
		ResultSet rSet = null;
		this.conn = DBHelper.getConnection();
		this.ps = this.conn.prepareStatement(sql);
		
		this.ps.setString(1, name);
		rSet = this.ps.executeQuery();
		while(rSet.next()){
			product = new Product();
			product.setId(rSet.getInt("ID"));
			product.setName(rSet.getString("Name"));
			product.setCategoryid(rSet.getInt("CategoryId"));
			product.setNum(rSet.getInt("Num"));
			product.setPrice(rSet.getDouble("Price"));
			product.setDesc(rSet.getString("descri"));
			product.setImagUrl(rSet.getString("imagUrl"));
		}
		return product;
	}

	public List<Product> getCategoryProduct(int category) throws  Exception{
		sql="select *from tb_products where CategoryID=?";
		conn=DBHelper.getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1,category);
		ResultSet rSet=ps.executeQuery();
		List<Product>list=new ArrayList<>();
		while(rSet.next()){
			Product product = new Product();
			product.setId(rSet.getInt("ID"));
			product.setName(rSet.getString("Name"));
			product.setCategoryid(rSet.getInt("CategoryId"));
			product.setNum(rSet.getInt("Num"));
			product.setPrice(rSet.getDouble("Price"));
			product.setDesc(rSet.getString("descri"));
			product.setImagUrl(rSet.getString("imagUrl"));
			list.add(product);
		}

		DBHelper.closeConn(rSet,ps,conn);
		return list;

	}

}
