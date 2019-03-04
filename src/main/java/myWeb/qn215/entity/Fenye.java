package myWeb.qn215.entity;



public class Fenye {
	private int billPageCount=3;	//总页数
	private int billSize=8;		//每页显示记录数
	private int billCount;		//总记录数
	private int bliiPageNONO=1;		//当前第几页码
	private int firstResult;  //每页显示的数据
	
	

	
	public int getFirstResult() {
		return (bliiPageNONO-1)*billSize;
	}
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}
	public int getBillPageCount() {
		return (billPageCount-1)/billSize+1;
	}
	public void setBillPageCount(int billPageCount) {
		this.billPageCount = billPageCount;
	}
	public int getBillSize() {
		return billSize;
	}
	public void setBillSize(int billSize) {
		this.billSize = billSize;
	}
	public int getBillCount() {
		return billCount;
	}
	public void setBillCount(int billCount) {
		this.billCount = billCount;
	}
	public int getBliiPageNONO() {
		return bliiPageNONO;
	}
	public void setBliiPageNONO(int bliiPageNONO) {
		this.bliiPageNONO = bliiPageNONO;
	}
}
