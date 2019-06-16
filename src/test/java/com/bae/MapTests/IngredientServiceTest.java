package com.bae.MapTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import org.junit.Test;

import com.bae.persistence.domain.Ingredient;
import com.bae.persistence.repository.IngredientMapRepository;
import com.bae.util.JSONUtil;


public class IngredientServiceTest {
	private IngredientMapRepository imr;
	private Ingredient ing1 = new Ingredient(1, "plain flour", "pantry", 10, 5, "13/06/2019");
	private Ingredient ing2 = new Ingredient(2, "egg", "fridge", 100, 10, "13/06/2019");
	private Ingredient ing3 = new Ingredient(3, "red food colouring", "decoration", 2, 1, "13/07/2020");
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
	
	
	@Test
	public void getAnIngredientTest() {
		imr.getIngredientMap().put(1, ing1);
		imr.getIngredientMap().put(2, ing2);
		assertEquals("null", imr.getAnIngredient(5));
	}
	
	
	@Test
	public void getAnIngredientTest1() {
		imr.getIngredientMap().put(1, ing1);
		imr.getIngredientMap().put(2, ing2);
		assertEquals("{\"ingredientId\":1,\"name\":\"plain flour\",\"category\":\"pantry\",\"quantity\":10,\"threshold\":5,\"expiryDate\":\"13/06/2019\"}", imr.getAnIngredient(1));
	}
	
	@Test
	public void addIngredientTest() {
		String newIngr = util.getJSONForObject(ing1);
		assertEquals("Ingredient successfully added", imr.addIngredient(newIngr));
		assertEquals(1, imr.getIngredientMap().size());
	}
	
	@Test
	public void addIngredientTest2() {
		assertEquals("Ingredient successfully added", imr.addIngredient(util.getJSONForObject(ing1)));
		assertEquals("Ingredient successfully added", imr.addIngredient(util.getJSONForObject(ing2)));
		assertEquals(2, imr.getIngredientMap().size());
	}
	
	@Test
	public void removeIngredientTest() {
		imr.getIngredientMap().put(1, ing1);
		imr.removeIngredient(1);
		assertEquals(false, imr.getIngredientMap().containsKey(1));
	}
	
	@Test
	public void removeIngredientTest2() {
		imr.getIngredientMap().put(1, ing1);
		imr.getIngredientMap().put(2, ing2);
		imr.getIngredientMap().put(3, ing3);
		
		imr.removeIngredient(1);
		assertEquals(false, imr.getIngredientMap().containsKey(1));
		imr.removeIngredient(3);
		assertEquals(false, imr.getIngredientMap().containsKey(3));
		assertEquals(true, imr.getIngredientMap().containsKey(2));
		
	}
	 
	@Test
	public void updateIngredientTest() {
		imr.getIngredientMap().put(1, ing1);
		imr.updateIngredient(1, "{\"ingredientId\":1,\"name\":\"plain flour\",\"category\":\"pantry\",\"quantity\":100,\"threshold\":5,\"expiryDate\":\"13/06/2019\"}");
		assertEquals(100, imr.getIngredientMap().get(1).getQuantity()); 
	}
	
	 
}
