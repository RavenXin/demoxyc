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
			// �ѵ�ǰ��ѯ�ؼ��ִ洢��session��
			request.getSession().setAttribute("keyword", keyword);

			ArrayList<Product> proList = productService.queryByName(keyword);
			System.out.println(proList.size());
			request.setAttribute("p", proList);
			request.getSession().setAttribute("p", proList);
			// ��ǰҳ����ת��query.jsp,�ض���
			// response.sendRedirect("/demoxyc/query.jsp");
			// ת��
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
			// 1: ��ȡǰ������
			Integer id = Integer.parseInt(request.getParameter("id"));
			// 2: ����ҵ���߼�
			productService.delete(id);
			// ����֮ǰ�Ĺؼ��־����ѯ
			HttpSession session = request.getSession();
			String keyword = (String) session.getAttribute("keyword");
			System.out.println(keyword);
			ArrayList<Product> proList = productService.queryByName(keyword);
			System.out.println(proList.size());
			// ������Ҫ����query.jspҳ����ʾ
			request.setAttribute("p", proList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			// ��ת���������ʱ��,�����һ��request response�ύ
			dispatcher.forward(request, response);
		} else if (type.equals("update")) {
			System.out.println("�˹��ܺ���ʵ��............");
		}

	}

}
