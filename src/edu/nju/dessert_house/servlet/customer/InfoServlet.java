package edu.nju.dessert_house.servlet.customer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.model.user.Customer;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/customer/info")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
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
		request.setAttribute("nav_info", "type_on");
		//Customer customer=(Customer) request.getSession().getAttribute("customer");
		//if(customer.getSex().equals("ÄÐ")){
		//	request.setAttribute("man", "selected");
		//}
		//if(customer.getSex().equals("Å®")){
		//	request.setAttribute("woman", "selected");
		//}
		request.getRequestDispatcher("/customer/info.jsp").forward(request, response);
		
	}

}
