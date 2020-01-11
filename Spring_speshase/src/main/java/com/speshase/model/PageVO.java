package com.speshase.model;

public class PageVO {
	//페이징 시작번호
	private int startPage;
	//페이징 끝번호
	private int endPage;
	//페이징의 이전
	private boolean prev;
	//페이징의 다음
	private boolean next;
	
	private int total;
	private Criteria cri;

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public PageVO(Criteria cri, int total) { //매개변수가 2개인 생성자
		this.cri=cri;
		this.total=total;
		
		//페이징의 끝번호를 알 수 있게 계산
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		//페이징의 시작번호를 알 수 있게 계산
		this.startPage=this.endPage-9;
		//가장 마지막 페이지
		int realEnd=(int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage=realEnd;
		}
		this.prev=this.startPage>1;
		this.next=this.endPage < realEnd;
	}
}