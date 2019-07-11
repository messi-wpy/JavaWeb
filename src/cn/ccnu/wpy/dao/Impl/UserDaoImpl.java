package cn.ccnu.wpy.dao.Impl;

import cn.ccnu.wpy.dao.ICommonDao;
import cn.ccnu.wpy.pojo.User;
import cn.ccnu.wpy.util.ConvertUtil;
import cn.ccnu.wpy.util.DBHelper;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class UserDaoImpl implements ICommonDao<User> {

	private java.sql.Connection conn = null;
	private java.sql.PreparedStatement ps = null;
	private String sql= null;
	@Override
	public int add(User user) throws Exception {
		// TODO Auto-generated method stub
//		tb_users(ID,Name,PasswordHash,Question,Answer,Sex,Birth,Phone,Mail)
		sql = "insert into tb_users values(default ,?,?,?,?,?,?,?,?)";
		conn = DBHelper.getConnection();
		int i =0;
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getName());
			ps.setString(2, user.getPasswordhash());
			ps.setString(3, user.getQuestion());
			ps.setString(4, user.getAnswer());
			ps.setBoolean(5, user.isSex());
			ps.setDate(6, Date.valueOf(user.getBirth()));
			ps.setString(7, user.getPhone());
			ps.setString(8, user.getMail());
			i = ps.executeUpdate();
		DBHelper.close(conn, null, ps);
		return i;
	}

	@Override
	public int delete(int id)throws Exception {
		// TODO Auto-generated method stub
		sql = "delete from tb_user where ID=?";
		conn = DBHelper.getConnection();
		int i = 0;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			i = ps.executeUpdate();



		DBHelper.close(conn, null, ps);
		return i;
	}

	@Override
	public int update(User user) throws Exception{
		// TODO Auto-generated method stub
//		tb_users(ID,Name,PasswordHash,Question,Answer,Sex,Birth,Phone,Mail)
		sql = "update tb_users set Name=?,PasswordHash=?,Question=?,Answer=?,Sex=?,Birth=?,Phone=?,Mail=? where  ID=?";
		conn = DBHelper.getConnection();
		int i = 0 ;

			ps = conn.prepareStatement(sql);
			ps.setInt(9, user.getId());
			ps.setString(1,user.getName());
			ps.setString(2, user.getPasswordhash());
			ps.setString(3, user.getQuestion());
			ps.setString(4, user.getAnswer());
			ps.setBoolean(5, user.isSex());
			ps.setDate(6, Date.valueOf(user.getBirth()));
			ps.setString(7, user.getPhone());
			ps.setString(8, user.getMail());
			i = ps.executeUpdate();
		DBHelper.close(conn, null, ps);
		return i;
	}

	@Override
	public List<User> showAll() throws Exception{
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		sql ="select * from tb_users";
		User user = null;
		conn = DBHelper.getConnection();
		ResultSet rSet = null;
			ps = conn.prepareStatement(sql);
			rSet = ps.executeQuery();
//			tb_users(ID,Name,PasswordHash,Question,Answer,Sex,Birth,Phone,Mail)
			while(rSet.next()){
				user = new User();
				user.setId(rSet.getInt("ID"));
				user.setName(rSet.getString("Name"));
				user.setPasswordhash(rSet.getString("Passwordhash"));
				user.setQuestion(rSet.getString("Question"));
				user.setAnswer(rSet.getString("Answer"));
				user.setSex(rSet.getBoolean("Sex"));
				user.setBirth(ConvertUtil.getDataString(rSet.getDate("Birth")));
				user.setPhone(rSet.getString("Phone"));
				user.setMail(rSet.getString("Mail"));
				list.add(user);
			}
		DBHelper.close(conn, rSet, ps);
		return list;
	}

	@Override
	public User showOne(int id)throws Exception {
		// TODO Auto-generated method stub
		sql = "select * from tb_users where ID=?";
		conn = DBHelper.getConnection();
		User user = null;
		ResultSet rSet = null;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rSet = ps.executeQuery();
			while(rSet.next()){
				user = new User();
				user.setId(rSet.getInt("ID"));
				user.setName(rSet.getString("Name"));
				user.setPasswordhash(rSet.getString("Passwordhash"));
				user.setQuestion(rSet.getString("Question"));
				user.setAnswer(rSet.getString("Answer"));
				user.setSex(rSet.getBoolean("Sex"));
				user.setBirth(ConvertUtil.getDataString(rSet.getDate("Birth")));
				user.setPhone(rSet.getString("Phone"));
				user.setMail(rSet.getString("Mail"));
			}

		DBHelper.close(conn, rSet, ps);
		return user;
	}

	public User test(String name)throws Exception{
		sql = "select * from tb_users where Name=?";
		conn = DBHelper.getConnection();
		User user = null;
		ResultSet rSet = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		rSet = ps.executeQuery();
		while(rSet.next()){
			user = new User();
			user.setId(rSet.getInt("ID"));
			user.setName(rSet.getString("Name"));
			user.setPasswordhash(rSet.getString("Passwordhash"));
			user.setQuestion(rSet.getString("Question"));
			user.setAnswer(rSet.getString("Answer"));
			user.setSex(rSet.getBoolean("Sex"));
			user.setBirth(ConvertUtil.getDataString(rSet.getDate("Birth")));
			user.setPhone(rSet.getString("Phone"));
			user.setMail(rSet.getString("Mail"));
		}

		DBHelper.close(conn, rSet, ps);
		return user;
	}

	
	public boolean isUser(String name, String passwordhash) throws Exception{
		// TODO Auto-generated method stub
		if(passwordhash.isEmpty() || null == passwordhash){
			return false;
		}else if(name.isEmpty() || null == name){
			return false;
		}else{
			this.sql = "select PasswordHash from tb_users where Name=?";
			this.conn = DBHelper.getConnection();
			ResultSet rSet = null; 
				this.ps = conn.prepareStatement(sql);
				this.ps.setString(1, name);
				rSet = this.ps.executeQuery();
				while(rSet.next()){
					if(passwordhash.equals(rSet.getString("PasswordHash")) ){
						return true;
					}
				}

			DBHelper.close(conn, rSet, ps);
			return false;
		}
	}


}
