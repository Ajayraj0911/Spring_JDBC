package com.Bean;

public class EmployeeBean {

	private int eId;
	private String eName;
	private String eAge;
	private String rName;
	private int rId;
	
	
	
	public String getrName() {
		return rName;
	}
	public int getrId() {
		return rId;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int geteId() {
		return eId;
	}
	public String geteName() {
		return eName;
	}
	public String geteAge() {
		return eAge;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public void seteAge(String eAge) {
		this.eAge = eAge;
	}
	
	
}
