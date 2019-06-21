package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Ingredient;
import com.bae.util.JSONUtil;

@Alternative
public class IngredientMapRepository implements IngredientRepository{
	
	private Map<Integer, Ingredient> ingredientMap = new HashMap<>();
	private JSONUtil util = new JSONUtil();
	  
	
	public String getAllIngredients() {
		return util.getJSONForObject(ingredientMap);
	}


	public String getAnIngredient(int id) {
		return util.getJSONForObject(ingredientMap.get(id));
	}



	public String addIngredient(String ingredient) {
		Ingredient newIngr = util.getObjectForJSON(ingredient, Ingredient.class);
		ingredientMap.put(newIngr.getIngredientId(), newIngr);
		return "Ingredient successfully added";
	}


	public String removeIngredient(int id) {
		
		if (ingredientMap.containsKey(id)) {
			ingredientMap.remove(id);
			return "Ingredient successfully removed";
		} else {
			return "Cannot find ingredient";
		}
		
	}
	public Map<Integer, Ingredient> getIngredientMap() {
		return ingredientMap;
	}



	public String updateIngredient(int id, String ingredient) {
		Ingredient updatedIngredient = util.getObjectForJSON(ingredient, Ingredient.class);
		if (ingredientMap.containsKey(id)) {
			ingredientMap.replace(id, updatedIngredient);
			return "Ingredient successfully updated";
		} else {
			return "Cannot find ingredient"; 
		}
		
	}
 
}
