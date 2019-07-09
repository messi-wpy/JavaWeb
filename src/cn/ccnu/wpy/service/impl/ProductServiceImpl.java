package cn.ccnu.wpy.service.impl;

import cn.ccnu.wpy.dao.ICommonDao;
import cn.ccnu.wpy.dao.Impl.ProductDaoImpl;
import cn.ccnu.wpy.pojo.Product;
import cn.ccnu.wpy.service.ICommonService;

import java.util.List;


public class ProductServiceImpl implements ICommonService<Product> {

	private ICommonDao<Product> dao = new ProductDaoImpl();

	public ICommonDao getDao(){
		return dao;
	}
	@Override
	public int add(Product product) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.add(product);
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.delete(id);
	}

	@Override
	public int update(Product product) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.update(product);
	}

	@Override
	public List<Product> showAll() throws Exception {
		// TODO Auto-generated method stub
		return this.dao.showAll();
	}

	@Override
	public Product showOne(int id) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.showOne(id);
	}

	public Product seekProduct(int id) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.showOne(id);
	}

	public Product seekProduct(String name) throws Exception {
		// TODO Auto-generated method stub
		ProductServiceImpl service = (ProductServiceImpl)this.dao;
		return service.seekProduct(name);
	}

}
