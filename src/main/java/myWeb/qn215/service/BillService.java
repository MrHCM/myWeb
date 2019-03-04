package myWeb.qn215.service;

import java.util.List;


import myWeb.qn215.entity.Bill;
import myWeb.qn215.entity.Fenye;
import myWeb.qn215.entity.Provider;



public interface BillService {
	
	
	
	public List<Bill> selectBill(Bill bi);
	public List<Bill> selectBillFeny(Bill bi);
	public List<Bill> selectID(Bill bi);
	
	public List<Provider> selectprovider();
	
	public boolean add(Bill bi);
}
