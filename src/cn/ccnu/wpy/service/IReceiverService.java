package cn.ccnu.wpy.service;

import cn.ccnu.wpy.pojo.Receiver;

import java.util.List;

public interface IReceiverService {
    int add(Receiver r) throws Exception;
    int delete(int id) throws Exception;
    int update(Receiver r)throws Exception;
    List<Receiver>showAll()throws Exception;
    Receiver showOne(int id)throws Exception;


}
