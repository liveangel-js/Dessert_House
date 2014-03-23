package edu.nju.dessert_house.servlet.clerk;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.dessert_house.dao.impl.UserDaoImpl;
import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.model.user.Clerk;
import edu.nju.dessert_house.model.user.Customer;
import edu.nju.dessert_house.service.impl.OrderSerivceImpl;

/**
 * Servlet implementation class MakeSellServlet
 */
@WebServlet("/clerk/makeSell")
public class MakeSellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeSellServlet() {
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
		String message=null;
		if(request.getSession(true).getAttribute("customer")==null){
			message="�������û�Ա���ţ�";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/clerk/sell").forward(request, response);
			return;
		}
		
		ArrayList<Record>records=(ArrayList<Record>) request.getSession(true).getAttribute("cart");
		
		if(records==null||records.size()==0){
			message="������Ʒ����Ϊ�գ�";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/clerk/sell").forward(request, response);
			return;
		}
		
		Customer c=(Customer) request.getSession(true).getAttribute("customer");
		
		if(c.getAccount()<OrderSerivceImpl.getInstance().getOrderPriceForDiscount(c.getCid(), records)){
			message="���㣬���ȳ�ֵ��";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/clerk/sell").forward(request, response);
			return;
		}
		
		Clerk clerk=(Clerk) request.getSession(true).getAttribute("clerk");
		
		int hid=clerk.getHid();
		OrderSerivceImpl.getInstance().makeSell(c.getCid(), records, hid, "����");
		c=UserDaoImpl.getInstance().getCustomer(c.getCid());
		request.getSession(true).removeAttribute("customer");
		message="���۳ɹ�";
		request.getSession(true).removeAttribute("cart");
		request.setAttribute("message", message);
		request.getRequestDispatcher("/clerk/sell").forward(request, response);
	}

}
