package com.study.entity;

public class User {
	/*hibernate 要求每个类中有一个属性唯一*/
	private int uid;
	//private String uid;
	private String Username;
	private int age;
	private String address;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	/*public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}*/
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", Username=" + Username + ", age=" + age + ", address=" + address + "]";
	}
	
}
