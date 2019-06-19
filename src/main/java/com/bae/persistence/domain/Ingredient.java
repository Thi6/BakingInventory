package com.bae.persistence.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ingredientId;
	@Column(length = 250)
	private String name;
	@Column(length = 250)
	private String category;
	private int quantity;
	private int threshold;
	private String expiryDate;
 	
	public Ingredient() { 
		
	}
	public Ingredient(int ingredientId, String name, String category, int quantity, int threshold, String expiryDate) {
		super();
		this.ingredientId = ingredientId;
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.threshold = threshold;
		this.expiryDate = expiryDate;
	}
	
	public int getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getThreshold() {
		return threshold;
	}
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public String toString() {
		return "Ingredient [ingredientId=" + ingredientId + ", name=" + name + ", category=" + category + ", quantity="
				+ quantity + ", threshold=" + threshold + ", expiryDate=" + expiryDate + "]";
	}

	
	
}
