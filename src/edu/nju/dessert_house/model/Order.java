package edu.nju.dessert_house.model;

import java.util.ArrayList;

public class Order {
	
	private int oid;
	private int cid;
	private int hid;
	private String time;
	private double price;
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private ArrayList<Record>record_list=new ArrayList<Record>();
	
	
	public ArrayList<Record> getRecord_list() {
		return record_list;
	}
	public void setRecord_list(ArrayList<Record> record_list) {
		this.record_list = record_list;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
