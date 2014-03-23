package edu.nju.dessert_house.servlet.index;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.dessert_house.dao.UserDao;
import edu.nju.dessert_house.dao.impl.UserDaoImpl;
import edu.nju.dessert_house.model.user.Clerk;
import edu.nju.dessert_house.model.user.Manager;

/**
 * Servlet implementation class VerifyLogin
 */
@WebServlet("/index/verifyLogin")
public class VerifyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyLogin() {
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
		String position=request.getParameter("position");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		if(position.equals("店员")){
			Clerk c=UserDaoImpl.getInstance().getClerk(username, password);
			if(c==null){
				request.setAttribute("message", "用户名、密码错误！");
				request.getRequestDispatcher("/index/index.jsp").forward(request, response);
				return;
			}else{
				request.getSession(true).setAttribute("clerk",c);
				request.getRequestDispatcher("/clerk/stock").forward(request, response);
				return;
			}
		}
		
		if(position.equals("经理")){
			Manager m=UserDaoImpl.getInstance().getManager(username, password);
			if(m==null){
				request.setAttribute("message", "用户名、密码错误！");
				request.getRequestDispatcher("/index/index.jsp").forward(request, response);
				return;
			}else{
				request.getSession(true).setAttribute("manager",m);
				request.getRequestDispatcher("/manager/customer_info").forward(request, response);
				return;
			}
		}
		
		if(position.equals("管理员")){
			boolean result=UserDaoImpl.getInstance().verifyAdmin(username, password);
			if(!result){
				request.setAttribute("message", "用户名、密码错误！");
				request.getRequestDispatcher("/index/index.jsp").forward(request, response);
				return;
			}else{
				request.getRequestDispatcher("/admin/house").forward(request, response);
				return;
			}
		}
	}
}
