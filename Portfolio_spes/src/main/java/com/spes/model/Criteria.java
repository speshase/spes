package com.spes.model;

public class Criteria {
	//��������ȣ
	private int pageNum;
	//�� �������� ������ ó�� ����(10��)
	private int amount;
	//Ű���� �˻����
	private String keyword;
	
	public Criteria() { //�⺻������(�Ű������� ����.)
		this(1,5);
	}

	//�Ű������� 2���� �����ڸ� �̿��ؼ� ���� ����.(Ŭ�������� ���� ����Ÿ���� ����.)
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
	
	
}
