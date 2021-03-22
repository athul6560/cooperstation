package com.athulbabu.azstudio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hari")
public class hari {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int hari_id;
	@Column(nullable=false)
	private String value;
	public int getHari_id() {
		return hari_id;
	}
	public void setHari_id(int hari_id) {
		this.hari_id = hari_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	

	}



