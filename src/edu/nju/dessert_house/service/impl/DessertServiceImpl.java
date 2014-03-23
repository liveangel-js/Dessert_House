package edu.nju.dessert_house.service.impl;

import java.util.ArrayList;

import edu.nju.dessert_house.dao.DessertDao;
import edu.nju.dessert_house.dao.impl.StockDaoImpl;
import edu.nju.dessert_house.factory.DaoFactory;
import edu.nju.dessert_house.model.Dessert;
import edu.nju.dessert_house.model.Record;
import edu.nju.dessert_house.service.DessertService;

public class DessertServiceImpl implements DessertService {
	
	private DessertDao dessertDao=DaoFactory.getDessertDao();
	private static DessertService dessertService=new DessertServiceImpl();
	
	
	public static DessertService getInstance(){
		return dessertService;
	}
	
	private DessertServiceImpl(){
		
	}
	
	@Override
	public ArrayList<Dessert> getDessertList() {
		// TODO Auto-generated method stub
		return dessertDao.getDessertList();
	}

	@Override
	public ArrayList<Dessert> getDessertListByType(String type) {
		// TODO Auto-generated method stub
		return dessertDao.getDessertListByType(type);
	}

	@Override
	public ArrayList<Dessert> getDessertListByKey(String key) {
		// TODO Auto-generated method stub
		return dessertDao.getDessertListByKey(key);
	}

	@Override
	public Dessert getDessert(int did) {
		// TODO Auto-generated method stub
		return dessertDao.getDessert(did);
	}

	@Override
	public void addDessert(int did, int number, ArrayList<Record> cart) {
		// TODO Auto-generated method stub
		for(int i=0;i<cart.size();i++){
			Record record=cart.get(i);
			if(record.getDessert().getDid()==did){
				record.setNumber(number+record.getNumber());
				return;
			}
		}
		Dessert dessert=dessertDao.getDessert(did);
		Record r=new Record();
		r.setDessert(dessert);
		r.setNumber(number);
		cart.add(r);
	}

	@Override
	public boolean isStaockEnough(int did, int number, ArrayList<Record> cart,
			int hid) {
		// TODO Auto-generated method stub
		for(int i=0;i<cart.size();i++){
			Record record=cart.get(i);
			if(record.getDessert().getDid()==did){
				if(record.getNumber()+number>StockDaoImpl.getInstance().getStock(did, hid)){
					return false;
				}else{
					return true;
				}
			}
		}
		if(number>StockDaoImpl.getInstance().getStock(did, hid)){
			return false;
		}else{
			return true;
		}
	}
}
