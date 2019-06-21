package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Recipe;
import com.bae.util.JSONUtil;

@Alternative
public class RecipeMapRepository implements RecipeRepository{
	private Map<Integer, Recipe> recipeMap = new HashMap<>();
	private JSONUtil util = new JSONUtil();
	
	
	public String getAllRecipes() {
		return util.getJSONForObject(recipeMap);
	}

	 
	public String getARecipe(int id) {
		return  util.getJSONForObject(recipeMap.get(id));
	}

	
	public String createRecipe(String recipe) {
		Recipe recipeToAdd = util.getObjectForJSON(recipe, Recipe.class);
		recipeMap.put(recipeToAdd.getRecipeId(), recipeToAdd);
		return "Recipe successfully added";
	}
 

	public String removeRecipe(int id) {
		
		if (recipeMap.containsKey(id)) {
			recipeMap.remove(id);
			return "Recipe successfully removed";
		} else {
			return "Cannot find the recipe";
		}
		
	}

	
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

	
	
}
