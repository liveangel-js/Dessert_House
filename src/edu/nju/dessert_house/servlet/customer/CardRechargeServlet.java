package edu.nju.dessert_house.servlet.customer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.dessert_house.dao.impl.CardDaoImpl;
import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.model.user.Customer;

/**
 * Servlet implementation class CardRechargeServlet
 */
@WebServlet("/customer/cardRecharge")
public class CardRechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardRechargeServlet() {
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
		double number=Double.parseDouble(request.getParameter("number"));
		String message="请输入正确卡号并且充值额正确";
		if(!card.equals("")&&number>0){
			message="充值成功";
			Customer c=(Customer) request.getSession(true).getAttribute("customer");
			c.setAccount(c.getAccount()+number);
			request.setAttribute("customer", c);
			CardDaoImpl.getInstance().rechargeCard(number, c.getCid());
		}
		request.setAttribute("message", message);
		request.setAttribute("nav_card", "type_on");
		request.getRequestDispatcher("/customer/card.jsp").forward(request, response);
	}

}
