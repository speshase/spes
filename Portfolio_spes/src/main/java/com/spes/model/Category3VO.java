package com.spes.model;

public class Category3VO {
	
	private int cno;
	private String csubject;
	private String ccontent;
	private String cuid;
	private String cwrite_date;
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCsubject() {
		return csubject;
	}
	public void setCsubject(String csubject) {
		this.csubject = csubject;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getCuid() {
		return cuid;
	}
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	public String getCwrite_date() {
		return cwrite_date;
	}
	public void setCwrite_date(String cwrite_date) {
		this.cwrite_date = cwrite_date;
	}
	@Override
	public String toString() {
		return "Category3VO [cno=" + cno + ", csubject=" + csubject + ", ccontent=" + ccontent + ", cuid=" + cuid
				+ ", cwrite_date=" + cwrite_date + "]";
	}
	
}