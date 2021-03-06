package com.athulbabu.azstudio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class user {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int user_id;
private String user_name;
@Column(unique=true)
private String email;
@Column(nullable=false)
private String user_password;
@Column(nullable=false)
private String user_role;
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getUser_email() {
	return email;
}
public void setUser_email(String user_email) {
	this.email = user_email;
}
public String getUser_password() {
	return user_password;
}
public void setUser_password(String user_password) {
	this.user_password = user_password;
}
public String getUser_role() {
	return user_role;
}
public void setUser_role(String user_role) {
	this.user_role = user_role;
}

}
