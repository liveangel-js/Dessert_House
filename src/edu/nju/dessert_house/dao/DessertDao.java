package edu.nju.dessert_house.dao;

import java.util.ArrayList;

import sun.security.krb5.internal.crypto.Des;

import edu.nju.dessert_house.model.Dessert;

public interface DessertDao {
	
	public ArrayList<Dessert>getDessertList();
	
	public ArrayList<Dessert>getDessertListByType(String type);
	
	public ArrayList<Dessert>getDessertListByKey(String key);
	
	public Dessert getDessert(int did);
	
	public boolean alterDessert(int did,double price);
	
	public int addDessert(String name,double price,String type);

}
