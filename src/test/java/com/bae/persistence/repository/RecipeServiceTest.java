package com.bae.persistence.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.RecipeMapRepository;
import com.bae.util.JSONUtil;
import com.bae.util.TestConstants;
 
public class RecipeServiceTest {
	private RecipeMapRepository rmr;
	private Recipe recipe1 = new Recipe(1, "Chocolate Chip Cookie");
	private Recipe recipe2 = new Recipe(2, "Carrot Cake");
	
	private JSONUtil util = new JSONUtil();
	
	@Before
	public void setup() {
		rmr = new RecipeMapRepository();
	}
	
	@Test
	public void getAllRecipesEmptyTest() {
		assertEquals("{}", rmr.getAllRecipes());
	}
	
	@Test
	public void getAllRecipesNotEmptyTest() {
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
	
	@Test
	public void createRecipeTest() {
		String newRecipe = util.getJSONForObject(recipe1);
		assertEquals("Recipe successfully added", rmr.createRecipe(newRecipe));
		assertEquals(1, rmr.getRecipeMap().size());
	}
	
	@Test
	public void createRecipeTest2( ) {
		String newRecipe1 = util.getJSONForObject(recipe1);
		String newRecipe2 = util.getJSONForObject(recipe2);
		assertEquals("Recipe successfully added", rmr.createRecipe(newRecipe1));
		assertEquals("Recipe successfully added", rmr.createRecipe(newRecipe2));
		assertEquals(2, rmr.getRecipeMap().size());
	}
	
	@Test
	public void removeRecipeTest() {
		rmr.getRecipeMap().put(1, recipe1);
		rmr.removeRecipe(1);
		assertEquals(false, rmr.getRecipeMap().containsKey(1));
	}
	
	@Test
	public void removeRecipeTest2() {
		rmr.getRecipeMap().put(1, recipe1);
		rmr.getRecipeMap().put(2, recipe2);
				
		rmr.removeRecipe(1);
		assertEquals(false, rmr.getRecipeMap().containsKey(1));
		rmr.removeRecipe(2);
		assertEquals(false, rmr.getRecipeMap().containsKey(2));
	}
	
	@Test
	public void removeRecipeTest3() {
	// remove one recipe that exists and one that does not
		rmr.getRecipeMap().put(1, recipe1);
		rmr.getRecipeMap().put(2, recipe2);
				
		rmr.removeRecipe(1);
		assertEquals(false, rmr.getRecipeMap().containsKey(1));
		rmr.removeRecipe(3);
		assertEquals(false, rmr.getRecipeMap().containsKey(3));
	}
	
		
	@Test
	public void updateRecipeDoesExistTest() {
		rmr.getRecipeMap().put(1, recipe1);
		rmr.updateRecipe(1, "{\"recipeId\":1,\"name\":\"Triple Chocolate Cookie\"}");
		assertEquals("Triple Chocolate Cookie", rmr.getRecipeMap().get(1).getName());
	}
	
	@Test
	public void updateRecipeDoesntExistTest() {
		assertEquals("Cannot find the recipe", rmr.updateRecipe(1123, TestConstants.TEST_UPDATED_RECIPE1_STR)); 
	}
	
	
}
