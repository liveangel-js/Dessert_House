package edu.nju.dessert_house.factory;

import edu.nju.dessert_house.dao.DessertDao;
import edu.nju.dessert_house.dao.UserDao;
import edu.nju.dessert_house.dao.impl.DessertDaoImpl;
import edu.nju.dessert_house.dao.impl.UserDaoImpl;
import edu.nju.dessert_house.service.impl.DessertServiceImpl;

public class DaoFactory {
	
	
	public static UserDao getUserDao(){
		return UserDaoImpl.getInstance();
	}
	
	public static DessertDao getDessertDao(){
		return DessertDaoImpl.getInstance();
	}
}
