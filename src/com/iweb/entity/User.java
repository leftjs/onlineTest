package com.iweb.entity;

public class User {
	private int id;
	private String loginname;
	private String password;
	private String email;
	private String phone;
	private String sex;
	private String birth;
	private String uname;
	private String ulevel;
	public User(int id, String loginname, String password, String email, String phone,
			String sex, String birth, String uname, String ulevel) {
		this.id = id;
		this.loginname = loginname;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.birth = birth;
		this.uname = uname;
		this.ulevel = ulevel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUlevel() {
		return ulevel;
	}
	public void setUlevel(String ulevel) {
		this.ulevel = ulevel;
	}
	
	
}
