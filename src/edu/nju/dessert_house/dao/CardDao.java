package edu.nju.dessert_house.dao;

public interface CardDao {
	
	public void startCard(int cid);
	
	
	public void stopCard(int cid);
	
	
	public void rechargeCard(double number,int cid);

}
