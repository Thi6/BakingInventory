package com.bae.persistence.repository;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Recipe;
import com.bae.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class RecipeDBRepository implements RecipeRepository {
	@PersistenceContext(unitName = "primary")
	EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllRecipes() {
		Query query = manager.createQuery("SELECT r FROM Recipe r");
		List<Recipe> recipes = query.getResultList();
		return util.getJSONForObject(recipes);
	}

	@Override
	public String getARecipe(int id) {
		return util.getJSONForObject(manager.find(Recipe.class, id));
	}

	@Transactional(TxType.REQUIRED)
	public String createRecipe(String recipe) {
		Recipe newRecipe = util.getObjectForJSON(recipe, Recipe.class);
		manager.persist(newRecipe);
		return "{\"message\": \"recipe successfully added\"}";
	}

	
	@Transactional(TxType.REQUIRED)
	public String removeRecipe(int id) {
		Recipe recipeToRemove = manager.find(Recipe.class, id);
		if (manager.contains(recipeToRemove)) {
			manager.remove(recipeToRemove);
			return "{\"message\": \"Recipe successfully removed\"}";
		} else {
			return "{\"message\": \"Cannot find the recipe\"}";
		}
	}

	@Transactional(TxType.REQUIRED)
	public String updateRecipe(int id, String recipe) {
		Recipe recipeToUpdate = manager.find(Recipe.class, id);
		Recipe updatedRecipe = util.getObjectForJSON(recipe,Recipe.class);
		if (recipeToUpdate != null) {
			recipeToUpdate.setName(updatedRecipe.getName());
			manager.persist(recipeToUpdate);
			return "{\"message\":\"Recipe successfully updated\"}";
		} else {
			return "{\"message\":\"Cannot find the recipe\"}";
		}
		 
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
