package edu.nju.dessert_house.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.dessert_house.dao.impl.HouseDaoImpl;
import edu.nju.dessert_house.dao.impl.UserDaoImpl;
import edu.nju.dessert_house.model.House;
import edu.nju.dessert_house.model.user.Clerk;
import edu.nju.dessert_house.model.user.Manager;

/**
 * Servlet implementation class StaffServlet
 */
@WebServlet("/admin/staff")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffServlet() {
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
		ArrayList<Clerk>clerks=UserDaoImpl.getInstance().getClerks();
		request.setAttribute("clerks", clerks);
		ArrayList<House>houses=HouseDaoImpl.getInnstance().getHouses();
		request.setAttribute("houses", houses);
		ArrayList<Manager>managers=UserDaoImpl.getInstance().getManagers();
		request.setAttribute("managers", managers);
		request.setAttribute("people", "type_on");
		request.getRequestDispatcher("/admin/staff_manage.jsp").forward(request, response);
	}
}
