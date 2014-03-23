package edu.nju.dessert_house.factory;

import edu.nju.dessert_house.service.DessertService;
import edu.nju.dessert_house.service.UserService;
import edu.nju.dessert_house.service.impl.DessertServiceImpl;
import edu.nju.dessert_house.service.impl.UserServiceImpl;

public class ServiceFactory {
	
	
	public static UserService getUserService(){
		return UserServiceImpl.getInstance();
	}
	
	public static DessertService getDessertService(){
		return DessertServiceImpl.getInstance();
	}

}
