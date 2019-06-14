package com.bae.MapTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bae.persistence.domain.Ingredient;
import com.bae.persistence.repository.IngredientMapRepository;
import com.bae.util.JSONUtil;


public class IngredientServiceTest {
	private IngredientMapRepository imr;
	private Ingredient ing1 = new Ingredient(1, "plain flour", "pantry", 10, 5, "13/06/2019");
	private Ingredient ing2 = new Ingredient(2, "egg", "fridge", 100, 10, "13/06/2019");
	private JSONUtil util = new JSONUtil();
	
	@Before
	public void setup() {
		imr = new IngredientMapRepository();
	}
	
	@Test
	public void getAllIngredientsTest() {
		assertEquals("{}", imr.getAllIngredients());
	}
	
	@Test
	public void getAllIngredientsTest1() {
		imr.getIngredientMap().put(1, ing1);
		assertEquals("{\"1\":{\"ingredientId\":1,\"name\":\"plain flour\",\"category\":\"pantry\",\"quantity\":10,\"threshold\":5,\"expiryDate\":\"13/06/2019\"}}", imr.getAllIngredients());
	}
	
	@Ignore
	@Test
	public void getAnIngredientTest() {
		imr.getIngredientMap().put(1, ing1);
		imr.getIngredientMap().put(2, ing2);
		assertEquals("This ingredient does not exist", imr.getAnIngredient(5));
	}
	
	
	@Test
	public void getAnIngredientTest1() {
		imr.getIngredientMap().put(1, ing1);
		imr.getIngredientMap().put(2, ing2);
		assertEquals("{\"ingredientId\":1,\"name\":\"plain flour\",\"category\":\"pantry\",\"quantity\":10,\"threshold\":5,\"expiryDate\":\"13/06/2019\"}", imr.getAnIngredient(1));
	}
	
	
	
	 
}
