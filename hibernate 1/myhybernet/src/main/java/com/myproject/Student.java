package com.myproject;

import jakarta.persistence.*;

@Entity
public class Student {

	@Id
	private int id;

	private String nameString;

	private String cityString;
	
	private Certificate certificate;
	

	public Student(int id, String nameString, String cityString) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.cityString = cityString;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getCityString() {
		return cityString;
	}

	public void setCityString(String cityString) {
		this.cityString = cityString;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}
	
	

}
