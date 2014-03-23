package edu.nju.dessert_house.service.impl;

import edu.nju.dessert_house.dao.UserDao;
import edu.nju.dessert_house.factory.DaoFactory;
import edu.nju.dessert_house.model.user.Clerk;
import edu.nju.dessert_house.model.user.Customer;
import edu.nju.dessert_house.model.user.Manager;
import edu.nju.dessert_house.service.UserService;



public class UserServiceImpl implements UserService {
	
	private UserDao userDao=DaoFactory.getUserDao();
	private static UserService userService=new UserServiceImpl();
	
	
	private UserServiceImpl(){
		
	}
	
	public static UserService getInstance(){
		return userService;
	}
	

	@Override
	public Customer getCustomer(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.getCustomer(username, password);
	}

	@Override
	public Clerk getClerk(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.getClerk(username, password);
	}

	@Override
	public Manager getManager(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.getManager(username, password);
	}

	@Override
	public boolean verifyAdmin(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.verifyAdmin(username, password);
	}


}
