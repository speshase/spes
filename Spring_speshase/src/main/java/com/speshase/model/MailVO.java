package com.speshase.model;

public class MailVO {
	private String tomail; // �޴� ���
	private String title; // ����
	private String content; // ����
	private String frommail; // ������ ���
	
	public String getTomail() {
		return tomail;
	}
	public void setTomail(String tomail) {
		this.tomail = tomail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFrommail() {
		return frommail;
	}
	public void setFrommail(String frommail) {
		this.frommail = frommail;
	}
	
	@Override
	public String toString() {
		return "MailVO [tomail=" + tomail + ", title=" + title + ", content=" + content + ", frommail=" + frommail
				+ "]";
	}
}
