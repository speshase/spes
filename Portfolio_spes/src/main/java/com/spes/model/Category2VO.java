package com.spes.model;

public class Category2VO {
	
	private int nno;
	private String ncategory;
	private String ncategoryk;
	private String nsubject;
	private String ncontent;
	
	public int getNno() {
		return nno;
	}
	public void setNno(int nno) {
		this.nno = nno;
	}
	public String getNcategory() {
		return ncategory;
	}
	public void setNcategory(String ncategory) {
		this.ncategory = ncategory;
	}
	public String getNcategoryk() {
		return ncategoryk;
	}
	public void setNcategoryk(String ncategoryk) {
		this.ncategoryk = ncategoryk;
	}
	public String getNsubject() {
		return nsubject;
	}
	public void setNsubject(String nsubject) {
		this.nsubject = nsubject;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	
	@Override
	public String toString() {
		return "Category2VO [nno=" + nno + ", ncategory=" + ncategory + ", ncategoryk=" + ncategoryk + ", nsubject="
				+ nsubject + ", ncontent=" + ncontent + "]";
	}
	
}