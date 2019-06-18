package com.bae.persistence.repository;


import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	 
 
	public String getAllIngredients() {
		Query query = manager.createQuery("SELECT i FROM Ingredient i");
		List<Ingredient> ingredients = query.getResultList();
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
	
	@Transactional(TxType.REQUIRED)
	public String removeIngredient(int id) {
		Ingredient ingToRemove = manager.find(Ingredient.class, id);		
		
		if (manager.contains(ingToRemove)) {
			manager.remove(ingToRemove);
			return "{\"message\": \"ingredient successfully deleted\"}";
		} else {
			return "{\"message\": \"cannot find this ingredient\"}";
		}
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String updateIngredient(int id, String ingredient) {
		Ingredient ingrToUpdate = manager.find(Ingredient.class, id);
		Ingredient updatedIngredient = util.getObjectForJSON(ingredient, Ingredient.class);
		if (ingrToUpdate != null) {
			ingrToUpdate.setName(updatedIngredient.getName());
			ingrToUpdate.setCategory(updatedIngredient.getCategory());
			ingrToUpdate.setQuantity(updatedIngredient.getQuantity());
			ingrToUpdate.setThreshold(updatedIngredient.getThreshold());
			ingrToUpdate.setExpiryDate(updatedIngredient.getExpiryDate());
			manager.persist(ingrToUpdate);
			return "{\"message\": \"ingredient successfully updated\"}";
		} else {
			return "{\"message\": \"cannot find this ingredient\"}";
		}
		
	}


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}


	public void setUtil(JSONUtil util) {
		this.util = util;
	}
		
}
