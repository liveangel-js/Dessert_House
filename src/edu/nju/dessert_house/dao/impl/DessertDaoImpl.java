package edu.nju.dessert_house.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import edu.nju.dessert_house.dao.DaoHelper;
import edu.nju.dessert_house.dao.DessertDao;
import edu.nju.dessert_house.dao.StockDao;
import edu.nju.dessert_house.model.Dessert;
import edu.nju.dessert_house.model.House;



public class DessertDaoImpl implements DessertDao {

	private static DessertDaoImpl dessertDao=new DessertDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	
	public static DessertDaoImpl getInstance(){
		return dessertDao;
	}
	
	
	@Override
	public ArrayList<Dessert> getDessertList() {
		// TODO Auto-generated method stub
		ArrayList<Dessert>dessert_list=new ArrayList<Dessert>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from dessert");
			result=stmt.executeQuery();
			while(result.next()){
				Dessert dessert=new Dessert();
				dessert.setDid(result.getInt("did"));
				dessert.setName(result.getString("name"));
				dessert.setPrice(result.getDouble("price"));
				dessert.setType(result.getString("type"));
				dessert_list.add(dessert);
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
		return dessert_list;
	}


	@Override
	public ArrayList<Dessert> getDessertListByType(String type) {
		// TODO Auto-generated method stub
		ArrayList<Dessert>dessert_list=new ArrayList<Dessert>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from dessert where type=?");
			stmt.setString(1, type);
			result=stmt.executeQuery();
			while(result.next()){
				//System.out.println(result.getInt("did"));
				Dessert dessert=new Dessert();
				dessert.setDid(result.getInt("did"));
				dessert.setName(result.getString("name"));
				dessert.setPrice(result.getDouble("price"));
				dessert_list.add(dessert);
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
		return dessert_list;
	}
	
	
	
	public ArrayList<Dessert> getDessertListByType(String type,int page,String sort) {
		ArrayList<Dessert>dessert_list=new ArrayList<Dessert>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from dessert where type=? order by ? DESC LIMIT 1,10");
			stmt.setString(1, type);
			stmt.setString(2, "did");
			result=stmt.executeQuery();
			while(result.next()){
				//System.out.println(result.getInt("did"));
				Dessert dessert=new Dessert();
				dessert.setDid(result.getInt("did"));
				dessert.setName(result.getString("name"));
				dessert.setPrice(result.getDouble("price"));
				dessert_list.add(dessert);
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
		return dessert_list;
	}
	
	


	@Override
	public ArrayList<Dessert> getDessertListByKey(String key) {
		// TODO Auto-generated method stub
		ArrayList<Dessert>dessert_list=new ArrayList<Dessert>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from dessert where name REGEXP ?");
			stmt.setString(1, key);
			result=stmt.executeQuery();
			while(result.next()){
				Dessert dessert=new Dessert();
				dessert.setDid(result.getInt("did"));
				dessert.setName(result.getString("name"));
				dessert.setPrice(result.getDouble("price"));
				dessert_list.add(dessert);
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
		return dessert_list;
	}


	@Override
	public Dessert getDessert(int did) {
		// TODO Auto-generated method stub
		Dessert dessert=null;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from dessert where did=?");
			stmt.setInt(1, did);
			result=stmt.executeQuery();
			if(result.next()){
				dessert=new Dessert();
				dessert.setDid(result.getInt("did"));
				dessert.setName(result.getString("name"));
				dessert.setPrice(result.getDouble("price"));
				dessert.setType(result.getString("type"));
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
		return dessert;
	}


	@Override
	public boolean alterDessert(int did, double price) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		boolean result=false;
		try 
		{
			stmt=con.prepareStatement("update dessert set price=? where did=?");
			stmt.setDouble(1,price);
			stmt.setInt(2,did);
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
	public int addDessert(String name, double price, String type) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		int row;
		int did=0;
		boolean ok=false;
		try 
		{
			stmt=con.prepareStatement("insert into dessert(name,price,type) values(?,?,?)");
			stmt.setString(1, name);
			stmt.setDouble(2, price);
			stmt.setString(3, type);
			row=stmt.executeUpdate();
			if(row>0){
				ok=true;
				stmt=con.prepareStatement("select LAST_INSERT_ID()");
				result=stmt.executeQuery();
				if(result.next()){
					did=result.getInt(1);
				}
				addStock(did);
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
		return did;
	}
	
	private void addStock(int did){
		ArrayList<House> houses=HouseDaoImpl.getInnstance().getHouses();
		StockDao stockDao=StockDaoImpl.getInstance();
		for(int i=0;i<houses.size();i++){
			House h=houses.get(i);
			stockDao.addStock(h.getHid(),did , 0);
		}
	}
	
	
	public int getDessertNumber(String sql) {
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		int number=0;
		try 
		{
			stmt=con.prepareStatement(sql);
			result=stmt.executeQuery();
			while(result.next()){
				//System.out.println(result.getInt("did"));
				number=result.getInt(1);
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
		return number;
	}
	
	
	public ArrayList<Dessert> getDessertList(String sql) {
		ArrayList<Dessert>dessert_list=new ArrayList<Dessert>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement(sql);
			result=stmt.executeQuery();
			while(result.next()){
				//System.out.println(result.getInt("did"));
				Dessert dessert=new Dessert();
				dessert.setDid(result.getInt("did"));
				dessert.setName(result.getString("name"));
				dessert.setPrice(result.getDouble("price"));
				dessert_list.add(dessert);
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
		return dessert_list;
	}
}
