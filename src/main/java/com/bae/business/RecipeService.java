package com.bae.business;

public interface RecipeService {
	String getAllRecipes();
	String getARecipe(int id);
	String createRecipe(String recipe);
	
}
