package edu.nju.dessert_house.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

import edu.nju.dessert_house.dao.DaoHelper;
import edu.nju.dessert_house.dao.impl.DaoHelperImpl;


public class AutoCheckTask extends TimerTask {
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	
	public void updateCustomer(){
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("update customer set state='ÔÝÍ£',time=? where state='¼¤»î' AND time<?");
			stmt.setString(1,getTimeNow());
			stmt.setString(2,getTimeOneYearBefore());
			stmt.executeUpdate();
			stmt=con.prepareStatement("update customer set state='Í£Ö¹',time=? where state='ÔÝÍ£' AND time<?");
			stmt.setString(1,getTimeNow());
			stmt.setString(2,getTimeOneYearBefore());
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
		return;
	}
	
	private String getTimeNow(){
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c=Calendar.getInstance();
        String date = format.format(c.getTime());
        return date;
	}
	private String getTimeOneYearBefore(){
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		c.set(Calendar.YEAR, year-1);
        String date = format.format(c.getTime());
        return date;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		updateCustomer();
	}

}
