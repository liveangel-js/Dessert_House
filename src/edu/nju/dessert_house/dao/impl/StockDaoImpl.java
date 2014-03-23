package edu.nju.dessert_house.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.dessert_house.dao.DaoHelper;
import edu.nju.dessert_house.dao.DessertDao;
import edu.nju.dessert_house.dao.StockDao;
import edu.nju.dessert_house.model.Discount;
import edu.nju.dessert_house.model.Stock;

public class StockDaoImpl implements StockDao{
	
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	private static DessertDao dessertDao=DessertDaoImpl.getInstance();
	private static StockDao stockDao=new StockDaoImpl();
	
	public static StockDao getInstance(){
		return stockDao;
	}

	@Override
	public ArrayList<Stock> getStockList(int hid) {
		// TODO Auto-generated method stub
		ArrayList<Stock>list=new ArrayList<Stock>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from stock where hid=?");
			stmt.setInt(1, hid);
			result=stmt.executeQuery();
			while(result.next()){
				Stock stock=new Stock();
				stock.setSid(result.getInt("sid"));
				stock.setNumber(result.getInt("number"));
				stock.setDessert(dessertDao.getDessert(result.getInt("did")));
				list.add(stock);
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
		return list;
	}

	@Override
	public boolean alertStock(int sid, int number) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		boolean result=false;
		try 
		{
			stmt=con.prepareStatement("update stock set number=? where sid=?");
			stmt.setInt(1,number);
			stmt.setInt(2,sid);
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
	public int getDessertID(int sid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		int id=0;
		try 
		{
			stmt=con.prepareStatement("select * from stock where sid=?");
			stmt.setInt(1, sid);
			result=stmt.executeQuery();
			if(result.next()){
				id=result.getInt("did");
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
		return id;
	}

	@Override
	public void decreaseStock(int did, int number) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		boolean result=false;
		try 
		{
			stmt=con.prepareStatement("update stock set number=number-? where did=?");
			stmt.setInt(1,number);
			stmt.setInt(2,did);
			int row=stmt.executeUpdate();
			if(row>0){
				//result=true;
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
		return;
	}

	@Override
	public int getStock(int did, int hid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		int stock=0;
		try 
		{
			stmt=con.prepareStatement("select * from stock where hid=? AND did=?");
			stmt.setInt(1, hid);
			stmt.setInt(2, did);
			result=stmt.executeQuery();
			if(result.next()){
				stock=result.getInt("number");
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
		return stock;
	}

	@Override
	public void addStock(int hid, int did, int number) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("insert into stock(hid,did,number) values(?,?,?)");
			stmt.setInt(1, hid);
			stmt.setInt(2, did);
			stmt.setInt(3, number);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return;
	}
}
