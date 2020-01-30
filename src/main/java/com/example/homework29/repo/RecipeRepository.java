package com.example.homework29.repo;
import com.example.homework29.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {

//    @Query("UPDATE recipe r where r.id=:r.recipe.getId()")
//    void update(@Param("recipe") Recipe recipe);
}
