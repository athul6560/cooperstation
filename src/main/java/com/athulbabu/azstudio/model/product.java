package com.athulbabu.azstudio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int product_id;
	@Column
	String product_name;
	@Column
	int rate;
	@Column
	String imagea;
	@Column
	String imageb;
	@Column
	String imagec;
	@Column
	String title;
	@Column
	int original_rate;
	@Column
	String sleeve;
	@Column
	String fabric;
	@Column
	String neck_type;
	@Column
	String pattern;
	@Column
	String m;
	@Column
	String l;
	@Column
	String xl;
	@Column
	String xxl;
	@Column
	String xxxl;
	@Column
	String details;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getImagea() {
		return imagea;
	}
	public void setImagea(String imagea) {
		this.imagea = imagea;
	}
	public String getImageb() {
		return imageb;
	}
	public void setImageb(String imageb) {
		this.imageb = imageb;
	}
	public String getImagec() {
		return imagec;
	}
	public void setImagec(String imagec) {
		this.imagec = imagec;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getOriginal_rate() {
		return original_rate;
	}
	public void setOriginal_rate(int original_rate) {
		this.original_rate = original_rate;
	}
	public String getSleeve() {
		return sleeve;
	}
	public void setSleeve(String sleeve) {
		this.sleeve = sleeve;
	}
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
	public String getNeck_type() {
		return neck_type;
	}
	public void setNeck_type(String neck_type) {
		this.neck_type = neck_type;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public String getL() {
		return l;
	}
	public void setL(String l) {
		this.l = l;
	}
	public String getXl() {
		return xl;
	}
	public void setXl(String xl) {
		this.xl = xl;
	}
	public String getXxl() {
		return xxl;
	}
	public void setXxl(String xxl) {
		this.xxl = xxl;
	}
	public String getXxxl() {
		return xxxl;
	}
	public void setXxxl(String xxxl) {
		this.xxxl = xxxl;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "product [product_id=" + product_id + ", product_name=" + product_name + ", rate=" + rate + ", imagea="
				+ imagea + ", imageb=" + imageb + ", imagec=" + imagec + ", title=" + title + ", original_rate="
				+ original_rate + ", sleeve=" + sleeve + ", fabric=" + fabric + ", neck_type=" + neck_type
				+ ", pattern=" + pattern + ", m=" + m + ", l=" + l + ", xl=" + xl + ", xxl=" + xxl + ", xxxl=" + xxxl
				+ ", details=" + details + ", getProduct_id()=" + getProduct_id() + ", getProduct_name()="
				+ getProduct_name() + ", getRate()=" + getRate() + ", getImagea()=" + getImagea() + ", getImageb()="
				+ getImageb() + ", getImagec()=" + getImagec() + ", getTitle()=" + getTitle() + ", getOriginal_rate()="
				+ getOriginal_rate() + ", getSleeve()=" + getSleeve() + ", getFabric()=" + getFabric()
				+ ", getNeck_type()=" + getNeck_type() + ", getPattern()=" + getPattern() + ", getM()=" + getM()
				+ ", getL()=" + getL() + ", getXl()=" + getXl() + ", getXxl()=" + getXxl() + ", getXxxl()=" + getXxxl()
				+ ", getDetails()=" + getDetails() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
