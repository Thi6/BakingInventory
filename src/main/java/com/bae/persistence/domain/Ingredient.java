package com.bae.persistence.domain;

import java.util.Date;

public class Ingredient {
	private int ingredientId;
	private String name;
	private int quantity;
	private int threshold;
	private Date expiryDate;
	
	public Ingredient() {
		
	}
	
	public Ingredient(int ingredientId, String name, int quantity, int threshold, Date expiryDate) {
		super();
		this.ingredientId = ingredientId;
		this.name = name;
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
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
}
