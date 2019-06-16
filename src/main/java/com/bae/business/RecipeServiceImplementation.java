package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.RecipeRepository;

public class RecipeServiceImplementation implements RecipeService{

	@Inject
	RecipeRepository recipeRepo;
	
	@Override
	public String getAllRecipes() {
		return recipeRepo.getAllRecipes();
	}

	@Override
	public String getARecipe(int id) {
		return recipeRepo.getARecipe(id);
	}

	@Override
	public String createRecipe(String recipe) {
		return recipeRepo.createRecipe(recipe);
	}

	@Override
	public String removeRecipe(int id) {
		return recipeRepo.removeRecipe(id);
	}

}
