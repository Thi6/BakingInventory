package com.bae.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.RecipeRepository;
import com.bae.util.TestConstants;


@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceImplementationTest {
	
	@InjectMocks
	private RecipeServiceImplementation recipeServiceImp;
	
	@Mock
	private RecipeRepository recipeRepo;
	
	@Test
	public void getAllRecipesWhenNotEmptyTest() {
		Mockito.when(recipeRepo.getAllRecipes()).thenReturn(TestConstants.MOCK_DATA_ARRAY_RECIPE);
		assertEquals(TestConstants.MOCK_DATA_ARRAY_RECIPE, recipeServiceImp.getAllRecipes());
	}
	
	@Test
	public void getAllRecipesWhenEmptyTest() {
		Mockito.when(recipeRepo.getAllRecipes()).thenReturn("{}");
		assertEquals("{}", recipeServiceImp.getAllRecipes());
	}
	
	@Test
	public void getARecipeTest() {
		Mockito.when(recipeRepo.getARecipe(Mockito.anyInt())).thenReturn(TestConstants.TEST_RECIPE1_STR);
		assertEquals(TestConstants.TEST_RECIPE1_STR, recipeServiceImp.getARecipe(1));
	}
	
	@Test
	public void createRecipeTest() {
		Mockito.when(recipeRepo.createRecipe(TestConstants.TEST_RECIPE1_STR)).thenReturn(TestConstants.TEST_RECIPE1_STR);
		assertEquals(TestConstants.TEST_RECIPE1_STR, recipeServiceImp.createRecipe(TestConstants.TEST_RECIPE1_STR));
	}
	
}
