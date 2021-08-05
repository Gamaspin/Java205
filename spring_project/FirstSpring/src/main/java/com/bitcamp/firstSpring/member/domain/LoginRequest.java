package com.bitcamp.firstSpring.member.domain;

public class LoginRequest {

	// beans 만들기. jsp쪽의 id와 똑같이 만들 것
	private String id;
	private String pw;
	
	

	// 기본 생성자 필수!!
	public LoginRequest() {
	}
	public LoginRequest(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	
	// Setter/Getter
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
	@Override
	public String toString() {
		return "LoginRequest [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
	
}
