package com.bae.REST;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bae.business.IngredientService;

@Path("ingredient")
public class IngredientController {
	
	@Inject
	private IngredientService ingredientService;
	
	@Path("getAllIngredients")
	@GET
	@Produces({"application/json"})
	public String getAllIngredients() {
		return ingredientService.getAllIngredients();
	}
	
}  
