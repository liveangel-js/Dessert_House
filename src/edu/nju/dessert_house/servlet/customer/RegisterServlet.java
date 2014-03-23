package edu.nju.dessert_house.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.dessert_house.dao.OrderDao;
import edu.nju.dessert_house.dao.impl.OrderDaoIpml;
import edu.nju.dessert_house.dao.impl.UserDaoImpl;
import edu.nju.dessert_house.model.user.Customer;

/**
 * Servlet implementation class Register
 */
@WebServlet("/customer/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Customer c=UserDaoImpl.getInstance().registerCustomer(username, password);
		String message=null;
		if(c==null){
			message="信息输入错误";
		}else{
			message="注册成功";
			request.getSession(true).setAttribute("customer", c);
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/customer/index").forward(request, response);
	}

}
