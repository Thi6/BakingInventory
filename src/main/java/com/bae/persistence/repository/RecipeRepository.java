package com.bae.persistence.repository;

public interface RecipeRepository {
	String getAllRecipes();
	String getARecipe(int id);
	String createRecipe(String recipe);
	String removeRecipe(int id);
	String updateRecipe(int id, String recipe);
}
