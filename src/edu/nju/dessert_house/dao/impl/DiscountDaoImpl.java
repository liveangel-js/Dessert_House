package edu.nju.dessert_house.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.dessert_house.dao.DaoHelper;
import edu.nju.dessert_house.dao.DiscountDao;
import edu.nju.dessert_house.model.Discount;
import edu.nju.dessert_house.model.user.Customer;

public class DiscountDaoImpl implements DiscountDao {
	
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	private static DiscountDao discountDao=new DiscountDaoImpl();
	
	
	public static DiscountDao getInnstance(){
		return discountDao;
	}
	

	@Override
	public ArrayList<Discount> getDiscountList() {
		// TODO Auto-generated method stub
		ArrayList<Discount>list=new ArrayList<Discount>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from discount");
			result=stmt.executeQuery();
			while(result.next()){
				Discount discount=new Discount();
				discount.setDid(result.getInt("did"));
				discount.setDiscount(result.getDouble("discount"));
				discount.setLevel(result.getInt("level"));
				discount.setMoney(result.getDouble("money"));
				list.add(discount);
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
	public boolean setDiscountList(ArrayList<Discount> list) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++){
			setDiscount(list.get(i));
		}
		return true;
	}
	
	
	public boolean setDiscount(Discount d){
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		boolean result=false;
		try 
		{
			stmt=con.prepareStatement("update discount set discount=?,money=? where level=?");
			stmt.setDouble(1,d.getDiscount());
			stmt.setDouble(2,d.getMoney());
			stmt.setInt(3,d.getLevel());
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
	public double getDiscount(int level) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		double discount=1;
		try 
		{
			stmt=con.prepareStatement("select * from discount where level=?");
			stmt.setInt(1,level);
			result=stmt.executeQuery();
			if(result.next()){
				discount=result.getDouble("discount");
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
		return discount;
	}


	@Override
	public int getLevel(double money) {
		// TODO Auto-generated method stub
		if(money>=getMaxPrice()){
			//System.out.println("level:"+getMaxLevel());
			return getMaxLevel();
		}
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		int level=0;
		try 
		{
			stmt=con.prepareStatement("select max(level) from discount where money<=?");
			stmt.setDouble(1, money);
			result=stmt.executeQuery();
			if(result.next()){
				level=result.getInt(1);
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
		///System.out.println("level:"+level);
		return level;
	}


	@Override
	public double getMaxPrice() {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		double price=0;
		try 
		{
			stmt=con.prepareStatement("select max(money) from discount");
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
	

	public int getMaxLevel() {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		int level=0;
		try 
		{
			stmt=con.prepareStatement("select max(level) from discount");
			result=stmt.executeQuery();
			if(result.next()){
				level=result.getInt(1);
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
		return level;
	}
}
