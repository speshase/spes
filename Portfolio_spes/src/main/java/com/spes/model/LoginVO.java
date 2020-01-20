package com.spes.model;

public class LoginVO {
	
	private String uid; //아이디
	private String upw; //패스워드
	private boolean useCookie; //쿠키 사용여부
	
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
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "LoginVO [uid=" + uid + ", upw=" + upw + ", useCookie=" + useCookie + "]";
	}
}
