package cn.ccnu.wpy.dao;

import cn.ccnu.wpy.pojo.Receiver;

import java.util.List;

public interface IReceiverDao {

    int add(Receiver u) throws Exception;
    int delete(int id) throws Exception;
    int update(Receiver u)throws Exception;
    List<Receiver> showAll()throws Exception;
    Receiver showOne(int id)throws Exception;
}
