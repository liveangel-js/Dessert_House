package edu.nju.dessert_house.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.dessert_house.dao.DaoHelper;
import edu.nju.dessert_house.dao.RechargeDao;
import edu.nju.dessert_house.dao.RecordDao;
import edu.nju.dessert_house.model.Order;
import edu.nju.dessert_house.model.Recharge;

public class RechargeDaoImpl implements RechargeDao {
	
	private DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	private static RechargeDao rechargeDao=new RechargeDaoImpl();
	
	
	public static RechargeDao getInstance(){
		return rechargeDao;
	}
	

	@Override
	public ArrayList<Recharge> getRechargeList(int cid) {
		// TODO Auto-generated method stub
		ArrayList<Recharge>recharges=new ArrayList<Recharge>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from recharge where cid=?");
			stmt.setInt(1, cid);
			result=stmt.executeQuery();
			while(result.next()){
				Recharge recharge=new Recharge();
				recharge.setRid(result.getInt("rid"));
				recharge.setNumber(result.getDouble("number"));
				recharge.setTime(result.getString("time"));
				recharge.setType(result.getString("type"));
				recharges.add(recharge);
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
		return recharges;
	}


	@Override
	public double getRechargeTotal(int cid) {
		// TODO Auto-generated method stub
		double total=0;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select sum(number) from recharge where cid=?");
			stmt.setInt(1, cid);
			result=stmt.executeQuery();
			if(result.next()){
				total=result.getDouble(1);
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
		return total;
	}


	@Override
	public void addRecharge(double number, String time, String type, int cid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("insert into recharge(number,time,type,cid) values(?,?,?,?)");
			stmt.setDouble(1, number);
			stmt.setString(2, time);
			stmt.setString(3, type);
			stmt.setInt(4, cid);
			int ok=stmt.executeUpdate();
			if(ok>0){
				
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
}
