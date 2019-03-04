package myWeb.qn215.entity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;




public class Bill {

	
	private int id;
	private String billCode;	//账单编码
	private String productName;	//商品名称
	private String productDesc;	//商品描述
	private String productUnit; //商品单位
	private String productCount;//商品数量
	private String totalPrice; 	//商品总额
	private int isPayment; 		//是否支付（1：未支付 2：已支付）
	private Date creationDate;	//创建时间
	private int ProviderId;		//供应商id
	private Provider provider=new Provider(); //供应商对象
	private Fenye fenye = new Fenye();
	
	
	
	public Fenye getFenye() {
		return fenye;
	}
	public void setFenye(Fenye fenye) {
		this.fenye = fenye;
	}
	
	public int getProviderId() {
		return ProviderId;
	}
	public void setProviderId(int providerId) {
		ProviderId = providerId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public String getProductCount() {
		return productCount;
	}
	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	
	
}
