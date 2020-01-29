package com.example.homework29.controller;

import com.example.homework29.model.Category;
import com.example.homework29.repo.CategoryRepository;
import com.example.homework29.repo.RecipeRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public class CategoryController {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;

    public CategoryController(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/cateogry/{id}")
    public String home(Model model, @PathVariable() Long id){
        List<Category> recipesByCategory = categoryRepository.findAll();
        model.addAttribute("categories",recipesByCategory);
        return "category";
    }
}
