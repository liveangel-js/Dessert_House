package edu.nju.dessert_house.servlet.clerk;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.dessert_house.dao.impl.StockDaoImpl;
import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.model.user.Clerk;

/**
 * Servlet implementation class StockServlet
 */
@WebServlet("/clerk/stock")
public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockServlet() {
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
		Clerk c	=(Clerk) session.getAttribute("clerk");
		int hid=c.getHid();
		request.setAttribute("stocks", StockDaoImpl.getInstance().getStockList(hid));
		//System.out.println(c.getUsername());
		//System.out.println(StockDaoImpl.getInstance().getStockList(hid).size());
		request.setAttribute("nav_manage", "type_on");
		request.getRequestDispatcher("/clerk/stock.jsp").forward(request, response);
	}

}
