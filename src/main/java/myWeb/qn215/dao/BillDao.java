package myWeb.qn215.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import myWeb.qn215.entity.Bill;
import myWeb.qn215.entity.Provider;

public interface BillDao {
	
	
	public List<Bill> selectBill(Bill bi);
	
	public List<Bill> selectBillFeny(Bill bill);
	
	public List<Bill> selectID(Bill bi);
	
	public List<Bill> selectfeny();
	
	public List<Provider> selectprovider();
	
	public int add(Bill bi);
}
