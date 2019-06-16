package com.bae.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
		TypedQuery<Recipe> query = manager.createQuery("SELECT r FROM Recipe r", Recipe.class);
		Collection<Recipe> recipes = query.getResultList();
		return util.getJSONForObject(recipes);
	}

	@Override
	public String getARecipe(int id) {
		return util.getJSONForObject(manager.find(Recipe.class, id));
	}

	@Override
	public String createRecipe(String recipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeRecipe(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRecipe(int id, String recipe) {
		// TODO Auto-generated method stub
		return null;
	}

}
