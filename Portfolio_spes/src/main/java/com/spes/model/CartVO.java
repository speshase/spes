package com.spes.model;

public class CartVO {
	
	private int rownum; //�ٹ�ȣ
	private int cp; // īƮ��ȣ
	private int np; // ��ǰ��ȣ
	private String uid; // ���̵�
	private	String cfile1; // ��ǰ�̹��� ���
	private String ctitle; // ��ǰ�̸�
	private int count; // ��ǰ ����
	private int cpprice; // ��ǰ �ݾ�
	private int cppricedc; // ���� �ݾ�
	private int total; //��ǰ����*��ǰ�ݾ�
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int getNp() {
		return np;
	}
	public void setNp(int np) {
		this.np = np;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCfile1() {
		return cfile1;
	}
	public void setCfile1(String cfile1) {
		this.cfile1 = cfile1;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCpprice() {
		return cpprice;
	}
	public void setCpprice(int cpprice) {
		this.cpprice = cpprice;
	}
	public int getCppricedc() {
		return cppricedc;
	}
	public void setCppricedc(int cppricedc) {
		this.cppricedc = cppricedc;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "CartVO [rownum=" + rownum + ", cp=" + cp + ", np=" + np + ", uid=" + uid + ", cfile1=" + cfile1
				+ ", ctitle=" + ctitle + ", count=" + count + ", cpprice=" + cpprice + ", cppricedc=" + cppricedc
				+ ", total=" + total + "]";
	}
	
	
}
