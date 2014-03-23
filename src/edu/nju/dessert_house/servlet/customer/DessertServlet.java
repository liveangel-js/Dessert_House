package edu.nju.dessert_house.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import edu.nju.dessert_house.factory.ServiceFactory;
import edu.nju.dessert_house.model.Dessert;
import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.model.user.Customer;

/**
 * Servlet implementation class DessertServlet
 */
@WebServlet("/customer/dessert")
public class DessertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DessertServlet() {
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
		int did=Integer.parseInt(request.getParameter("did"));
		Dessert dessert=ServiceFactory.getDessertService().getDessert(did);
		request.setAttribute("dessert",dessert);
		request.getRequestDispatcher("/customer/dessert_detail.jsp").forward(request, response);
	}
}
