package edu.nju.dessert_house.model;

import java.util.ArrayList;


public class House {
	private int hid;
	private String name;
	private String address;
	private String phone;
	private double total;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	private ArrayList<Stock>stock_list=new ArrayList<Stock>();
	
	public ArrayList<Stock> getStock_list() {
		return stock_list;
	}
	public void setStock_list(ArrayList<Stock> stock_list) {
		this.stock_list = stock_list;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
