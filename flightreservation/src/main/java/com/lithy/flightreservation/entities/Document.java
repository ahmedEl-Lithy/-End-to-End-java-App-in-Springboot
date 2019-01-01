package com.lithy.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Document extends AbstractEntity{
	private String name;
	
	@Lob
	private byte[] data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
