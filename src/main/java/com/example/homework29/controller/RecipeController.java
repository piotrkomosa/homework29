package com.example.homework29.controller;


import com.example.homework29.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.homework29.repo.CategoryRepository;
import com.example.homework29.repo.RecipeRepository;

import java.util.List;

@Controller
public class RecipeController {
//    @Autowired
//    private CategoryRepository categoryRepository;
//    private RecipeRepository recipeRepository;
//
//    public RecipeController(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
//        this.categoryRepository = categoryRepository;
//        this.recipeRepository = recipeRepository;
//    }
//
//    @PostMapping("/save")
//    public String saveRecipe(@ModelAttribute Recipe recipe){
//        recipeRepository.save(recipe);
//        return "/";
//
//    }
//
//    @GetMapping("/showAll")
//    public String showAll(Model model) {
//        List<Recipe> allRecipes = recipeRepository.findAll();
//        model.addAttribute("allRecipes", allRecipes);
//        return "allRecipes";
//    }
}
