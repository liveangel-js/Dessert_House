package edu.nju.dessert_house.servlet.clerk;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.dessert_house.factory.ServiceFactory;
import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.model.user.Clerk;

/**
 * Servlet implementation class AddDessertServlet
 */
@WebServlet("/clerk/addDessert")
public class AddDessertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDessertServlet() {
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
		int number=Integer.parseInt(request.getParameter("number"));
		
		HttpSession session=request.getSession(true);
		ArrayList<Record>cart=(ArrayList<Record>) session.getAttribute("cart");
		if(cart==null){
			cart=new ArrayList<Record>();
		}
		Clerk c=(Clerk) request.getSession(true).getAttribute("clerk");
		int hid=c.getHid();
		if(!ServiceFactory.getDessertService().isStaockEnough(did, number, cart, hid)){
			request.setAttribute("message","库存不足，请确认数量");
			request.getRequestDispatcher("/clerk/sell").forward(request, response);
			return;
		}
		
		ServiceFactory.getDessertService().addDessert(did, number, cart);
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("/clerk/sell").forward(request, response);
	}
	

}
