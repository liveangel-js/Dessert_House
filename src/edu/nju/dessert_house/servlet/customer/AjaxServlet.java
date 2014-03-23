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

import edu.nju.dessert_house.factory.DaoFactory;
import edu.nju.dessert_house.factory.ServiceFactory;
import edu.nju.dessert_house.model.Dessert;
import edu.nju.dessert_house.model.Record;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/customer/ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
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
		String action=request.getParameter("action");
		if(action.equals("add_dessert_to_cart")){
			add_dessert_to_cart(request, response);
			return;
		}
		if(action.equals("change_number")){
			change_number(request, response);
			return;
		}
		
	}
	
	
	private void add_dessert_to_cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int did=Integer.parseInt(request.getParameter("did"));
		int number=Integer.parseInt(request.getParameter("number"));
		
		HttpSession session=request.getSession(true);
		ArrayList<Record>cart=(ArrayList<Record>) session.getAttribute("cart");
		if(cart==null){
			cart=new ArrayList<Record>();
		}
		ServiceFactory.getDessertService().addDessert(did, number, cart);
		session.setAttribute("cart", cart);
		
		
		response.setContentType("application/x-json");  
        PrintWriter out= response.getWriter();
        String result="{'result':'成功'}";
        out.print(result);  
        out.close(); 
	}
	
	private void change_number(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int did=Integer.parseInt(request.getParameter("did"));
		int number=Integer.parseInt(request.getParameter("number"));
		
		HttpSession session=request.getSession(true);
		ArrayList<Record>cart=(ArrayList<Record>) session.getAttribute("cart");
		if(cart==null){
			cart=new ArrayList<Record>();
		}
		addDessert(did, number, cart);
		session.setAttribute("cart", cart);
		
		
		response.setContentType("application/x-json");  
        PrintWriter out= response.getWriter();
        String result="{'result':'成功'}";
        out.print(result);  
        out.close(); 
	}
	
	
	public void addDessert(int did, int number, ArrayList<Record> cart) {
		// TODO Auto-generated method stub
		for(int i=0;i<cart.size();i++){
			Record record=cart.get(i);
			if(record.getDessert().getDid()==did){
				record.setNumber(number);
				if(number==0){
					cart.remove(record);
				}
				return;
			}
		}
		Dessert dessert=DaoFactory.getDessertDao().getDessert(did);
		Record r=new Record();
		r.setDessert(dessert);
		r.setNumber(number);
		cart.add(r);
	}
}
