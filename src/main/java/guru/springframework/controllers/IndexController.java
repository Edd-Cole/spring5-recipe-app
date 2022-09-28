package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {
  
  CategoryRepository categoryRepository;
  UnitOfMeasureRepository unitOfMeasureRepository;
  RecipeRepository recipeRepository;
  
  
  public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
    this.recipeRepository = recipeRepository;
  }
  
  @RequestMapping({"", "/", "/index"})
  public String getIndexPage(Model model) {
    Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
    Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
    
    model.addAttribute("recipes", recipeRepository.findAll());
    model.addAttribute("measures", unitOfMeasureRepository.findAll());
    model.addAttribute("categories", categoryRepository.findAll());
    
    System.out.println("Cat id is: " + categoryOptional.get().getId());
    System.out.println("Uom id is: " + unitOfMeasureOptional.get().getId());
    
    return "index";
  }
}
