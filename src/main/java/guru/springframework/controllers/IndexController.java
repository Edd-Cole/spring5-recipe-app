package guru.springframework.controllers;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/1/17.
 */
@Controller
@Slf4j
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
    log.debug("Loading in Recipes");
    model.addAttribute("recipes", recipeRepository.findAll());
    return "index";
  }
}
