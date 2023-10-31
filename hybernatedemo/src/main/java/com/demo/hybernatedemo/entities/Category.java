package com.demo.hybernatedemo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
 
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String categoryName;
	private String description;
	@OneToMany(mappedBy = "prdCategory")
	private List<Product> products;
	public Category(int categoryId, String categoryName, String description) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
	}
	
	public Category(String categoryName, String description) {
		this.categoryName = categoryName;
		this.description = description;
	}
 
	public Category() {
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getProducts() {
		return products;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description
				+ "]";
	}
	
 
}