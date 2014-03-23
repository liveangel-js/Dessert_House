package edu.nju.dessert_house.dao;

import java.util.ArrayList;

import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.model.SellRecord;

public interface RecordDao {
	
	public int addRecord(int did,int number,int oid);
	
	public ArrayList<Record> getRecords(int oid);
	
	public ArrayList<Record> getRecordsByNumber();
	
	public ArrayList<SellRecord> getRecordsByHouse(int hid);

}
