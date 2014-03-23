package edu.nju.dessert_house.dao;

import java.util.ArrayList;

import edu.nju.dessert_house.model.Discount;

public interface DiscountDao {
	
	public ArrayList<Discount>getDiscountList();
	
	public boolean setDiscountList(ArrayList<Discount>list);
	
	public double getDiscount(int level);
	
	public boolean setDiscount(Discount d);
	
	public int getLevel(double money);
	
	public double getMaxPrice();

}
