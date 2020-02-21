package com.spes.model;

import org.springframework.web.multipart.MultipartFile;

public class BestVO {
	
	private int np; //�۹�ȣ
	private String bptitle; //������
	private int bpprice; //����
	private int bppricedc; //���ΰ���
	private String bptext; //�۳���
	private String bpdate_time; //�ۼ���¥
	private MultipartFile file1; //���̹�������1(����Ͽ�)
	private MultipartFile file2; //���̹�������2(��ǰ�Ұ�)
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
