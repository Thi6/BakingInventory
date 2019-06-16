package com.bae.MapTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.RecipeMapRepository;
import com.bae.util.JSONUtil;

public class RecipeServiceTest {
	private RecipeMapRepository rmr;
	private Recipe recipe1 = new Recipe(1, "Chocolate Chip Cookie");
	private Recipe recipe2 = new Recipe(2, "Carrot Cake");
	private Recipe recipe3 = new Recipe(3, "Red Velvet Cupcake");
	private JSONUtil util = new JSONUtil();
	
	@Before
	public void setup() {
		rmr = new RecipeMapRepository();
	}
	
	@Test
	public void getAllRecipesTest() {
		assertEquals("{}", rmr.getAllRecipes());
	}
	
	@Test
	public void getAllRecipesTest2() {
		rmr.getRecipeMap().put(1, recipe1);
		assertEquals("{\"1\":{\"recipeId\":1,\"name\":\"Chocolate Chip Cookie\"}}", rmr.getAllRecipes());
	}
	
	@Test
	public void getAllRecipesTest3() {
		rmr.getRecipeMap().put(1, recipe1);
		rmr.getRecipeMap().put(2, recipe2);
		assertEquals("{\"1\":{\"recipeId\":1,\"name\":\"Chocolate Chip Cookie\"},\"2\":{\"recipeId\":2,\"name\":\"Carrot Cake\"}}", rmr.getAllRecipes());
	}
	
	@Test
	public void getARecipeTest() {
		rmr.getRecipeMap().put(1, recipe1);
		rmr.getRecipeMap().put(2, recipe2);
		assertEquals("null", rmr.getARecipe(3));
	}
	
	@Test
	public void getARecipeTest2() {
		rmr.getRecipeMap().put(1, recipe1);
		rmr.getRecipeMap().put(2, recipe2);
		assertEquals("{\"recipeId\":1,\"name\":\"Chocolate Chip Cookie\"}", rmr.getARecipe(1));
	}
}
