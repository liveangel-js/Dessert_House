package edu.nju.dessert_house.dao;

import java.util.ArrayList;

import edu.nju.dessert_house.model.Recharge;

public interface RechargeDao {
	
	public ArrayList<Recharge>getRechargeList(int cid);
	
	public double getRechargeTotal(int cid);
	
	public void addRecharge(double number,String time,String type,int cid);
}
