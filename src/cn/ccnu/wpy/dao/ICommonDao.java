package cn.ccnu.wpy.dao;

import cn.ccnu.wpy.pojo.User;

import java.util.List;


public interface ICommonDao<T> {

	int add(T u) throws Exception;
	int delete(int id) throws Exception;
	int update(T u) throws Exception;
	List<T> showAll() throws Exception;
	T showOne(int id) throws Exception;

}
