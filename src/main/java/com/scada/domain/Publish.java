package com.scada.domain;

import java.util.Date;

public class Publish {
	//���
	private Integer id;
	
	//����
	private String title;
	
	//ʱ��
	private Date date;
	
	//����
	private String context;
	
	//���
	private String type;
	
	//�ϴ���
	private String user;

	public Publish(){
		date = new Date();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
}
