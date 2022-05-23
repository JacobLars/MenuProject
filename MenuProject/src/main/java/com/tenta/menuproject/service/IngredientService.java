package com.tenta.menuproject.service;

import com.tenta.menuproject.dao.IngredientRepository;
import com.tenta.menuproject.model.Course;
import com.tenta.menuproject.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IngredientService {


    private IngredientRepository ingredientRepository;
    private CourseService courseService;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository, CourseService courseService) {
        this.ingredientRepository = ingredientRepository;
        this.courseService = courseService;
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> getAllIngredients() {

        return (List<Ingredient>) ingredientRepository.findAll();
    }

    public Set<Ingredient> showIngredients() {

        List<Course> menu = courseService.randomCourseList();
        Set<Ingredient> ingredients = new HashSet<>();
        for (int i = 0; i < menu.size(); i++) {
            List<Ingredient> ingredientsFromCourse = menu.get(i).getIngredients();
            for (int j = 0; j < ingredientsFromCourse.size(); j++) {
                ingredients.add(ingredientsFromCourse.get(j));
            }
        }
        return ingredients;
    }

}
