package com.myproject;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "student_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int addressid;
	
	@Column(name = "street" , length = 50)
	private String streetString;
	
	@Column(name = "city" , length = 80)
	private String cityString;
	
	@Column(name = "is_open")
	private boolean isOpen;
	
	@Transient
	private double x;
	
	@Column(name = "added_date")
	@Temporal(TemporalType.DATE)
	private LocalDate adddateDate;
	
	@Lob
	private byte[] images;

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", streetString=" + streetString + ", cityString=" + cityString
				+ ", isOpen=" + isOpen + ", x=" + x + ", adddateDate=" + adddateDate + ", images="
				+ Arrays.toString(images) + "]";
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getStreetString() {
		return streetString;
	}

	public void setStreetString(String streetString) {
		this.streetString = streetString;
	}

	public String getCityString() {
		return cityString;
	}

	public void setCityString(String cityString) {
		this.cityString = cityString;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public LocalDate getAdddateDate() {
		return adddateDate;
	}

	public void setAdddateDate(LocalDate adddateDate) {
		this.adddateDate = adddateDate;
	}

	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	public Address(int addressid, String streetString, String cityString, boolean isOpen, double x,
			LocalDate adddateDate, byte[] images) {
		super();
		this.addressid = addressid;
		this.streetString = streetString;
		this.cityString = cityString;
		this.isOpen = isOpen;
		this.x = x;
		this.adddateDate = adddateDate;
		this.images = images;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
