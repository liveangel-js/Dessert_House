package edu.nju.dessert_house.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.dessert_house.dao.DessertDao;
import edu.nju.dessert_house.dao.impl.DessertDaoImpl;
import edu.nju.dessert_house.factory.ServiceFactory;
import edu.nju.dessert_house.model.user.Customer;

/**
 * Servlet implementation class Index
 */
@WebServlet("/customer/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		
		
		if(request.getParameter("search")!=null){
			//search(request, response);
			//return;
		}
		if(request.getParameter("type")!=null){
			//type(request, response);
			//return;
		}
		//index(request, response);
		deal(request, response);
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dessert_list", ServiceFactory.getDessertService().getDessertList());
		request.getRequestDispatcher("/customer/index.jsp").forward(request, response);
		
		//deal
	}
	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key=request.getParameter("search");
		key=new String(key.getBytes("ISO-8859-1"),"utf-8");
		request.setAttribute("dessert_list", ServiceFactory.getDessertService().getDessertListByKey(key));
		request.getRequestDispatcher("/customer/index.jsp").forward(request, response);
	}
	private void type(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		type=new String(type.getBytes("ISO-8859-1"),"utf-8");
		//request.setAttribute("dessert_list", ServiceFactory.getDessertService().getDessertListByType(type));
		request.setAttribute("dessert_list", DessertDaoImpl.getInstance().getDessertListByType(type,2,"12"));
		request.getRequestDispatcher("/customer/index.jsp").forward(request, response);
	}
	
	
	public void deal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String page_url="";
		String sort_url="";
		
		String search=request.getParameter("search");
		if(search!=null){
			search=new String(search.getBytes("ISO-8859-1"),"utf-8");
			page_url+="search="+search+"&";
			sort_url+="search="+search+"&";
			search="name REGEXP "+"'"+search+"'";
			
		}else{
			search="";
		}
		
		String type=request.getParameter("type");
		if(type!=null){
			type=new String(type.getBytes("ISO-8859-1"),"utf-8");
			request.setAttribute("type", type);
			page_url+="type="+type+"&";
			sort_url+="type="+type+"&";
			type="type="+"'"+type+"'";
			
		}else{
			type="";
			request.setAttribute("type", type);
			if(!search.equals("")){
				request.setAttribute("type", "search");
			}
		}
		
		
		int page;
		if(request.getParameter("page")==null){
			page=1;
		}else{
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		
		String sort=request.getParameter("sort");
		if(sort==null){
			sort="did";
		}
		request.setAttribute("sort", sort);
		
		page_url+="sort="+sort+"&";
		
		sort="order by "+sort+" ASC";
		
		String sql="select count(*) as num from dessert where ";
		if(search.equals("")&&type.equals("")){
			sql="select count(*) as num from dessert ";
		}
		sql=sql+search+type+" "+sort+"";
		int page_number=(DessertDaoImpl.getInstance().getDessertNumber(sql)-1)/8+1;
		int numebr_per_page=8;
		String page_sort="LIMIT "+numebr_per_page*(page-1)+","+numebr_per_page;
		
		
		
		sql="select * from dessert where ";
		if(search.equals("")&&type.equals("")){
			sql="select * from dessert ";
		}
		sql=sql+search+type+" "+sort+" "+page_sort;
		//System.out.println(sql);
		request.setAttribute("page_total", page_number);
		request.setAttribute("current_page", page);
		//System.out.println(page);
		
		request.setAttribute("sort_url", sort_url);
		request.setAttribute("page_url", page_url);
		request.setAttribute("dessert_list", DessertDaoImpl.getInstance().getDessertList(sql));
		request.getRequestDispatcher("/customer/index.jsp").forward(request, response);
	}
	
	
}
