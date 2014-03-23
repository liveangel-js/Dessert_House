package edu.nju.dessert_house.servlet.clerk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.dessert_house.dao.impl.DessertDaoImpl;
import edu.nju.dessert_house.dao.impl.StockDaoImpl;
import edu.nju.dessert_house.model.user.Clerk;

/**
 * Servlet implementation class AlterStock
 */
@WebServlet("/clerk/alterStock")
public class AlterStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterStock() {
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
		int sid=Integer.parseInt(request.getParameter("sid"));
		double price=Double.parseDouble(request.getParameter("price"));
		int number=Integer.parseInt(request.getParameter("number"));
		boolean ok=StockDaoImpl.getInstance().alertStock(sid, number);
		int did=StockDaoImpl.getInstance().getDessertID(sid);
		ok&=DessertDaoImpl.getInstance().alterDessert(did, price);
		String message="修改成功";
		if(!ok){
			message="修改失败";
		}
		
		response.setContentType("application/x-json");  
        PrintWriter out= response.getWriter();
        String result="{'result':'成功'}";
        out.print(result);  
        out.close(); 
		
		
		//request.setAttribute("message", message);
		//request.getRequestDispatcher("/clerk/stock").forward(request, response);
	}
}
