package com.bae.business;



import javax.inject.Inject;

import com.bae.persistence.repository.IngredientRepository;

public class IngredientServiceImplementation implements IngredientService {
	
	@Inject
	IngredientRepository ingredientRepo;
 	
	
	@Override 
	public String getAllIngredients() {
		return ingredientRepo.getAllIngredients();
	}

	@Override
	public String getAnIngredient(int id) {
		return ingredientRepo.getAnIngredient(id);
	}

	@Override
	public String addIngredient(String ingredient) {
		return ingredientRepo.addIngredient(ingredient);
	}
	
	@Override
	public String removeIngredient(int id) {
		return ingredientRepo.removeIngredient(id);
	}

	@Override
	public String updateIngredient(int id, String ingredient) {
		return ingredientRepo.updateIngredient(id, ingredient);
	}
  
}
