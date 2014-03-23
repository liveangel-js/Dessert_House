package edu.nju.dessert_house.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import edu.nju.dessert_house.dao.CardDao;
import edu.nju.dessert_house.dao.DaoHelper;
import edu.nju.dessert_house.model.user.Customer;

public class CardDaoImpl implements CardDao {
	
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	private static CardDao cardDao=new CardDaoImpl();
	
	public static CardDao getInstance(){
		return cardDao;
	}

	@Override
	public void startCard(int cid) {
		// TODO Auto-generated method stub
		RechargeDaoImpl.getInstance().addRecharge(100,getTime(), "激活", cid);
		alterCard(0, cid,"激活");
	}

	@Override
	public void stopCard(int cid) {
		// TODO Auto-generated method stub
		alterCard(0,cid,"停止");
	}

	@Override
	public void rechargeCard(double number, int cid) {
		// TODO Auto-generated method stub
		RechargeDaoImpl.getInstance().addRecharge(number,getTime(), "充值", cid);
		alterCard(number, cid,"激活");
	}
	
	
	
	private void alterCard(double number,int cid,String type){
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("update customer set account=account+?,state=?,time=? where cid=?");
			stmt.setDouble(1,number);
			stmt.setString(2, type);
			stmt.setString(3, getTime());
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
	
	private String getTime(){
		Format format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(Calendar.getInstance().getTime());
        return date;
	}
}
