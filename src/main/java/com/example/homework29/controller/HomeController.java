package com.example.homework29.controller;


import com.example.homework29.model.Category;
import com.example.homework29.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.homework29.repo.CategoryRepository;
import com.example.homework29.repo.RecipeRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;

    public HomeController(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Category> list = categoryRepository.findAll();
        model.addAttribute("recipes", list);
        return "home";
    }



}
