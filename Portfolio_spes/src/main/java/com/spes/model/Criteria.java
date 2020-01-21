package com.spes.model;

public class Criteria {
	//페이지번호
	private int pageNum;
	//한 페이지당 데이터 처리 개수(10개)
	private int amount;
	//키워드 검색기능
	private String keyword;
	
	public Criteria() { //기본생성자(매개변수가 없다.)
		this(1,5);
	}

	//매개변수가 2개인 생성자를 이용해서 값을 넣음.(클래스명이 같고 리턴타입이 없다.)
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
