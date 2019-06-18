package com.bae.persistence.repository;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.Ingredient;
import com.bae.util.JSONUtil;
import com.bae.util.TestConstants;



@RunWith(MockitoJUnitRunner.class)
public class IngredientDBRepositoryTest {
	
	//class under test
	@InjectMocks
	private IngredientDBRepository ingredientRepo;
	
	//what it requires
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private Ingredient ingr1;
	
	
	@Before
	public void setup() {
		ingredientRepo.setManager(manager);
		util = new JSONUtil();
		ingredientRepo.setUtil(util);
		ingr1 = new Ingredient(1, "plain flour", "pantry", 10, 5, "13/06/2019");
	}
	
	@Test
	public void testGetAllIngredientsTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Ingredient> ingredientList = new ArrayList<>();
		ingredientList.add(ingr1);
		Mockito.when(query.getResultList()).thenReturn(ingredientList);
		Assert.assertEquals(TestConstants.MOCK_DATA_ARRAY, ingredientRepo.getAllIngredients());
	}
	
	@Test
	public void testGetAnIngredient() {
		Mockito.when(manager.find(Ingredient.class, 1)).thenReturn(ingr1);
		Assert.assertEquals(TestConstants.TEST_INGR1_STR, ingredientRepo.getAnIngredient(1));
	}
	
	@Test
	public void testAddIngredient() {
		String reply = ingredientRepo.addIngredient(TestConstants.TEST_INGR1_STR);
		Assert.assertEquals("{\"message\": \"ingredient has been sucessfully added\"}", reply);
	}
	
	@Test
	public void testRemoveIngredientDoesExist() {
		Mockito.when(manager.find(Ingredient.class, 1)).thenReturn(ingr1);
		Mockito.when(manager.contains(ingr1)).thenReturn(true);
		String reply = ingredientRepo.removeIngredient(1);
		Assert.assertEquals("{\"message\": \"ingredient successfully deleted\"}", reply);
		
	}
	
 
	@Test
	public void testRemoveIngredientDoesntExist() {
		String reply = ingredientRepo.removeIngredient(100);
		Assert.assertEquals("{\"message\": \"cannot find this ingredient\"}", reply);
	}
	
	@Test
	public void testUpdateIngredientDoesExist() {
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(ingr1);
		String reply = ingredientRepo.updateIngredient(1, TestConstants.TEST_UPDATED_INGR1_STR);
		Assert.assertEquals("{\"message\": \"ingredient successfully updated\"}", reply);
	}
	
	
	@Test
	public void testUpdateIngredientDoesntExist() {
		String reply = ingredientRepo.updateIngredient(10, TestConstants.TEST_UPDATED_INGR1_STR);
		Assert.assertEquals("{\"message\": \"cannot find this ingredient\"}", reply);
	}
}
