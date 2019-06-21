package com.bae.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import com.bae.persistence.domain.Recipe;
import com.bae.util.JSONUtil;
import com.bae.util.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class RecipeDBRepositoryTest {

	@InjectMocks
	private RecipeDBRepository recipeRepo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private Recipe recipe1;
	
	@Before
	public void setup() {
		recipeRepo.setManager(manager);
		util = new JSONUtil();
		recipeRepo.setUtil(util);
		recipe1 = new Recipe(1, "Chocolate Chip Cookie");
	}
	
	@Test
	public void testGetAllRecipes() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Recipe> recipeList = new ArrayList<>();
		recipeList.add(recipe1);
		Mockito.when(query.getResultList()).thenReturn(recipeList);
		Assert.assertEquals(TestConstants.MOCK_DATA_ARRAY_RECIPE, recipeRepo.getAllRecipes());
	}
	
	@Test
	public void testGetARecipe() {
		Mockito.when(manager.find(Recipe.class, 1)).thenReturn(recipe1);
		Assert.assertEquals(TestConstants.TEST_RECIPE1_STR, recipeRepo.getARecipe(1));
	}
	
	@Test
	public void testCreateRecipe() {
		String reply = recipeRepo.createRecipe(TestConstants.TEST_RECIPE1_STR);
		Assert.assertEquals("{\"message\": \"recipe successfully added\"}", reply);	
	}
	
	@Test
	public void testRemoveRecipeDoesExist() {
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(recipe1);
		Mockito.when(manager.contains(recipe1)).thenReturn(true);
		String reply = recipeRepo.removeRecipe(1);
		Assert.assertEquals("{\"message\": \"Recipe successfully removed\"}", reply);
	}
	
	@Test
	public void testRemoveRecipeDoesntExist() {
		String reply = recipeRepo.removeRecipe(59754);
		Assert.assertEquals("{\"message\": \"Cannot find the recipe\"}", reply);
	}
	
	@Test
	public void testUpdateRecipeDoesExist() {
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(recipe1);
		String reply = recipeRepo.updateRecipe(1, TestConstants.TEST_UPDATED_RECIPE1_STR);
		Assert.assertEquals("{\"message\":\"Recipe successfully updated\"}", reply);
	}
	
	@Test
	public void testUpdateRecipeDoesntExist() {
		String reply = recipeRepo.updateRecipe(234, TestConstants.TEST_UPDATED_RECIPE1_STR);
		Assert.assertEquals("{\"message\":\"Cannot find the recipe\"}", reply);
	}
	
}
