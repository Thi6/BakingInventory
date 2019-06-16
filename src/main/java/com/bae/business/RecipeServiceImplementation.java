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

}
