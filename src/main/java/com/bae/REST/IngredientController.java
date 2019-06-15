package com.bae.REST;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.IngredientService;

@Path("ingredient")
public class IngredientController {
	
	@Inject
	private IngredientService ingredientService;
	
	@Path("/getAllIngredients")
	@GET
	@Produces({"application/json"})
	public String getAllIngredients() {
		return ingredientService.getAllIngredients();
	}
	
	@Path("/getAnIngredient/{id}")
	@GET
	@Produces({"application/json"})
	public String getAnIngredient(@PathParam("id") int id) {
		return ingredientService.getAnIngredient(id);
	}
	
	@Path("/addIngredient")
	@POST
	@Produces({"application/json"})
	public String addIngredient(String ingredient) {
		return ingredientService.addIngredient(ingredient);
	}
	
	@Path("/removeIngredient/{id}")
	@DELETE
	@Produces({"application/json"})
	public String removeIngredient(@PathParam("id") int id) {
		return ingredientService.removeIngredient(id);
	}
}  
