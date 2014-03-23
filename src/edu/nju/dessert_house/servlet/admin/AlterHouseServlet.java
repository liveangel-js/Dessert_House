package edu.nju.dessert_house.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.dessert_house.dao.impl.DiscountDaoImpl;
import edu.nju.dessert_house.dao.impl.UserDaoImpl;
import edu.nju.dessert_house.model.Discount;

/**
 * Servlet implementation class AlterHouseServlet
 */
@WebServlet("/admin/alterHouse")
public class AlterHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterHouseServlet() {
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
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		int hid=Integer.parseInt(request.getParameter("hid"));

		boolean result=UserDaoImpl.getInstance().alterClerkHouse(cid, hid);
		String message=null;
		if(result){
			message="修改成功";
		}else{
			message="修改失败";
		}
		
		response.setContentType("application/x-json");  
        PrintWriter out= response.getWriter();
        String result1="{'result':'成功'}";
        out.print(result1);  
        out.close(); 
		
		
		//request.setAttribute("message", message);
		//request.getRequestDispatcher("/admin/house").forward(request, response);
	}

}
