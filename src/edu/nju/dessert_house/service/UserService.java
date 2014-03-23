package edu.nju.dessert_house.service;

import edu.nju.dessert_house.model.user.Clerk;
import edu.nju.dessert_house.model.user.Customer;
import edu.nju.dessert_house.model.user.Manager;


public interface UserService {
	
	public Customer getCustomer(String username,String password);
	
	public Clerk getClerk(String username,String password);
	
	public Manager getManager(String username,String password);
	
	public boolean verifyAdmin(String username,String password);
	
	

}
