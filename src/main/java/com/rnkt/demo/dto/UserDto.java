package com.rnkt.demo.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.rnkt.demo.entities.Gender;

public class UserDto {

	private int userId;

	private String first_Name;

	private String last_Name;

	private long phone;

	private String email;

	private Date dob;

	private Gender gender;

	public UserDto() {
		super();
	}

	public UserDto(int userId, String first_Name, String last_Name, long phone, String email, Date dob, Gender gender) {
		super();
		this.userId = userId;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
