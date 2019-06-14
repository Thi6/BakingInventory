package com.bae.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Ingredient;
import com.bae.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class IngredientDBRepository implements IngredientRepository{
	
	@PersistenceContext(unitName = "primary")
	EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllIngredients() {
		TypedQuery<Ingredient> query = manager.createQuery("SELECT i FROM Ingredient i", Ingredient.class);
		Collection<Ingredient> ingredients = query.getResultList();
		return util.getJSONForObject(ingredients);
	}
 
	@Override
	public String getAnIngredient(int id) {
		return util.getJSONForObject(manager.find(Ingredient.class, id));
	}
	
}
