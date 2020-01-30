package com.example.homework29.controller;

import com.example.homework29.model.Category;
import com.example.homework29.model.Recipe;
import com.example.homework29.repo.CategoryRepository;
import com.example.homework29.repo.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
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
    @Transactional
    public String addRecipeForm(Model model) {
        Recipe recipe = new Recipe();
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories",categoryList);
        List<Recipe> recipes = recipeRepository.findAll();
        model.addAttribute("recipe", recipes);
        recipe.setCategory((Category) categoryRepository.findAll());
        return "add";
    }


    @PostMapping("/recipe/add")
    @Transactional
    public String addRecipeForm(Recipe recipe) {
      recipeRepository.save(recipe);
      return "redirect:/home/" + recipe.getId();

    }


    @GetMapping("/recipe/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/edit")
    @Transactional
    public String editRecipeForm(Recipe recipe) {

        recipeRepository.save(recipe);
        return "redirect:/home/" ;

    }

    @GetMapping("/edit/{id}")
    @Transactional
    public String editRecipe(@PathVariable Long id, Model model){
        Optional<Recipe> recipes = recipeRepository.findById(id);
        model.addAttribute("categories",recipes);

        if(recipes.isPresent()){
           recipes.get();
            model.addAttribute("recipe",recipes);
            return "edit";
        }else{
            return "error";
        }
    }

}
