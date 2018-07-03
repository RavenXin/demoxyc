package cn.yd.oa.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

	private ProductService productService = new ProductService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type.equals("query")) {
			String keyword = request.getParameter("keyword");
			// 把当前查询关键字存储在session中
			request.getSession().setAttribute("keyword", keyword);

			ArrayList<Product> proList = productService.queryByName(keyword);
			System.out.println(proList.size());
			request.setAttribute("p", proList);
			request.getSession().setAttribute("p", proList);
			// 当前页面跳转到query.jsp,重定向
			// response.sendRedirect("/demoxyc/query.jsp");
			// 转发
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		} else if (type.equals("save")) {
			System.out.println("request:" + request);
			System.out.println("response:" + response);
			Product product = new Product();
			product.setName(request.getParameter("name"));
			product.setRemark(request.getParameter("remark"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			productService.save(product);
			response.sendRedirect("/demoxyc/query.jsp");
		} else if (type.equals("delete")) {
			// 1: 获取前端数据
			Integer id = Integer.parseInt(request.getParameter("id"));
			// 2: 调用业务逻辑
			productService.delete(id);
			// 采用之前的关键字镜像查询
			HttpSession session = request.getSession();
			String keyword = (String) session.getAttribute("keyword");
			System.out.println(keyword);
			ArrayList<Product> proList = productService.queryByName(keyword);
			System.out.println(proList.size());
			// 此数据要交给query.jsp页面显示
			request.setAttribute("p", proList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			// 在转发此请求的时候,会把上一次request response提交
			dispatcher.forward(request, response);
		} else if (type.equals("update")) {
			System.out.println("此功能后面实现............");
		}

	}

}
