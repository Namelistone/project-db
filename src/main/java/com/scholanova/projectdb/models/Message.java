package com.scholanova.projectdb.models;

public class Message {
	private int id;
	private String content;
	public Message(int id,String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public Message() {
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
