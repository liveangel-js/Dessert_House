package edu.nju.dessert_house.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.dessert_house.dao.DaoHelper;
import edu.nju.dessert_house.dao.OrderDao;
import edu.nju.dessert_house.dao.RecordDao;
import edu.nju.dessert_house.model.Dessert;
import edu.nju.dessert_house.model.House;
import edu.nju.dessert_house.model.Order;
import edu.nju.dessert_house.model.Record;

public class OrderDaoIpml implements OrderDao {
	
	private DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	private static OrderDao orderDao=new OrderDaoIpml();
	
	private OrderDaoIpml(){
		
	}
	
	public static OrderDao getInstance(){
		return orderDao;
	}
	

	@Override
	public int addOrder(int cid, int sid, String time, double price,String type) {
		// TODO Auto-generated method stub
		//System.out.println(type);
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		int oid=0;
		try 
		{
			stmt=con.prepareStatement("insert into bill(cid,hid,time,price,type) values(?,?,?,?,?)");
			stmt.setInt(1, cid);
			stmt.setInt(2, sid);
			stmt.setString(3, time);
			stmt.setDouble(4, price);
			stmt.setString(5, type);
			//System.out.println(type);
			stmt.executeUpdate();
			stmt=con.prepareStatement("select LAST_INSERT_ID()");
			result=stmt.executeQuery();
			if(result.next()){
				oid=result.getInt(1);
			}
			//System.out.println(type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return oid;
	}

	@Override
	public double getTotalPrice(int hid) {
		// TODO Auto-generated method stub
		double price=0;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select sum(price) from bill where hid=?");
			stmt.setInt(1, hid);
			result=stmt.executeQuery();
			if(result.next()){
				price=result.getDouble(1);
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
		return price;
	}

	@Override
	public ArrayList<House> getHouseTotal() {
		// TODO Auto-generated method stub
		ArrayList<House>houses=new ArrayList<House>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select house.name,sum(bill.price) as t from house left join bill on house.hid=bill.hid group by house.hid");
			result=stmt.executeQuery();
			while(result.next()){
				House house=new House();
				house.setName(result.getString(1));
				house.setTotal(result.getDouble(2));
				houses.add(house);
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
		return houses;
	}

	@Override
	public ArrayList<Order> getOrderList(int cid) {
		// TODO Auto-generated method stub
		RecordDao recordDao=RecordDaoImpl.getInstance();
		ArrayList<Order>orders=new ArrayList<Order>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from bill where cid=?");
			stmt.setInt(1, cid);
			result=stmt.executeQuery();
			while(result.next()){
				Order order=new Order();
				order.setOid(result.getInt("oid"));
				order.setPrice(result.getDouble("price"));
				order.setTime(result.getString("time"));
				order.setHid(result.getInt("hid"));
				order.setType(result.getString("type"));
				order.setRecord_list(recordDao.getRecords(result.getInt("oid")));
				orders.add(order);
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
		return orders;
	}

	@Override
	public double getTotalPriceForCustomer(int cid) {
		// TODO Auto-generated method stub
		double price=0;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select sum(price) from bill where cid=?");
			stmt.setInt(1, cid);
			result=stmt.executeQuery();
			if(result.next()){
				price=result.getDouble(1);
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
		return price;
	}
	

}
