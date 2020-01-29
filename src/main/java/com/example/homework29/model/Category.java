package com.example.homework29.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String img;
    private String origin;
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST)
    private Set<Recipe> recipes;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public String getImg(){
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
