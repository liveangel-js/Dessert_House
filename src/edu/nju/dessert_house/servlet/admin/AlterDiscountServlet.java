package edu.nju.dessert_house.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.dessert_house.dao.impl.DiscountDaoImpl;
import edu.nju.dessert_house.model.Discount;

/**
 * Servlet implementation class AlterDiscountServlet
 */
@WebServlet("/admin/alterDiscount")
public class AlterDiscountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterDiscountServlet() {
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
		
		int level=Integer.parseInt(request.getParameter("level"));
		double discount=Double.parseDouble(request.getParameter("discount"));
		double money=Double.parseDouble(request.getParameter("money"));
		Discount d=new Discount();
		d.setDiscount(discount);
		d.setLevel(level);
		d.setMoney(money);
		boolean result=DiscountDaoImpl.getInnstance().setDiscount(d);
		String message=null;
		if(result){
			message="修改成功";
		}else{
			message="修改失败";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/admin/discount").forward(request, response);
	}
}
