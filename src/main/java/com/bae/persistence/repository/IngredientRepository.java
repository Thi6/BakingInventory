package com.bae.persistence.repository;

public interface IngredientRepository {
	String getAllIngredients();
	String getAnIngredient(int id);
	String addIngredient(String ingredient);
}
