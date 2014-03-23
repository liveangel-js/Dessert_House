package edu.nju.dessert_house.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.dessert_house.dao.DaoHelper;
import edu.nju.dessert_house.dao.DiscountDao;
import edu.nju.dessert_house.dao.HouseDao;
import edu.nju.dessert_house.dao.StockDao;
import edu.nju.dessert_house.model.Dessert;
import edu.nju.dessert_house.model.Discount;
import edu.nju.dessert_house.model.House;

public class HouseDaoImpl implements HouseDao {
	
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	private static HouseDao houseDao=new HouseDaoImpl();
	
	
	public static HouseDao getInnstance(){
		return houseDao;
	}
	
	
	

	@Override
	public House getHouse(int hid) {
		// TODO Auto-generated method stub
		House house=null;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from house where hid=?");
			stmt.setInt(1,hid);
			result=stmt.executeQuery();
			if(result.next()){
				house=new House();
				house.setHid(hid);
				house.setName(result.getString("name"));
				house.setAddress(result.getString("address"));
				house.setPhone(result.getString("phone"));
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
		return house;	
	}




	@Override
	public ArrayList<House> getHouses() {
		// TODO Auto-generated method stub
		ArrayList<House> houses=new ArrayList<House>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from house");
			result=stmt.executeQuery();
			while(result.next()){
				House house=new House();
				house.setHid(result.getInt("hid"));
				house.setName(result.getString("name"));
				house.setAddress(result.getString("address"));
				house.setPhone(result.getString("phone"));
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
	public boolean addHouse(String name, String address, String phone) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		int row;
		boolean ok=false;
		try 
		{
			stmt=con.prepareStatement("insert into house(name,address,phone) values(?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, address);
			stmt.setString(3, phone);
			row=stmt.executeUpdate();
			if(row>0){
				ok=true;
				stmt=con.prepareStatement("select LAST_INSERT_ID()");
				int hid=0;
				result=stmt.executeQuery();
				if(result.next()){
					hid=result.getInt(1);
				}
				addStock(hid);
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
		return ok;
	}
	
	
	private void addStock(int hid){
		ArrayList<Dessert> desserts=DessertDaoImpl.getInstance().getDessertList();
		StockDao stockDao=StockDaoImpl.getInstance();
		for(int i=0;i<desserts.size();i++){
			Dessert d=desserts.get(i);
			stockDao.addStock(hid, d.getDid(), 0);
		}
	}
}
