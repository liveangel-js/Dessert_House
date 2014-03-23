package edu.nju.dessert_house.servlet.customer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.dessert_house.dao.DessertDao;
import edu.nju.dessert_house.dao.impl.DessertDaoImpl;
import edu.nju.dessert_house.dao.impl.OrderDaoIpml;
import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.model.user.Customer;
import edu.nju.dessert_house.service.impl.OrderSerivceImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/customer/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		HttpSession session=request.getSession(true);
		ArrayList<Record>cart=(ArrayList<Record>) session.getAttribute("cart");
		if(cart==null){
			cart=new ArrayList<Record>();
			session.setAttribute("cart", cart);
		}
		Customer c=(Customer) request.getSession(true).getAttribute("customer");
		request.setAttribute("total", OrderSerivceImpl.getInstance().getOrderPrice(cart));
		request.setAttribute("discount", OrderSerivceImpl.getInstance().getOrderPrice(cart));
		if(c!=null){
			//System.out.println("not null");
			request.setAttribute("discount", OrderSerivceImpl.getInstance().getOrderPriceForDiscount(c.getCid(),cart));
		}
		request.getRequestDispatcher("/customer/dessert_cart.jsp").forward(request, response);
	}
}
