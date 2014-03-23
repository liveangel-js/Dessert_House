package edu.nju.dessert_house.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import sun.misc.Cleaner;

import edu.nju.dessert_house.dao.DaoHelper;
import edu.nju.dessert_house.dao.UserDao;
import edu.nju.dessert_house.model.user.Clerk;
import edu.nju.dessert_house.model.user.Customer;
import edu.nju.dessert_house.model.user.Manager;


public class UserDaoImpl implements UserDao {
	
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	private static UserDao userDao=new UserDaoImpl();
	
	
	
	public static UserDao getInstance(){
		return userDao;
	}
	
	private UserDaoImpl(){
		
	}
	

	@Override
	public Customer getCustomer(String username, String password) {
		// TODO Auto-generated method stub
		Customer customer=null;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from customer where username=? AND password=?");
			stmt.setString(1,username);
			stmt.setString(2, password);
			result=stmt.executeQuery();
			if(result.next()){
				customer=new Customer();
				customer.setCid(result.getInt("cid"));
				customer.setUsername(username);
				customer.setPassword(password);
				customer.setName(result.getString("name"));
				customer.setAddress(result.getString("address"));
				customer.setAge(result.getInt("age"));
				customer.setPhone(result.getString("phone"));
				customer.setSex(result.getString("sex"));
				customer.setAccount(result.getDouble("account"));
				customer.setState(result.getString("state"));
				customer.setLevel(result.getInt("level"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return customer;	
	}

	@Override
	public Clerk getClerk(String username, String password) {
		// TODO Auto-generated method stub
		Clerk clerk=null;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from clerk where username=? AND password=?");
			stmt.setString(1,username);
			stmt.setString(2, password);
			result=stmt.executeQuery();
			if(result.next()){
				clerk=new Clerk();
				clerk.setCid(result.getInt("cid"));
				clerk.setUsername(username);
				clerk.setPassword(password);
				clerk.setName(result.getString("name"));
				clerk.setAddress(result.getString("address"));
				clerk.setAge(result.getInt("age"));
				clerk.setPhone(result.getString("phone"));
				clerk.setSex(result.getString("sex"));
				clerk.setHid(result.getInt("hid"));
				clerk.setHouse(HouseDaoImpl.getInnstance().getHouse(result.getInt("hid")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return clerk;	
	}

	@Override
	public Manager getManager(String username, String password) {
		// TODO Auto-generated method stub
		Manager manager=null;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from manager where username=? AND password=?");
			stmt.setString(1,username);
			stmt.setString(2, password);
			result=stmt.executeQuery();
			if(result.next()){
				manager=new Manager();
				manager.setMid(result.getInt("mid"));
				manager.setUsername(username);
				manager.setPassword(password);
				manager.setName(result.getString("name"));
				manager.setAddress(result.getString("address"));
				manager.setAge(result.getInt("age"));
				manager.setPhone(result.getString("phone"));
				manager.setSex(result.getString("sex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return manager;	
	}

	@Override
	public boolean verifyAdmin(String username, String password) {
		// TODO Auto-generated method stub
		boolean exit=false;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from admin where username=? AND password=?");
			stmt.setString(1,username);
			stmt.setString(2, password);
			result=stmt.executeQuery();
			if(result.next()){
				exit=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return exit;	
	}

	@Override
	public Customer registerCustomer(String username, String password) {
		// TODO Auto-generated method stub
		Customer customer=null;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		int result=0;
		try 
		{
			stmt=con.prepareStatement("insert into customer(username,password,level,state,account,name,time) values(?,?,?,?,?,?,?)");
			stmt.setString(1,username);
			stmt.setString(2, password);
			stmt.setInt(3, 1);
			stmt.setString(4, "ÔÝÍ£");
			stmt.setDouble(5, 0);
			stmt.setString(6, "¹Ë¿Í");
			stmt.setString(7, getTime());
			result=stmt.executeUpdate();
			if(result>0){
				customer=getCustomer(username, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return customer;
	}
	
	private String getTime(){
		Format format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(Calendar.getInstance().getTime());
        return date;
	}

	@Override
	public ArrayList<Clerk> getClerks() {
		// TODO Auto-generated method stub
		ArrayList<Clerk> clerks=new ArrayList<Clerk>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from clerk");
			result=stmt.executeQuery();
			while(result.next()){
				Clerk clerk=new Clerk();
				clerk.setCid(result.getInt("cid"));
				clerk.setUsername(result.getString("username"));
				clerk.setPassword(result.getString("password"));
				clerk.setName(result.getString("name"));
				clerk.setAddress(result.getString("address"));
				clerk.setAge(result.getInt("age"));
				clerk.setPhone(result.getString("phone"));
				clerk.setSex(result.getString("sex"));
				clerk.setHid(result.getInt("hid"));
				clerk.setHouse(HouseDaoImpl.getInnstance().getHouse(result.getInt("hid")));
				clerks.add(clerk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return clerks;	
	}

	@Override
	public boolean alterClerkHouse(int cid, int hid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		boolean result=false;
		try 
		{
			stmt=con.prepareStatement("update clerk set hid=? where cid=?");
			stmt.setDouble(1,hid);
			stmt.setInt(2,cid);
			int row=stmt.executeUpdate();
			if(row>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return result;
	}

	@Override
	public ArrayList<Manager> getManagers() {
		// TODO Auto-generated method stub
		ArrayList<Manager> managers=new ArrayList<Manager>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from manager");
			result=stmt.executeQuery();
			while(result.next()){
				Manager manager=new Manager();
				manager.setMid(result.getInt("mid"));
				manager.setUsername(result.getString("username"));
				manager.setPassword(result.getString("password"));
				manager.setName(result.getString("name"));
				manager.setAddress(result.getString("address"));
				manager.setAge(result.getInt("age"));
				manager.setPhone(result.getString("phone"));
				manager.setSex(result.getString("sex"));
				managers.add(manager);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return managers;	
	}

	@Override
	public boolean addClerk(String username, String password, String name,
			String address, String sex, String phone, int age, int hid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		int row;
		boolean result=false;
		try 
		{
			stmt=con.prepareStatement("insert into clerk(username,password,name,address,phone,age,sex,hid) values(?,?,?,?,?,?,?,?)");
			stmt.setString(1,username);
			stmt.setString(2, password);
			stmt.setString(3, name);
			stmt.setString(4, address);
			stmt.setString(5, phone);
			stmt.setInt(6, age);
			stmt.setString(7, sex);
			stmt.setInt(8, hid);
			row=stmt.executeUpdate();
			if(row>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return result;
	}

	@Override
	public boolean addManager(String username, String password, String name,
			String address, String sex, String phone, int age) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		int row;
		boolean result=false;
		try 
		{
			stmt=con.prepareStatement("insert into manager(username,password,name,address,phone,age,sex) values(?,?,?,?,?,?,?)");
			stmt.setString(1,username);
			stmt.setString(2, password);
			stmt.setString(3, name);
			stmt.setString(4, address);
			stmt.setString(5, phone);
			stmt.setInt(6, age);
			stmt.setString(7, sex);
			row=stmt.executeUpdate();
			if(row>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return result;
	}

	@Override
	public ArrayList<Customer> getCustomers() {
		// TODO Auto-generated method stub
		ArrayList<Customer> customers=new ArrayList<Customer>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from customer");
			result=stmt.executeQuery();
			while(result.next()){
				Customer customer=new Customer();
				customer.setCid(result.getInt("cid"));
				customer.setUsername(result.getString("username"));
				customer.setPassword(result.getString("password"));
				customer.setName(result.getString("name"));
				customer.setAddress(result.getString("address"));
				customer.setAge(result.getInt("age"));
				customer.setPhone(result.getString("phone"));
				customer.setSex(result.getString("sex"));
				customer.setState(result.getString("state"));
				customer.setAccount(result.getDouble("account"));
				customer.setLevel(result.getInt("level"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return customers;
	}

	@Override
	public boolean alterCustomer(int cid, String password, String name,
			String address, String phone, int age, String sex) {
		// TODO Auto-generated method stub
		boolean ok=false;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		int result=0;
		try 
		{
			stmt=con.prepareStatement("update customer set password=?,name=?,address=?,phone=?,age=?,sex=? where cid=?");
			stmt.setString(1,password);
			stmt.setString(2, name);
			stmt.setString(3, address);
			stmt.setString(4, phone);
			stmt.setInt(5, age);
			stmt.setString(6, sex);
			stmt.setInt(7, cid);
			result=stmt.executeUpdate();
			if(result>0){
				ok=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return ok;
	}

	@Override
	public Customer getCustomer(int cid) {
		// TODO Auto-generated method stub
		Customer customer=null;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from customer where cid=?");
			stmt.setInt(1,cid);
			result=stmt.executeQuery();
			if(result.next()){
				customer=new Customer();
				customer.setCid(result.getInt("cid"));
				customer.setUsername(result.getString("username"));
				customer.setPassword(result.getString("password"));
				customer.setName(result.getString("name"));
				customer.setAddress(result.getString("address"));
				customer.setAge(result.getInt("age"));
				customer.setPhone(result.getString("phone"));
				customer.setSex(result.getString("sex"));
				customer.setAccount(result.getDouble("account"));
				customer.setState(result.getString("state"));
				customer.setLevel(result.getInt("level"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return customer;	
	}

	@Override
	public void shoppingCustomer(int cid, double money) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("update customer set account=account-? where cid=?");
			stmt.setDouble(1,money);
			stmt.setInt(2,cid);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
	}

	@Override
	public void updateCustomer(int cid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		double price=0;
		int level=1;
		try 
		{
			stmt=con.prepareStatement("select sum(price) from bill where cid=?");
			stmt.setInt(1, cid);
			result=stmt.executeQuery();
			if(result.next()){
				price=result.getDouble(1);
				level=(int) DiscountDaoImpl.getInnstance().getLevel(price);
				stmt=con.prepareStatement("update customer set level=? where cid=?");
				stmt.setInt(1, level);
				stmt.setInt(2, cid);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
	}
}
