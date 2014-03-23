package edu.nju.dessert_house.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.dessert_house.dao.impl.DiscountDaoImpl;
import edu.nju.dessert_house.model.Discount;
import edu.nju.dessert_house.model.Record;

/**
 * Servlet implementation class DiscountServlet
 */
@WebServlet("/admin/discount")
public class DiscountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscountServlet() {
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
		ArrayList<Discount>discounts=DiscountDaoImpl.getInnstance().getDiscountList();
		request.setAttribute("discounts", discounts);
		request.setAttribute("sale", "type_on");
		request.getRequestDispatcher("/admin/discount_manage.jsp").forward(request, response);
	}
}
