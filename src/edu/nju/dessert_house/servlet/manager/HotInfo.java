package edu.nju.dessert_house.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.dessert_house.dao.impl.RecordDaoImpl;

/**
 * Servlet implementation class HotInfo
 */
@WebServlet("/manager/hot_info")
public class HotInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotInfo() {
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
		request.setAttribute("records", RecordDaoImpl.getInstance().getRecordsByNumber());
		//System.out.print(RecordDaoImpl.getInstance().getRecordsByNumber().size());
		request.setAttribute("type", "ÈÈÂô²úÆ·");
		request.getRequestDispatcher("/manager/hot_info.jsp").forward(request, response);
		
	}

}
