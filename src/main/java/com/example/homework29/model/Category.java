package com.example.homework29.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originCountry;

    @OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST)
    private Set<Recipe> recipes = new HashSet<>();

    public Category(String originCountry) {
        this.originCountry = originCountry;
      //  this.recipes = recipes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", originCountry='" + originCountry + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
