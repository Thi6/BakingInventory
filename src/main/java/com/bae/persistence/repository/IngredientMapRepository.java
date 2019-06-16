package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Ingredient;
import com.bae.util.JSONUtil;

@Alternative
public class IngredientMapRepository implements IngredientRepository{
	
	private Map<Integer, Ingredient> ingredientMap = new HashMap<Integer, Ingredient>();
	private JSONUtil util = new JSONUtil();
	 
	@Override
	public String getAllIngredients() {
		return util.getJSONForObject(ingredientMap);
	}

	@Override
	public String getAnIngredient(int id) {
		return util.getJSONForObject(ingredientMap.get(id));
	}


	@Override
	public String addIngredient(String ingredient) {
		Ingredient newIngr = util.getObjectForJSON(ingredient, Ingredient.class);
		ingredientMap.put(newIngr.getIngredientId(), newIngr);
		return "Ingredient successfully added";
	}

	@Override
	public String removeIngredient(int id) {
		ingredientMap.remove(id);
		if (ingredientMap.containsKey(id)) {
			return "Ingredient has not been removed";
		} else {
			return "Ingredient has been removed";
		}
		
	}
	public Map<Integer, Ingredient> getIngredientMap() {
		return ingredientMap;
	}

	public void setIngredientMap(Map<Integer, Ingredient> ingredientMap) {
		this.ingredientMap = ingredientMap;
	}

	@Override
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
