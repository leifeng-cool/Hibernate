package com.study.onetomany;

/*
 * 客户实体类（多）
 */
public class Customs {
	private int cId;
	private String cName;
	private String cGender;
	private String cLevel;
	private String cPhone;
	
	//在客户实体类中表示所属代理商，一个客户只能属于一个代理商
	private Agents agents;
	
	
	public Agents getAgents() {
		return agents;
	}
	public void setAgents(Agents agents) {
		this.agents = agents;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcGender() {
		return cGender;
	}
	public void setcGender(String cGender) {
		this.cGender = cGender;
	}
	public String getcLevel() {
		return cLevel;
	}
	public void setcLevel(String cLevel) {
		this.cLevel = cLevel;
	}
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	
}
