package com.learinig.sevletjsp.userinfro;
 
public class UserInfo {
	String name;
	String email;
	String code;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", email=" + email + ", code=" + code + "]";
	}
	public UserInfo(String name, String email, String code) {
		super();
		this.name = name;
		this.email = email;
		this.code = code;
	}
	public UserInfo() {
		super();
		
	}
	
}
