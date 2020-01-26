package com.example.homework29.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Description")
    private String description;
    @Column(name = "CookRecipe")
    private String cookRecipe;

    @OneToMany(mappedBy = "recipe")
    @Column(name = "recipeCategory")
    private Category category;

    public Recipe(String description, String cookRecipe, Category category) {
        this.description = description;
        this.cookRecipe = cookRecipe;
        this.category = category;
    }

    public Recipe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCookRecipe() {
        return cookRecipe;
    }

    public void setCookRecipe(String cookRecipe) {
        this.cookRecipe = cookRecipe;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}