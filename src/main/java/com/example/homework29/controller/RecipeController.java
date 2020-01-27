package com.example.homework29.controller;

import com.example.homework29.model.Recipe;
import com.example.homework29.repo.RecipeRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Optional;

public class RecipeController {

    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/recipe/{id}")
    public String recipe(@PathVariable Long id, Model model){
        Optional<Recipe> recipeByIdOptional = recipeRepository.findById(id);

        if(recipeByIdOptional.isPresent()){
            model.addAttribute("recipe",recipeByIdOptional.get());
            return "home";
        }else{
            return "error";
        }

    }
}
