package com.bae.REST;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.RecipeService;

@Path("/recipe")
public class RecipeController {
	@Inject
	RecipeService recipeService;
	
	@Path("/getAllRecipes")
	@GET
	@Produces({"application/json"})
	public String getAllRecipes() {
		return recipeService.getAllRecipes();
	}
	
	@Path("/getARecipe/{id}")
	@GET
	@Produces({"application/json"})
	public String getARecipe(@PathParam("id") int id) {
		return recipeService.getARecipe(id);
	}
	
	@Path("/createRecipe")
	@POST
	@Produces({"application/json"})
	public String createRecipe(String recipe) {
		return recipeService.createRecipe(recipe);
	}
	
	@Path("/removeRecipe/{id}")
	@DELETE
	@Produces({"application/json"})
	public String removeRecipe(@PathParam("id")  int id) {
		return recipeService.removeRecipe(id);
	}
}
