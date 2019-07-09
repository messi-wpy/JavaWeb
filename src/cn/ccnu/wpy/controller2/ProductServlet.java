package cn.edu.ccnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ccnu.wpy.pojo.Product;
import cn.ccnu.wpy.service.ICommonService;
import cn.ccnu.wpy.service.impl.ProductServiceImpl;
import com.google.gson.Gson;


/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICommonService<Product> service = new ProductServiceImpl();
	private Gson gson = new Gson();
	private PrintWriter printWriter = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/json;Charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if("insert".equals(action)){
			this.add(request, response);
		}else if("update".equals(action)){
			this.update(request, response);
		}else if("delete".equals(action)){
			this.delete(request, response);
		}else if("showAll".equals(action)){
			this.showAll(request, response);
		}else if("seek".equals(action)){
			this.seek(request, response);
		}else{
//			request.setAttribute("action_msg", "action wrong!");
		}
	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		Product(id,name,catagoryid,num,,price)
		Product product = this.gson.fromJson(request.getReader(), Product.class);
		int i = 0;
		try {
			i = this.service.add(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonMsg = null;
		if(i > 0){
			jsonMsg = this.gson.toJson("增加商品成功！");
		}else{
			jsonMsg = this.gson.toJson("增加商品失败！");
		}
		this.printWriter = response.getWriter();
		printWriter.println(jsonMsg);
		printWriter.close();
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Product product = gson.fromJson(request.getReader(), Product.class);
		int i = 0;
		try {
			i = this.service.update(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonMsg = null;
		if(i > 0){
			jsonMsg = this.gson.toJson("更新商品成功！");
		}else{
			jsonMsg = this.gson.toJson("更新商品失败！");
		}
		this.printWriter = response.getWriter();
		printWriter.println(jsonMsg);
		printWriter.close();
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String stringId = request.getParameter("ID");
		int id = Integer.parseInt(stringId);
		int i = 0;
		try {
			i = this.service.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonMsg = null;
		if(i > 0){
			jsonMsg = this.gson.toJson("删除商品成功！");
		}else{
			jsonMsg = this.gson.toJson("删除商品失败！");
		}
		this.printWriter = response.getWriter();
		printWriter.println(jsonMsg);
		printWriter.close();
	}

	protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Product> list = null;
		try {
			list = new ProductServiceImpl().showAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonMsg = null;
		if(null == list){
			jsonMsg = this.gson.toJson("当前商品为空！");
		}else{
			jsonMsg = this.gson.toJson(list);
		}
		this.printWriter = response.getWriter();
		printWriter.println(jsonMsg);
		printWriter.close();
	}

	protected void seek(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String stringId = request.getParameter("ID");
		int id = Integer.parseInt(stringId);
		Product product = null;
		try {
			product = this.service.showOne(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonMsg = null;
		if(product != null){
			jsonMsg = this.gson.toJson(product);
		}else{
			jsonMsg = this.gson.toJson("查找商品失败！");
		}
		this.printWriter = response.getWriter();
		printWriter.println(jsonMsg);
		printWriter.close();
	}
}