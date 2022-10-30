package guru.springframework.controllers;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {
  RecipeRepository recipeRepository;
  
  
  public IndexController(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }
  
  @RequestMapping({"", "/", "/index"})
  public String getIndexPage(Model model) {
    model.addAttribute("recipes", recipeRepository.findAll());
    return "index";
  }
}
