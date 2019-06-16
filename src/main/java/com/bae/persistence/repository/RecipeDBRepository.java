package com.bae.persistence.repository;

import javax.enterprise.inject.Default;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Transactional(TxType.SUPPORTS)
@Default
public class RecipeDBRepository implements RecipeRepository {
	
	@Override
	public String getAllRecipes() {
		
		return null;
	}

	@Override
	public String getARecipe(int id) {
		// TODO Auto-generated method stub
		return null;
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
