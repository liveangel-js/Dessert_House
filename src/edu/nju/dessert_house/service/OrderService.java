package edu.nju.dessert_house.service;

import java.util.ArrayList;

import edu.nju.dessert_house.model.Record;

public interface OrderService {

	public void makeOrder(int cid,ArrayList<Record>records,int hid,String type);
	
	public double getOrderPrice(ArrayList<Record>records);
	
	public double getOrderPriceForDiscount(int cid,ArrayList<Record>records);
	
	public void makeSell(int cid,ArrayList<Record>records,int hid,String type);
}
