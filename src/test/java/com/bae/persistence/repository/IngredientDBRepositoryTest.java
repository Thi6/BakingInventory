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
	
	
	@Before
	public void setup() {
		ingredientRepo.setManager(manager);
		util = new JSONUtil();
		ingredientRepo.setUtil(util);
	}
	
	@Test
	public void testGetAllIngredientsTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Ingredient> ingredientList = new ArrayList<>();
		ingredientList.add(TestConstants.INGREDIENT_1);
		Mockito.when(query.getResultList()).thenReturn(ingredientList);
		Assert.assertEquals(TestConstants.MOCK_DATA_ARRAY, ingredientRepo.getAllIngredients());
	}
	
	@Test
	public void testGetAnIngredient() {
		
	}
	
	@Test
	public void testAddIngredient() {
		
	}
}
