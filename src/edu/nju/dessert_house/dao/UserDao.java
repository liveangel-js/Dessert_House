package edu.nju.dessert_house.dao;

import java.util.ArrayList;

import edu.nju.dessert_house.model.user.Clerk;
import edu.nju.dessert_house.model.user.Customer;
import edu.nju.dessert_house.model.user.Manager;


public interface UserDao {
	
	public Customer getCustomer(String username,String password);
	
	public Clerk getClerk(String username,String password);
	
	public Manager getManager(String username,String password);
	
	public boolean verifyAdmin(String username,String password);
	
	public Customer registerCustomer(String username,String password);

	public boolean alterCustomer(int cid,String password,String name,String address,String phone,int age,String sex);
	
	public ArrayList<Clerk>getClerks();
	
	public boolean alterClerkHouse(int cid,int hid);
	
	public ArrayList<Manager>getManagers();
	
	public boolean addClerk(String username,String password,String name,String address,String sex,String phone,int age,int hid);
	
	public boolean addManager(String username,String password,String name,String address,String sex,String phone,int age);

	public ArrayList<Customer>getCustomers();
	
	public Customer getCustomer(int cid);
	
	public void shoppingCustomer(int cid,double money);
	
	public void updateCustomer(int cid);
}
