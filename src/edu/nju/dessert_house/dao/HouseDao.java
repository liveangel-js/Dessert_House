package edu.nju.dessert_house.dao;

import java.util.ArrayList;

import edu.nju.dessert_house.model.House;

public interface HouseDao {
	
	public House getHouse(int hid);
	
	public ArrayList<House>getHouses();
	
	public boolean addHouse(String name,String address,String phone);

}
