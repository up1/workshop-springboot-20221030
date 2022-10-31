package com.example.workshop.users;

public class Header{
	private int code;
	private String message;

	public Header() {
	}

	public Header(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
