package com.spes.model;

public class CommentsVO {

	private int cmno; // ��۹�ȣ
	private int cno; // �۹�ȣ
	private String comments; // ��۳���
	private String cmuid; // ��۾��̵�(������)
	private String cdate_time; // ��� �� �ð�
	private String cndate_time; // ��� ���� �ð�

	public int getCmno() {
		return cmno;
	}

	public void setCmno(int cmno) {
		this.cmno = cmno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCmuid() {
		return cmuid;
	}

	public void setCmuid(String cmuid) {
		this.cmuid = cmuid;
	}

	public String getCdate_time() {
		return cdate_time;
	}

	public void setCdate_time(String cdate_time) {
		this.cdate_time = cdate_time;
	}

	public String getCndate_time() {
		return cndate_time;
	}

	public void setCndate_time(String cndate_time) {
		this.cndate_time = cndate_time;
	}

	@Override
	public String toString() {
		return "CommentsVO [cmno=" + cmno + ", cno=" + cno + ", comments=" + comments + ", cmuid=" + cmuid
				+ ", cdate_time=" + cdate_time + ", cndate_time=" + cndate_time + "]";
	}

}
