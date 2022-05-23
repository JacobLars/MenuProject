package com.tenta.menuproject.dao;

import com.tenta.menuproject.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

}
