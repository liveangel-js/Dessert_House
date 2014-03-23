package edu.nju.dessert_house.servlet.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.dessert_house.dao.impl.CardDaoImpl;
import edu.nju.dessert_house.dao.impl.RechargeDaoImpl;
import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.model.user.Customer;

/**
 * Servlet implementation class CardStartServlet
 */
@WebServlet("/customer/cardStart")
public class CardStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardStartServlet() {
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
		String card=request.getParameter("card");
		String message="请输入正确卡号";
		if(!card.equals("")){
			message="激活成功";
			Customer c=(Customer) request.getSession(true).getAttribute("customer");
			c.setState("激活");
			request.setAttribute("customer", c);
			CardDaoImpl.getInstance().startCard(c.getCid());
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/customer/card.jsp").forward(request, response);
	}

}
