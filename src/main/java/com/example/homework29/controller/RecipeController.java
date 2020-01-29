package com.example.homework29.controller;

import com.example.homework29.model.Category;
import com.example.homework29.model.Recipe;
import com.example.homework29.repo.CategoryRepository;
import com.example.homework29.repo.RecipeRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class RecipeController {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }



    @GetMapping("/recipe/{id}")
    public String recipe(@PathVariable Long id, Model model){
        Optional<Recipe> recipeByIdOptional = recipeRepository.findById(id);

        if(recipeByIdOptional.isPresent()){
            model.addAttribute("recipe",recipeByIdOptional.get());
            return "recipe";
        }else{
            return "error";
        }
    }

    @GetMapping("/recipe/add")
    public String addRecipeForm(Model model, @RequestParam Long id) {
        Recipe recipe = new Recipe();
        recipe.setCategory(categoryRepository.findById(id).orElse(null));
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("recipe", recipe);
        return "add";
    }


    @PostMapping("/recipe/add")
    public String addRecipeForm(Recipe recipe) {
      recipeRepository.save(recipe);
      return "redirect:/category/" + recipe.getCategory().getId();

    }
    @GetMapping("/recipe/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    @Transactional
    public String editRecipe(Recipe recipe){
       recipeRepository.save(recipe);
        return "redirect:/category/" + recipe.getId();
    }

}
