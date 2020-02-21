package com.spes.model;

import org.springframework.web.multipart.MultipartFile;

public class EventVO {
	
	private int np; //글번호
	private String eptitle; //글제목
	private String epdate_time; //작성날짜
	private MultipartFile file1; //글이미지원본1(썸네일용)
	private MultipartFile file2; //글이미지원본2(제품소개)
	private String efile1;
	private String efile2;
	private String cname;
	
	public int getNp() {
		return np;
	}
	public void setNp(int np) {
		this.np = np;
	}
	public String getEptitle() {
		return eptitle;
	}
	public void setEptitle(String eptitle) {
		this.eptitle = eptitle;
	}
	public String getEpdate_time() {
		return epdate_time;
	}
	public void setEpdate_time(String epdate_time) {
		this.epdate_time = epdate_time;
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
	public String getEfile1() {
		return efile1;
	}
	public void setEfile1(String efile1) {
		this.efile1 = efile1;
	}
	public String getEfile2() {
		return efile2;
	}
	public void setEfile2(String efile2) {
		this.efile2 = efile2;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "EventVO [np=" + np + ", eptitle=" + eptitle + ", epdate_time=" + epdate_time + ", file1=" + file1
				+ ", file2=" + file2 + ", efile1=" + efile1 + ", efile2=" + efile2 + ", cname=" + cname + "]";
	}

}
