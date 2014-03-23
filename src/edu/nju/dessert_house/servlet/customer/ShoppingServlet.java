package edu.nju.dessert_house.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.dessert_house.dao.OrderDao;
import edu.nju.dessert_house.dao.impl.OrderDaoIpml;
import edu.nju.dessert_house.model.user.Customer;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/customer/shopping")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
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
		OrderDao orderDao=OrderDaoIpml.getInstance();
		Customer c=(Customer) request.getSession(true).getAttribute("customer");
		request.setAttribute("orders", orderDao.getOrderList(c.getCid()));
		request.setAttribute("total", orderDao.getTotalPriceForCustomer(c.getCid()));
		//System.out.println( orderDao.getOrderList(c.getCid()).size());
		request.setAttribute("nav_shopping", "type_on");
		request.getRequestDispatcher("/customer/shopping.jsp").forward(request, response);
	}
}
