package edu.nju.dessert_house.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.dessert_house.dao.impl.DiscountDaoImpl;
import edu.nju.dessert_house.dao.impl.HouseDaoImpl;
import edu.nju.dessert_house.model.Discount;

/**
 * Servlet implementation class AddHouseServlet
 */
@WebServlet("/admin/addHouse")
public class AddHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHouseServlet() {
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
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		boolean ok=HouseDaoImpl.getInnstance().addHouse(name, address, phone);
		String message="添加失败";
		if(ok){
			message="添加成功";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/admin/house").forward(request, response);
	}

}
