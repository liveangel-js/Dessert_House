package edu.nju.dessert_house.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.dessert_house.factory.ServiceFactory;
import edu.nju.dessert_house.model.user.Customer;

/**
 * Servlet implementation class Login
 */
@WebServlet("/customer/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		Customer customer=ServiceFactory.getUserService().getCustomer(username, password);
		if(customer!=null){
			HttpSession session = request.getSession(true);
			session.setAttribute("customer",customer);
			request.setAttribute("dessert_list",ServiceFactory.getDessertService().getDessertList());
			request.getRequestDispatcher("/customer/index").forward(request, response);
		}else{
			System.out.println(request.getRequestURL());
			request.getRequestDispatcher("/customer/error.jsp").forward(request, response);
		}
	}
}
