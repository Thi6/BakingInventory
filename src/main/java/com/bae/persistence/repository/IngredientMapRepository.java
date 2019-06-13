package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Ingredient;
import com.bae.util.JSONUtil;

@Alternative
public class IngredientMapRepository implements IngredientRepository{
	
	private Map<Integer, Ingredient> ingredientMap = new HashMap<Integer, Ingredient>();
	
	@Override
	public String getAllIngredients() {
		return new JSONUtil().getJSONForObject(ingredientMap);
	}

	@Override
	public String getAnIngredient(int id) {
		
		return null;
	}

	public Map<Integer, Ingredient> getIngredientMap() {
		return ingredientMap;
	}

	public void setIngredientMap(Map<Integer, Ingredient> ingredientMap) {
		this.ingredientMap = ingredientMap;
	}

 

}
