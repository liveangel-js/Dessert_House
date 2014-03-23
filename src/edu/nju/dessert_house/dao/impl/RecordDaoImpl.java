package edu.nju.dessert_house.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.dessert_house.dao.DaoHelper;
import edu.nju.dessert_house.dao.DessertDao;
import edu.nju.dessert_house.dao.OrderDao;
import edu.nju.dessert_house.dao.RecordDao;
import edu.nju.dessert_house.model.House;
import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.model.SellRecord;

public class RecordDaoImpl implements RecordDao {

	
	private DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	private static RecordDao recordDao=new RecordDaoImpl();
	private static DessertDao dessertDao=DessertDaoImpl.getInstance();
	
	private RecordDaoImpl(){
		
	}
	
	public static RecordDao getInstance(){
		return recordDao;
	}
	
	
	
	@Override
	public int addRecord(int did, int number, int oid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		int result=0;
		try 
		{
			stmt=con.prepareStatement("insert into record(did,number,oid) values(?,?,?)");
			stmt.setInt(1, did);
			stmt.setInt(2, number);
			stmt.setInt(3, oid);
			result=stmt.executeUpdate();
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
	public ArrayList<Record> getRecords(int oid) {
		// TODO Auto-generated method stub
		ArrayList<Record> records=new ArrayList<Record>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from record where oid=?");
			stmt.setInt(1, oid);
			result=stmt.executeQuery();
			while(result.next()){
				Record record=new Record();
				record.setNumber(result.getInt("number"));
				record.setDid(result.getInt("did"));
				record.setDessert(dessertDao.getDessert(result.getInt("did")));
				records.add(record);
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
		return records;
	}

	@Override
	public ArrayList<Record> getRecordsByNumber() {
		// TODO Auto-generated method stub
		ArrayList<Record> records=new ArrayList<Record>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select sum(number) as s,did from record  GROUP BY did order by s desc");
			result=stmt.executeQuery();
			while(result.next()){
				Record record=new Record();
				record.setNumber(result.getInt("s"));
				record.setDid(result.getInt("did"));
				record.setDessert(dessertDao.getDessert(result.getInt("did")));
				records.add(record);
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
		return records;
	}

	@Override
	public ArrayList<SellRecord> getRecordsByHouse(int hid) {
		// TODO Auto-generated method stub
		ArrayList<SellRecord> records=new ArrayList<SellRecord>();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from dessert");
			result=stmt.executeQuery();
			while(result.next()){
				SellRecord record=new SellRecord();
				record.setSell(getNumberSell(hid,result.getInt("did")));
				record.setOrder(getNumberOrder(hid,result.getInt("did")));
				record.setNumber(record.getOrder()+record.getSell());
				record.setDid(result.getInt("did"));
				record.setDessert(dessertDao.getDessert(result.getInt("did")));
				records.add(record);
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
		return records;
	}
	
	public int getNumberSell(int hid,int did) {
		int number=0;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select sum(record.number) from record right join dessert on dessert.did=record.did left join bill on bill.oid=record.oid where bill.type='œ˙ €' AND dessert.did=? AND bill.hid=?");
			stmt.setInt(1, did);
			stmt.setInt(2, hid);
			result=stmt.executeQuery();
			if(result.next()){
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
	
	public int getNumberOrder(int hid,int did) {
		int number=0;
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select sum(record.number) from record right join dessert on dessert.did=record.did left join bill on bill.oid=record.oid where bill.type='‘§∂©' AND dessert.did=? AND bill.hid=?");
			stmt.setInt(1, did);
			stmt.setInt(2, hid);
			result=stmt.executeQuery();
			if(result.next()){
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
}
