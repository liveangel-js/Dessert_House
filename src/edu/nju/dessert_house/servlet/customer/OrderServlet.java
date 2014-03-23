package edu.nju.dessert_house.servlet.customer;

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
import edu.nju.dessert_house.model.user.Customer;
import edu.nju.dessert_house.service.OrderService;
import edu.nju.dessert_house.service.impl.OrderSerivceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/customer/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
			message="���ȵ�¼��";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/customer/cart").forward(request, response);
			return;
		}
		
		
		ArrayList<Record>records=(ArrayList<Record>) request.getSession(true).getAttribute("cart");
		
		if(records==null||records.size()==0){
			message="���ﳵΪ�գ�";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/customer/cart").forward(request, response);
			return;
		}
		
		Customer c=(Customer) request.getSession(true).getAttribute("customer");
		
		if(!c.getState().equals("����")){
			message="��ȷ����Ļ�Ա���Ѿ����";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/customer/cart").forward(request, response);
			return;
		}
		
		
		if(c.getAccount()<OrderSerivceImpl.getInstance().getOrderPriceForDiscount(c.getCid(), records)){
			message="���㣬���ȳ�ֵ��";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/customer/cart").forward(request, response);
			return;
		}
		
		
		int hid=Integer.parseInt(request.getParameter("hid"));
		OrderSerivceImpl.getInstance().makeOrder(c.getCid(), records, hid, "Ԥ��");
		c=UserDaoImpl.getInstance().getCustomer(c.getCid());
		request.getSession(true).setAttribute("customer", c);
		message="Ԥ���ɹ�";
		request.getSession(true).removeAttribute("cart");
		request.setAttribute("message", message);
		request.getRequestDispatcher("/customer/shopping").forward(request, response);
	}
}
