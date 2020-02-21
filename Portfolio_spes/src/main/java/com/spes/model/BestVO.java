package com.spes.model;

import org.springframework.web.multipart.MultipartFile;

public class BestVO {
	
	private int np; //글번호
	private String bptitle; //글제목
	private int bpprice; //가격
	private int bppricedc; //할인가격
	private String bptext; //글내용
	private String bpdate_time; //작성날짜
	private MultipartFile file1; //글이미지원본1(썸네일용)
	private MultipartFile file2; //글이미지원본2(제품소개)
	private String bfile1;
	private String bfile2;
	private String cname;
	
	public int getNp() {
		return np;
	}
	public void setNp(int np) {
		this.np = np;
	}
	public String getBptitle() {
		return bptitle;
	}
	public void setBptitle(String bptitle) {
		this.bptitle = bptitle;
	}
	public int getBpprice() {
		return bpprice;
	}
	public void setBpprice(int bpprice) {
		this.bpprice = bpprice;
	}
	public int getBppricedc() {
		return bppricedc;
	}
	public void setBppricedc(int bppricedc) {
		this.bppricedc = bppricedc;
	}
	public String getBptext() {
		return bptext;
	}
	public void setBptext(String bptext) {
		this.bptext = bptext;
	}
	public String getBpdate_time() {
		return bpdate_time;
	}
	public void setBpdate_time(String bpdate_time) {
		this.bpdate_time = bpdate_time;
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
	public String getBfile1() {
		return bfile1;
	}
	public void setBfile1(String bfile1) {
		this.bfile1 = bfile1;
	}
	public String getBfile2() {
		return bfile2;
	}
	public void setBfile2(String bfile2) {
		this.bfile2 = bfile2;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "BestVO [np=" + np + ", bptitle=" + bptitle + ", bpprice=" + bpprice + ", bppricedc=" + bppricedc
				+ ", bptext=" + bptext + ", bpdate_time=" + bpdate_time + ", file1=" + file1 + ", file2=" + file2
				+ ", bfile1=" + bfile1 + ", bfile2=" + bfile2 + ", cname=" + cname + "]";
	}


}
