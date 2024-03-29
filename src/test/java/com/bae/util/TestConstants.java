package com.bae.util;

import com.bae.persistence.domain.Ingredient;

public class TestConstants {
	public static final Ingredient INGREDIENT_1 = new Ingredient(1, "plain flour", "pantry", 10, 5, "13/06/2019");
	public static final Ingredient INGREDIENT_2 = new Ingredient(2, "egg", "fridge", 100, 10, "13/06/2019");
	public static final Ingredient INGREDIENT_3 = new Ingredient(3, "red food colouring", "decoration", 2, 1, "13/07/2020");
	
	public static final String TEST_INGR1_STR = "{\"ingredientId\":1,\"name\":\"plain flour\",\"category\":\"pantry\",\"quantity\":10,\"threshold\":5,\"expiryDate\":\"13/06/2019\"}";
	public static final String TEST_UPDATED_INGR1_STR = "{\"ingredientId\":1,\"name\":\"plain flour\",\"category\":\"pantry\",\"quantity\":100,\"threshold\":5,\"expiryDate\":\"13/06/2019\"}";
	public static final String MOCK_DATA_ARRAY_INGR = "[{\"ingredientId\":1,\"name\":\"plain flour\",\"category\":\"pantry\",\"quantity\":10,\"threshold\":5,\"expiryDate\":\"13/06/2019\"}]";
	public static final String ADD_INGR_SUCCESSFUL = "Ingredient successfully added";
	
	public static final String MOCK_DATA_ARRAY_RECIPE = "[{\"recipeId\":1,\"name\":\"Chocolate Chip Cookie\"}]";
	public static final String TEST_RECIPE1_STR = "{\"recipeId\":1,\"name\":\"Chocolate Chip Cookie\"}";
	public static final String TEST_UPDATED_RECIPE1_STR = "{\"recipeId\":1,\"name\":\"Brownies\"}";
	
}
