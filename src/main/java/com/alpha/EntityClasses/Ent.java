package com.alpha.EntityClasses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userinfo")
public class Ent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String username;
	private String password;
	private String confirmpassword;
	private String gender;
	private String address;
	private String dob;
	private String designation;
	
	
	
	
	
	public Ent() {
		super();
		
	}
	public Ent(int eid, String username, String password, String confirmpassword, String gender, String address,
			String dob, String designation) {
		super();
		this.eid = eid;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.gender = gender;
		this.address = address;
		this.dob = dob;
		this.designation = designation;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Ent [eid=" + eid + ", username=" + username + ", password=" + password + ", confirmpassword="
				+ confirmpassword + ", gender=" + gender + ", address=" + address + ", dob=" + dob + ", designation="
				+ designation + "]";
	}
	
	
	
	
	

}
