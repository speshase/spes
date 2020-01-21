package com.spes.model;

public class CategoryVO {
	
	private int qno;
	private String qcategory;
	private String qcategoryk;
	private String qsubject;
	private String qcontent;
	
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getQcategory() {
		return qcategory;
	}
	public void setQcategory(String qcategory) {
		this.qcategory = qcategory;
	}
	public String getQcategoryk() {
		return qcategoryk;
	}
	public void setQcategoryk(String qcategoryk) {
		this.qcategoryk = qcategoryk;
	}
	public String getQsubject() {
		return qsubject;
	}
	public void setQsubject(String qsubject) {
		this.qsubject = qsubject;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	
	@Override
	public String toString() {
		return "CategoryVO [qno=" + qno + ", qcategory=" + qcategory + ", qcategoryk=" + qcategoryk + ", qsubject="
				+ qsubject + ", qcontent=" + qcontent + "]";
	}
}