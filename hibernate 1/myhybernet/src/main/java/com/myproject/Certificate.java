package com.myproject;

import jakarta.persistence.Embeddable;

@Embeddable
public class Certificate {

	private String coursenameString ;
	
	private String durationString;

	public String getCoursenameString() {
		return coursenameString;
	}

	public void setCoursenameString(String coursenameString) {
		this.coursenameString = coursenameString;
	}

	public String getDurationString() {
		return durationString;
	}

	public void setDurationString(String durationString) {
		this.durationString = durationString;
	}

	public Certificate(String coursenameString, String durationString) {
		super();
		this.coursenameString = coursenameString;
		this.durationString = durationString;
	}

	public Certificate() {
		super();
		
	}
	
	
}
