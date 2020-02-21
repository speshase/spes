package com.spes.model;

import org.springframework.web.multipart.MultipartFile;

public class CouponVO {
	
	private int np; //글번호
	private String cptitle; //글제목
	private int cpprice; //가격
	private int cppricedc; //할인가격
	private String cptext; //글내용
	private String cpdate_time; //작성날짜
	private MultipartFile file1; //글이미지원본1(썸네일용)
	private MultipartFile file2; //글이미지원본2(제품소개)
	private String cfile1;
	private String cfile2;
	private String cname;
	
	public int getNp() {
		return np;
	}
	public void setNp(int np) {
		this.np = np;
	}
	public String getCptitle() {
		return cptitle;
	}
	public void setCptitle(String cptitle) {
		this.cptitle = cptitle;
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
	public String getCptext() {
		return cptext;
	}
	public void setCptext(String cptext) {
		this.cptext = cptext;
	}
	public String getCpdate_time() {
		return cpdate_time;
	}
	public void setCpdate_time(String cpdate_time) {
		this.cpdate_time = cpdate_time;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public MultipartFile getFile2() {
		return file2;
	}
	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}
	public String getCfile1() {
		return cfile1;
	}
	public void setCfile1(String cfile1) {
		this.cfile1 = cfile1;
	}
	public String getCfile2() {
		return cfile2;
	}
	public void setCfile2(String cfile2) {
		this.cfile2 = cfile2;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "CouponVO [np=" + np + ", cptitle=" + cptitle + ", cpprice=" + cpprice + ", cppricedc=" + cppricedc
				+ ", cptext=" + cptext + ", cpdate_time=" + cpdate_time + ", file1=" + file1 + ", file2=" + file2
				+ ", cfile1=" + cfile1 + ", cfile2=" + cfile2 + ", cname=" + cname + "]";
	}
	
}
