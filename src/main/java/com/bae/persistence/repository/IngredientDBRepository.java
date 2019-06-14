package com.bae.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.persistence.TypedQuery;

import com.bae.persistence.domain.Ingredient;
import com.bae.util.JSONUtil;

@Transactional(value = TxType.SUPPORTS)
@Default
public class IngredientDBRepository implements IngredientRepository{
	
	@PersistenceContext(unitName = "primary")
	EntityManager manager;
	
	@Inject
	private JSONUtil util;
	

	public String getAllIngredients() {
		TypedQuery<Ingredient> query = manager.createQuery("SELECT i FROM Ingredient i", Ingredient.class);
		Collection<Ingredient> ingredients = query.getResultList();
		return util.getJSONForObject(ingredients);
	}
 
	
	public String getAnIngredient(int id) {
		return util.getJSONForObject(manager.find(Ingredient.class, id));
	}


	@Transactional(TxType.REQUIRED)
	public String addIngredient(String ingredient) {
		Ingredient newIngr = util.getObjectForJSON(ingredient, Ingredient.class);
		manager.persist(newIngr);
		return  "{\"message\": \"ingredient has been sucessfully added\"}";
	}


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
}
