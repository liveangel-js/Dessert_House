package edu.nju.dessert_house.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.dessert_house.dao.impl.UserDaoImpl;
import edu.nju.dessert_house.factory.ServiceFactory;
import edu.nju.dessert_house.model.Dessert;
import edu.nju.dessert_house.model.user.Customer;

/**
 * Servlet implementation class AlterInfoServlet
 */
@WebServlet("/customer/alterInfo")
public class AlterInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}
	
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String sex=request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));
		Customer c=(Customer) request.getSession(true).getAttribute("customer");
		String message=null;
		boolean ok=UserDaoImpl.getInstance().alterCustomer(c.getCid(), password, name, address, phone, age, sex);
		if(ok){
			message="修改成功";
			request.getSession(true).setAttribute("customer", UserDaoImpl.getInstance().getCustomer(c.getUsername(), password));
		}else{
			message="信息是输入错误";
		}
		request.setAttribute("message", message);
		request.setAttribute("nav_info", "type_on");
		request.getRequestDispatcher("/customer/info.jsp").forward(request, response);
	}

}
