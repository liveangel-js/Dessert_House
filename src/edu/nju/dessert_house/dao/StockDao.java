package edu.nju.dessert_house.dao;

import java.util.ArrayList;

import edu.nju.dessert_house.model.Stock;

public interface StockDao {
	
	public ArrayList<Stock>getStockList(int hid);
	
	public boolean alertStock(int sid,int number);
	
	public int getDessertID(int sid);
	
	public void decreaseStock(int did,int number);
	
	public int getStock(int did,int hid);
	
	public void addStock(int hid,int did,int number);

}
