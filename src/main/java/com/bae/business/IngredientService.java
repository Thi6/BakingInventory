package com.bae.business;

public interface IngredientService {
	String getAllIngredients();
	String getAnIngredient(int id);
	String addIngredient(String ingredient);
	String removeIngredient(int id);
}
