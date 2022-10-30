package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
  
  private final CategoryRepository categoryRepository;
  private final RecipeRepository recipeRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;
  
  public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
    this.categoryRepository = categoryRepository;
    this.recipeRepository = recipeRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }
  
  @Override
  @Transactional
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    recipeRepository.saveAll(getRecipes());
  }
  
  private List<Recipe> getRecipes() {
    List<Recipe> recipes = new ArrayList<>(2);
    Map<String, UnitOfMeasure> uomMap = new HashMap<>();
    unitOfMeasureRepository.findAll().iterator().forEachRemaining(uom -> uomMap.put(uom.getDescription(), uom));
    
    Map<String, Category> categoryMap = new HashMap<>();
    categoryRepository.findAll().iterator().forEachRemaining(category -> categoryMap.put(category.getDescription(), category));
    
    Recipe guac = new Recipe();
    guac.setDescription("Perfect Guacamole");
    guac.setPrepTime(10);
    guac.setCookTime(0);
    guac.setDifficulty(Difficulty.EASY);
    guac.setDirections("Make Guacamole!");
  
    Notes guacNotes = new Notes();
    guac.setNotes(guacNotes);
    
    guac.addIngredient(new Ingredient("Avocado", new BigDecimal(2), uomMap.get("Each")));
    guac.addIngredient(new Ingredient("Kosher Salt", new BigDecimal("0.5"), uomMap.get("Teaspoon")));
    guac.addIngredient(new Ingredient("Lime Juice", new BigDecimal(2), uomMap.get("Tablespoon")));
    guac.addIngredient(new Ingredient("Red Onion", new BigDecimal(2), uomMap.get("Tablespoon")));
    guac.addIngredient(new Ingredient("Serrano Chili", new BigDecimal(2), uomMap.get("Each")));
    guac.addIngredient(new Ingredient("Coriander", new BigDecimal(2), uomMap.get("Tablespoon")));
    guac.addIngredient(new Ingredient("Black Pepper", new BigDecimal(2), uomMap.get("Dash")));
    guac.addIngredient(new Ingredient("Tomato", new BigDecimal("0.5"), uomMap.get("Each")));
  
    guac.addCategory(categoryMap.get("American"));
    guac.addCategory(categoryMap.get("Mexican"));
    
    recipes.add(guac);
    
    Recipe tacos = new Recipe();
    
    tacos.setDescription("Spicy Tacos");
    tacos.setPrepTime(20);
    tacos.setCookTime(9);
    tacos.setDifficulty(Difficulty.MODERATE);
    tacos.setDirections("Make Tacos!");
    
    Notes tacoNotes = new Notes();
    tacos.setNotes(tacoNotes);
    
    tacos.addIngredient(new Ingredient("Chili Powder", new BigDecimal(2), uomMap.get("Tablespoon")));
    tacos.addIngredient(new Ingredient("Oregano", new BigDecimal(1), uomMap.get("Teaspoon")));
    tacos.addIngredient(new Ingredient("Cumin", new BigDecimal(1), uomMap.get("Teaspoon")));
    tacos.addIngredient(new Ingredient("Sugar", new BigDecimal(1), uomMap.get("Teaspoon")));
    tacos.addIngredient(new Ingredient("Salt", new BigDecimal("0.5"), uomMap.get("Teaspoon")));
    tacos.addIngredient(new Ingredient("Garlic Clove", new BigDecimal(1), uomMap.get("Each")));
    tacos.addIngredient(new Ingredient("Orange Zest", new BigDecimal(1), uomMap.get("Tablespoon")));
    tacos.addIngredient(new Ingredient("Orange Juice", new BigDecimal(3), uomMap.get("Tablespoon")));
    tacos.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), uomMap.get("Tablespoon")));
    tacos.addIngredient(new Ingredient("Chicken Thigh Fillet", new BigDecimal(4), uomMap.get("Each")));
    tacos.addIngredient(new Ingredient("Taco Shell", new BigDecimal(8), uomMap.get("Each")));
    tacos.addIngredient(new Ingredient("Arugula", new BigDecimal(3), uomMap.get("Cups")));
    tacos.addIngredient(new Ingredient("Avocado", new BigDecimal(2), uomMap.get("Each")));
    tacos.addIngredient(new Ingredient("Radish", new BigDecimal(4), uomMap.get("Each")));
    tacos.addIngredient(new Ingredient("Tomatoes", new BigDecimal("0.5"), uomMap.get("Pint")));
    tacos.addIngredient(new Ingredient("Red Onion", new BigDecimal(2), uomMap.get("Each")));
    tacos.addIngredient(new Ingredient("Coriander", new BigDecimal(4), uomMap.get("Each")));
    tacos.addIngredient(new Ingredient("Sour Cream", new BigDecimal(4), uomMap.get("Cups")));
    tacos.addIngredient(new Ingredient("Lime", new BigDecimal(4), uomMap.get("Each")));
    
    tacos.addCategory(categoryMap.get("American"));
    tacos.addCategory(categoryMap.get("Mexican"));
  
    recipes.add(tacos);
    
    return recipes;
  }
  

}
