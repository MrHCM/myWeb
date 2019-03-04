package myWeb.qn215.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myWeb.qn215.dao.BillDao;
import myWeb.qn215.entity.Bill;
import myWeb.qn215.entity.Provider;
import myWeb.qn215.service.BillService;

@Service
public class BillServiceimp implements BillService{

	@Autowired
	BillDao billdao;

	@Override
	public List<Bill> selectBill(Bill bi) {
		// TODO Auto-generated method stub
		return billdao.selectBill(bi);
	}

	@Override
	public List<Provider> selectprovider() {
		// TODO Auto-generated method stub
		return billdao.selectprovider();
	}

	@Override
	public boolean add(Bill bi) {
		// TODO Auto-generated method stub
		return billdao.add(bi)>0;
	}

	@Override
	public List<Bill> selectID(Bill bi) {
		
		return billdao.selectID(bi);
	}

	@Override
	public List<Bill> selectBillFeny(Bill bi) {
		// TODO Auto-generated method stub
		return billdao.selectBillFeny(bi);
	}

	

	


	

	

	

	

}
