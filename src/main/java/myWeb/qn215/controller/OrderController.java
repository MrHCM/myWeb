package myWeb.qn215.controller;




import java.io.IOException;
import java.util.List;

import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import myWeb.qn215.entity.Bill;
import myWeb.qn215.entity.Fenye;
import myWeb.qn215.entity.Provider;
import myWeb.qn215.service.BillService;




@Controller
@RequestMapping("/Orde")
public class OrderController {
	
	
	@Autowired
	private BillService billService;
	
	@RequestMapping("/add")
	public String add() {
		
		return "billadd";
	}
	
	@PostMapping("/addadd")
	@ResponseBody
	public boolean  addadd(Bill bi,javax.servlet.ServletRequest req,javax.servlet.ServletResponse rse) throws IOException {
		return billService.add(bi);
	}
	
	@RequestMapping("/view")
	public String views(Bill bill,javax.servlet.ServletRequest req) {
		
			bill.setId(Integer.parseInt(req.getParameter("id")));
			List<Bill> billListss = billService.selectID(bill);
			req.setAttribute("bbbb",billListss);
			
		return "billview";
	}
	
	@RequestMapping("/dd")
	public String dddd(Bill bi,javax.servlet.ServletRequest req) {
		
		
		List<Bill> billList = billService.selectBill(bi);
		List<Provider> providers=billService.selectprovider();
		req.setAttribute("billList",billList );
		req.setAttribute("providerList", providers);
		req.setAttribute("pag", bi.getFenye().getBliiPageNONO());
		
		return "billlist";
	}
	
	@RequestMapping("/cx")
	public String cx(Bill bi,javax.servlet.ServletRequest req) {
		
		
		String queryProductName=req.getParameter("queryProductName");
		int queryProviderId=Integer.parseInt(req.getParameter("queryProviderId"));
		int queryIsPayment=Integer.parseInt(req.getParameter("queryIsPayment"));
		int pag=Integer.parseInt(req.getParameter("pags"));
		
		
		if(pag!=-1) {
			bi.getFenye().setBliiPageNONO(pag);
		}
		
		if (queryProductName!=null) {
			bi.setProductName(queryProductName);
		}
		if (queryProviderId!=0) {
			bi.setProviderId(queryProviderId);
		}
		if (queryIsPayment!=0) {
			bi.setIsPayment(queryIsPayment);
		}
		
		req.setAttribute("pag", bi.getFenye().getBliiPageNONO());
		
		List<Bill> billList = billService.selectBill(bi);
		List<Provider> providers=billService.selectprovider();
		req.setAttribute("billList",billList );
		req.setAttribute("providerList", providers);
		
		return "billlist";
	}
	
	
	
	
}
