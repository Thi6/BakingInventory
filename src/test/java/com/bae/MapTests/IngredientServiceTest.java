package com.bae.MapTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import org.junit.Test;

import com.bae.persistence.domain.Ingredient;
import com.bae.persistence.repository.IngredientMapRepository;
import com.bae.util.JSONUtil;
import com.bae.util.TestConstants;


public class IngredientServiceTest {
	private IngredientMapRepository imr;
	
	private JSONUtil util = new JSONUtil();
	
	@Before 
	public void setup() {
		imr = new IngredientMapRepository();
	}
	
	@Test
	public void getAllWhenIngrMapIsEmptyTest() {
		assertEquals("{}", imr.getAllIngredients());
	}
	
	@Test
	public void getAllWhenOneInIngrMapTest() {
		imr.getIngredientMap().put(1, TestConstants.INGREDIENT_1);
		assertEquals("{\"1\":{\"ingredientId\":1,\"name\":\"plain flour\",\"category\":\"pantry\",\"quantity\":10,\"threshold\":5,\"expiryDate\":\"13/06/2019\"}}", imr.getAllIngredients());
	}
	
	  
	@Test
	public void getIngredientNotInMapTest() {
		imr.getIngredientMap().put(1, TestConstants.INGREDIENT_1);
		imr.getIngredientMap().put(2,  TestConstants.INGREDIENT_2);
		assertEquals("null", imr.getAnIngredient(5));
	}
	
	
	@Test
	public void getAnIngredientTest() {
		imr.getIngredientMap().put(1, TestConstants.INGREDIENT_1);
		imr.getIngredientMap().put(2, TestConstants.INGREDIENT_2);
		assertEquals(TestConstants.TEST_INGR1_STR, imr.getAnIngredient(1));
	}
	
	@Test
	public void addIngredientTest() {
		String newIngr = util.getJSONForObject(TestConstants.INGREDIENT_1);
		assertEquals(TestConstants.ADD_INGR_SUCCESSFUL, imr.addIngredient(newIngr));
		assertEquals(1, imr.getIngredientMap().size());
	}
	
	@Test
	public void addIngredientTest2() {
		assertEquals(TestConstants.ADD_INGR_SUCCESSFUL, imr.addIngredient(util.getJSONForObject(TestConstants.INGREDIENT_1)));
		assertEquals(TestConstants.ADD_INGR_SUCCESSFUL, imr.addIngredient(util.getJSONForObject(TestConstants.INGREDIENT_2)));
		assertEquals(2, imr.getIngredientMap().size());
	}
	
	@Test
	public void removeIngredientTest() {
		imr.getIngredientMap().put(1, TestConstants.INGREDIENT_1);
		imr.removeIngredient(1);
		assertEquals(false, imr.getIngredientMap().containsKey(1));
	}
	
	@Test
	public void removeIngredientTest2() {
		imr.getIngredientMap().put(1, TestConstants.INGREDIENT_1);
		imr.getIngredientMap().put(2, TestConstants.INGREDIENT_2);
		imr.getIngredientMap().put(3, TestConstants.INGREDIENT_3);
		
		imr.removeIngredient(1);
		assertEquals(false, imr.getIngredientMap().containsKey(1));
		imr.removeIngredient(3);
		assertEquals(false, imr.getIngredientMap().containsKey(3));
		assertEquals(true, imr.getIngredientMap().containsKey(2));
	} 
	
	@Test
	public void removeIngredientTest3() {
		//remove one ingredient that exists and one that doesn't
		imr.getIngredientMap().put(1, TestConstants.INGREDIENT_1);
		imr.getIngredientMap().put(2, TestConstants.INGREDIENT_2);
				
		imr.removeIngredient(1);
		assertEquals(false, imr.getIngredientMap().containsKey(1));
		imr.removeIngredient(3);
		assertEquals(false, imr.getIngredientMap().containsKey(3));
	} 
	 
	@Test
	public void updateIngredientTest() {
		imr.getIngredientMap().put(1, TestConstants.INGREDIENT_1);
		imr.updateIngredient(1, TestConstants.TEST_UPDATED_INGR1_STR);
		assertEquals(100, imr.getIngredientMap().get(1).getQuantity()); 
	}
	
	 
}
