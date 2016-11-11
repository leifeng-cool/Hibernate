package com.study.onetomany;

import java.util.HashSet;
import java.util.Set;

/*
 * 代理商实体类（一）
 */
public class Agents {
	private int aId;
	private String aName;
	private String aGender;
	private String aPhone;
	
	//在代理商实体类中表示有多个客户，即一个代理商对应多个客户
	//hibernate要求使用集合表示多的数据，使用set集合
	private Set<Customs> sCustoms = new HashSet<Customs>();
	
	
	public Set<Customs> getsCustoms() {
		return sCustoms;
	}
	public void setsCustoms(Set<Customs> sCustoms) {
		this.sCustoms = sCustoms;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaGender() {
		return aGender;
	}
	public void setaGender(String aGender) {
		this.aGender = aGender;
	}
	public String getaPhone() {
		return aPhone;
	}
	public void setaPhone(String aPhone) {
		this.aPhone = aPhone;
	}

	
	
}
