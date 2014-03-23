package edu.nju.dessert_house.service.impl;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.dessert_house.dao.OrderDao;
import edu.nju.dessert_house.dao.impl.DiscountDaoImpl;
import edu.nju.dessert_house.dao.impl.OrderDaoIpml;
import edu.nju.dessert_house.dao.impl.RecordDaoImpl;
import edu.nju.dessert_house.dao.impl.StockDaoImpl;
import edu.nju.dessert_house.dao.impl.UserDaoImpl;
import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.model.user.Customer;
import edu.nju.dessert_house.service.OrderService;

public class OrderSerivceImpl implements OrderService {
	
	private static OrderService orderService=new OrderSerivceImpl();
	
	public static OrderService getInstance(){
		return orderService;
	}
	
	

	@Override
	public void makeOrder(int cid, ArrayList<Record> records, int hid,
			String type) {
		// TODO Auto-generated method stub
		OrderDao orderDao=OrderDaoIpml.getInstance();
		double price=0;
		Customer c=UserDaoImpl.getInstance().getCustomer(cid);
		double discount=DiscountDaoImpl.getInnstance().getDiscount(c.getLevel());
		
		for(int i=0;i<records.size();i++){
			Record r=records.get(i);
			price+=r.getDessert().getPrice()*r.getNumber();
		}
		
		price*=discount;
		
		UserDaoImpl.getInstance().shoppingCustomer(cid, price);
		
		int oid=orderDao.addOrder(cid, hid, getTime(), price, type);
		
		for(int i=0;i<records.size();i++){
			Record r=records.get(i);
			RecordDaoImpl.getInstance().addRecord(r.getDessert().getDid(), r.getNumber(), oid);
		}
		
		UserDaoImpl.getInstance().updateCustomer(cid);
	}
	
	
	private String getTime(){
		Format format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(Calendar.getInstance().getTime());
        return date;
	}



	@Override
	public double getOrderPrice(ArrayList<Record> records) {
		// TODO Auto-generated method stub
		double price=0;

		for(int i=0;i<records.size();i++){
			Record r=records.get(i);
			price+=r.getDessert().getPrice()*r.getNumber();
		}
		return price;
	}



	@Override
	public double getOrderPriceForDiscount(int cid, ArrayList<Record> records) {
		// TODO Auto-generated method stub
		//OrderDao orderDao=OrderDaoIpml.getInstance();
		double price=0;
		Customer c=UserDaoImpl.getInstance().getCustomer(cid);
		double discount=DiscountDaoImpl.getInnstance().getDiscount(c.getLevel());
		
		for(int i=0;i<records.size();i++){
			Record r=records.get(i);
			price+=r.getDessert().getPrice()*r.getNumber();
		}
		//System.out.println(discount);
		price*=discount;
		return price;
	}



	@Override
	public void makeSell(int cid, ArrayList<Record> records, int hid,
			String type) {
		// TODO Auto-generated method stub
		OrderDao orderDao=OrderDaoIpml.getInstance();
		double price=0;
		Customer c=UserDaoImpl.getInstance().getCustomer(cid);
		double discount=DiscountDaoImpl.getInnstance().getDiscount(c.getLevel());
		
		for(int i=0;i<records.size();i++){
			Record r=records.get(i);
			price+=r.getDessert().getPrice()*r.getNumber();
		}
		
		price*=discount;
		
		UserDaoImpl.getInstance().shoppingCustomer(cid, price);
		
		int oid=orderDao.addOrder(cid, hid, getTime(), price, type);
		
		for(int i=0;i<records.size();i++){
			Record r=records.get(i);
			RecordDaoImpl.getInstance().addRecord(r.getDessert().getDid(), r.getNumber(), oid);
			StockDaoImpl.getInstance().decreaseStock(r.getDessert().getDid(), r.getNumber());
		}
		UserDaoImpl.getInstance().updateCustomer(cid);
	}
}
