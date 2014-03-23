package edu.nju.dessert_house.dao;

import java.util.ArrayList;

import edu.nju.dessert_house.model.House;
import edu.nju.dessert_house.model.Order;

public interface OrderDao {
	
	public int addOrder(int cid,int sid,String time,double price,String type);
	
	public double getTotalPrice(int hid);
	
	public ArrayList<House>getHouseTotal();
	
	public ArrayList<Order>getOrderList(int cid);
	
	public double getTotalPriceForCustomer(int cid);

}
