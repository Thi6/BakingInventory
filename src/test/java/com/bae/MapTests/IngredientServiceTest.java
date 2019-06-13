package com.bae.MapTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Ingredient;
import com.bae.persistence.repository.IngredientMapRepository;
import com.bae.util.JSONUtil;


public class IngredientServiceTest {
	private IngredientMapRepository imr;
	private Ingredient ing1 = new Ingredient(1, "plain flour", 10, 5, "13/06/2019");
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
		assertEquals("{\"1\":{\"ingredientId\":1,\"name\":\"plain flour\",\"quantity\":10,\"threshold\":5,\"expiryDate\":\"13/06/2019\"}}", imr.getAllIngredients());
	}
	
	 
}
