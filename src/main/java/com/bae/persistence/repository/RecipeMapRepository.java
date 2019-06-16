package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Recipe;
import com.bae.util.JSONUtil;

@Alternative
public class RecipeMapRepository implements RecipeRepository{
	private Map<Integer, Recipe> recipeMap = new HashMap<Integer, Recipe>();
	private JSONUtil util = new JSONUtil();
	
	@Override
	public String getAllRecipes() {
		return util.getJSONForObject(recipeMap);
	}

	@Override 
	public String getARecipe(int id) {
		return  util.getJSONForObject(recipeMap.get(id));
	}

	@Override
	public String createRecipe(String recipe) {
		Recipe recipeToAdd = util.getObjectForJSON(recipe, Recipe.class);
		recipeMap.put(recipeToAdd.getRecipeId(), recipeToAdd);
		return "Recipe successfully added";
	}
 
	@Override
	public String removeRecipe(int id) {
		recipeMap.remove(id);
		if (recipeMap.containsKey(id)) {
			return "Recipe has not been removed";
		} else {
			return "Recipe successfully removed";
		}
		
	}

	@Override
	public String updateRecipe(int id, String recipe) {
		Recipe updatedRecipe = util.getObjectForJSON(recipe, Recipe.class);
		if (recipeMap.containsKey(id)) {
			recipeMap.replace(id, updatedRecipe);
			return "Recipe successfully updated";
		} else {
			return "Cannot find the recipe";
		}
		
	}

	public Map<Integer, Recipe> getRecipeMap() {
		return recipeMap;
	}

	public void setRecipeMap(Map<Integer, Recipe> recipeMap) {
		this.recipeMap = recipeMap;
	}
	
}
