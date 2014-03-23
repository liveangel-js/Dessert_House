package edu.nju.dessert_house.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.dessert_house.dao.impl.RechargeDaoImpl;
import edu.nju.dessert_house.model.user.Customer;

/**
 * Servlet implementation class RechargeServlet
 */
@WebServlet("/customer/recharge")
public class RechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeServlet() {
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
		Customer c=(Customer) request.getSession(true).getAttribute("customer");
		request.setAttribute("recharges", RechargeDaoImpl.getInstance().getRechargeList(c.getCid()));
		request.setAttribute("total", RechargeDaoImpl.getInstance().getRechargeTotal(c.getCid()));
		request.setAttribute("nav_recharge", "type_on");
		request.getRequestDispatcher("/customer/recharge.jsp").forward(request, response);
	}
}
