package com.lekha.jokha.businessobj;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * the serial version uid.
	 */
	private static final long serialVersionUID = -7890902604017641212L;

	private String email;
	private String fullName;
	private String password;
	private String phoneNo;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", fullName=" + fullName + ", password=" + password + ", phoneNo=" + phoneNo
				+ "]";
	}
}
