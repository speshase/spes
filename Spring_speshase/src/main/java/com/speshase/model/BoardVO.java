package com.speshase.model;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	
	private int no; //no
	private String subject; //subject
	private String content; //content
	private String writer; //writer
	private String write_date; //write_date
	private int cnt; //cnt
	private MultipartFile filename;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public MultipartFile getFilename() {
		return filename;
	}
	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", subject=" + subject + ", content=" + content + ", writer=" + writer
				+ ", write_date=" + write_date + ", cnt=" + cnt + ", filename=" + filename + "]";
	}
	
}
