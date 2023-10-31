package com.demo.hybernatedemo1.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Perfume {
@Id
private int perId;
private String perName;
private String perCategory;
private double perPrice;
public Perfume() {
	super();
}

public Perfume(int perId, String perName, String perCategory, double perPrice) {
	super();
	this.perId = perId;
	this.perName = perName;
	this.perCategory = perCategory;
	this.perPrice = perPrice;
}

public int getPrdId() {
	return perId;
}

public void setPrdId(int prdId) {
	this.perId = prdId;
}

public String getPrdName() {
	return perName;
}

public void setPrdName(String prdName) {
	this.perName = prdName;
}

public String getPrdCategory() {
	return perCategory;
}

public void setPrdCategory(String prdCategory) {
	this.perCategory = prdCategory;
}

public double getPrdPrice() {
	return perPrice;
}

public void setPrdPrice(double prdPrice) {
	this.perPrice = prdPrice;
}


public String toString() {
	return "prd Id:"+perId+"prd Name:"+perName+"prd Price:"
+perPrice+"prd Category:"+perCategory;
}}

