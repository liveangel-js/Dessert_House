package edu.nju.dessert_house.model;

public class SellRecord extends Record {
	
	private int sell;
	private int order;
	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
		this.sell = sell;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
}
