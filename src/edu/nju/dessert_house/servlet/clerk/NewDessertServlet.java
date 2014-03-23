package edu.nju.dessert_house.servlet.clerk;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import edu.nju.dessert_house.dao.impl.DessertDaoImpl;
import edu.nju.dessert_house.dao.impl.StockDaoImpl;

/**
 * Servlet implementation class NewDessertServlet
 */
@WebServlet("/clerk/newDessert")
public class NewDessertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewDessertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 
		String message = "添加失败";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		try {
			List items = servletFileUpload.parseRequest(request);
			Iterator iterator = items.iterator();
			FileItem item = (FileItem) iterator.next();
			String name=item.getString("UTF-8");
			item = (FileItem) iterator.next();
			Double price=Double.parseDouble(item.getString("UTF-8"));
			item = (FileItem) iterator.next();
			String type=item.getString("UTF-8");
			item = (FileItem) iterator.next();
			int did = DessertDaoImpl.getInstance().addDessert(name, price, type);
			if (did>0) {
				message = "添加成功";
			}
			File file = new File(this.getServletContext().getRealPath("img/dessert/"+did+".jpg"));
			item.write(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/clerk/stock").forward(request, response);
	}

}
