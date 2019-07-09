package cn.ccnu.wpy.service.impl;

import cn.ccnu.wpy.dao.ICommonDao;
import cn.ccnu.wpy.pojo.User;
import cn.ccnu.wpy.service.ICommonService;

import java.util.List;

public class CommonServiceImpl<T>implements ICommonService<T> {
    private ICommonDao<T> dao= null;

    public ICommonDao<T> getDao(){
        return dao;
    }

    public CommonServiceImpl(ICommonDao<T>dao){
        this.dao=dao;

    }
    @Override
    public int add(T u) throws Exception {
        return dao.add(u);
    }

    @Override
    public int delete(int id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public int update(T u) throws Exception {
        return dao.update(u);
    }

    @Override
    public List<T> showAll() throws Exception {
        return dao.showAll();
    }

    @Override
    public T showOne(int id) throws Exception {
        return dao.showOne(id);
    }

}
