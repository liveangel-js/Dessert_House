package edu.nju.dessert_house.service;

import java.util.ArrayList;
import edu.nju.dessert_house.model.Dessert;
import edu.nju.dessert_house.model.Record;


public interface DessertService {
	
	public ArrayList<Dessert>getDessertList();
	
	public ArrayList<Dessert>getDessertListByType(String type);
	
	public ArrayList<Dessert>getDessertListByKey(String key);
	
	public Dessert getDessert(int did);
	
	public void addDessert(int did,int number,ArrayList<Record>cart);
	
	public boolean isStaockEnough(int did,int number,ArrayList<Record>cart,int hid);

}
