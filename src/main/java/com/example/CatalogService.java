package com.example;

import java.util.HashMap;
import java.util.Map;

// Микросервис: Каталог и Рецепты
public class CatalogService {
    private Map<String, Integer> ingredientsStock = new HashMap<>();

    public CatalogService() {
        ingredientsStock.put("Мука", 10000);
        ingredientsStock.put("Сахар", 5000);
        ingredientsStock.put("Яйца", 50);
    }

    public boolean checkIngredients(String cakeName) {
        System.out.println("[CatalogService] Проверка ингредиентов для: " + cakeName);
        return ingredientsStock.get("Мука") >= 500 && ingredientsStock.get("Сахар") >= 200 && ingredientsStock.get("Яйца") >= 3;
    }

    public void consumeIngredients(String cakeName) {
        ingredientsStock.put("Мука", ingredientsStock.get("Мука") - 500);
        ingredientsStock.put("Сахар", ingredientsStock.get("Сахар") - 200);
        ingredientsStock.put("Яйца", ingredientsStock.get("Яйца") - 3);
        System.out.println("[CatalogService] Ингредиенты списаны со склада.");
    }

    public double getBasePrice(String cakeName) {
        Recipe recipe = new RecipeProxy(cakeName.hashCode()); // Использование паттерна Proxy
        recipe.getDetails();
        return 2500.0;
    }
}