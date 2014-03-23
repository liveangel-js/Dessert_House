package edu.nju.dessert_house.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.dessert_house.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class AlterStaffServlet
 */
@WebServlet("/admin/alterStaff")
public class AlterStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterStaffServlet() {
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
		
		String hid=request.getParameter("hid");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String sex=request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));
		
		
		//System.out.println(hid);
		//System.out.println(username);
		//System.out.println(password);
		//System.out.println(name);
		//System.out.println(address);
		//System.out.println(phone);
		//System.out.println(sex);
		//System.out.println(age);
		
		boolean result=false;
		
		if(hid==null){
			result=UserDaoImpl.getInstance().addManager(username, password, name, address, sex, phone, age);
		}else{
			result=UserDaoImpl.getInstance().addClerk(username, password, name, address, sex, phone, age, Integer.parseInt(hid));
		}

		String message=null;
		if(result){
			message="添加成功";
		}else{
			message="添加失败";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/admin/staff").forward(request, response);
	}

}
