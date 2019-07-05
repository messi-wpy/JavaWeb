package cn.ccnu.wpy.service.impl;

import cn.ccnu.wpy.dao.IReceiverDao;
import cn.ccnu.wpy.dao.Impl.ReceiverDaoImpl;
import cn.ccnu.wpy.pojo.Receiver;
import cn.ccnu.wpy.service.IReceiverService;

import java.util.List;

public class ReceiverServiceImpl implements IReceiverService {
    private IReceiverDao receiverDao=new ReceiverDaoImpl();



    @Override
    public int add(Receiver r) throws Exception {
        return receiverDao.add(r);
    }

    @Override
    public int delete(int id)throws Exception {
        return receiverDao.delete(id);
    }

    @Override
    public int update(Receiver r)throws Exception {
        return receiverDao.update(r);
    }

    @Override
    public List<Receiver> showAll()throws Exception {
        return receiverDao.showAll();
    }

    @Override
    public Receiver showOne(int id)throws Exception {
        return receiverDao.showOne(id);
    }
}
