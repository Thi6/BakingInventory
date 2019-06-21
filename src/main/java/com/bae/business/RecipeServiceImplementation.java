package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.RecipeRepository;
 
public class RecipeServiceImplementation implements RecipeService{

	@Inject
	RecipeRepository recipeRepo;
	
	
	public String getAllRecipes() {
		return recipeRepo.getAllRecipes();
	}

	
	public String getARecipe(int id) {
		return recipeRepo.getARecipe(id);
	}

	
	public String createRecipe(String recipe) {
		return recipeRepo.createRecipe(recipe);
	}

	
	public String removeRecipe(int id) {
		return recipeRepo.removeRecipe(id);
	}

	
	public String updateRecipe(int id, String recipe) {
		return recipeRepo.updateRecipe(id, recipe);
	}

}
