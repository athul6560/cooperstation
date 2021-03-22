package com.athulbabu.azstudio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pinemail")
public class pinSubmitModel {
	@Column(unique=true)
	String email;
	@Column(nullable=false)
	int pinnumber;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPinnumber() {
		return pinnumber;
	}
	public void setPinnumber(int pinnumber) {
		this.pinnumber = pinnumber;
	}
	

}
