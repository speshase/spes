package com.spes.model;

import org.springframework.web.multipart.MultipartFile;

public class NewVO {
	
	private int np; //�۹�ȣ
	private String nptitle; //������
	private int npprice; //����
	private int nppricedc; //���ΰ���
	private String nptext; //�۳���
	private String npdate_time; //�ۼ���¥
	private MultipartFile file1; //���̹�������1(����Ͽ�)
	private MultipartFile file2; //���̹�������2(��ǰ�Ұ�)
	private String sfile1;
	private String sfile2;
	private String cname;
	
	public int getNp() {
		return np;
	}
	public void setNp(int np) {
		this.np = np;
	}
	public String getNptitle() {
		return nptitle;
	}
	public void setNptitle(String nptitle) {
		this.nptitle = nptitle;
	}
	public int getNpprice() {
		return npprice;
	}
	public void setNpprice(int npprice) {
		this.npprice = npprice;
	}
	public int getNppricedc() {
		return nppricedc;
	}
	public void setNppricedc(int nppricedc) {
		this.nppricedc = nppricedc;
	}
	public String getNptext() {
		return nptext;
	}
	public void setNptext(String nptext) {
		this.nptext = nptext;
	}
	public String getNpdate_time() {
		return npdate_time;
	}
	public void setNpdate_time(String npdate_time) {
		this.npdate_time = npdate_time;
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
	public String getSfile1() {
		return sfile1;
	}
	public void setSfile1(String sfile1) {
		this.sfile1 = sfile1;
	}
	public String getSfile2() {
		return sfile2;
	}
	public void setSfile2(String sfile2) {
		this.sfile2 = sfile2;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "NewVO [np=" + np + ", nptitle=" + nptitle + ", npprice=" + npprice + ", nppricedc=" + nppricedc
				+ ", nptext=" + nptext + ", npdate_time=" + npdate_time + ", file1=" + file1 + ", file2=" + file2
				+ ", sfile1=" + sfile1 + ", sfile2=" + sfile2 + ", cname=" + cname + "]";
	}

}