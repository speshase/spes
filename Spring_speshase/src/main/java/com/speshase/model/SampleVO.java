package com.speshase.model;

public class SampleVO {
	
	//변수 맨 첫글자는 소문자(그래야 spring이 인식함)
	private String firstName;
	private String lastName;
	private int mno;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
}