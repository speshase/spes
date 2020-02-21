package com.spes.model;

public class UserVO {
	
	private String uid; //아이디
	private String upw; //패스워드
	private String uname; //이름
	private int uadress_num; //우편번호
	private String uadress; //주소
	private String uadress_detail; //상세주소
	private String uemail; //이메일
	private String ujointime; //가입날짜
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUadress_num() {
		return uadress_num;
	}
	public void setUadress_num(int uadress_num) {
		this.uadress_num = uadress_num;
	}
	public String getUadress() {
		return uadress;
	}
	public void setUadress(String uadress) {
		this.uadress = uadress;
	}
	public String getUadress_detail() {
		return uadress_detail;
	}
	public void setUadress_detail(String uadress_detail) {
		this.uadress_detail = uadress_detail;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUjointime() {
		return ujointime;
	}
	public void setUjointime(String ujointime) {
		this.ujointime = ujointime;
	}

	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uadress_num=" + uadress_num
				+ ", uadress=" + uadress + ", uadress_detail=" + uadress_detail + ", uemail=" + uemail + ", ujointime="
				+ ujointime + "]";
	}
}
