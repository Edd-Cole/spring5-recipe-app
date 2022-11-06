package guru.springframework.converters.testdata;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.NotesCommand;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TestData {
  
  // BASE DATA
  public static final Long ID = 13456L;
  public static final String DESCRIPTION = "TEST-DESCRIPTION";
  public static final String RECIPE_NOTES = "TEST-NOTES";
  public static final String DIRECTIONS = "TEST-DIRECTIONS";
  public static final String SOURCE = "TEST-SOURCE";
  public static final String URL = "TEST-URL";
  public static final Integer COOK_TIME = 1780;
  public static final Integer PREP_TIME = 503;
  public static final Integer SERVINGS = 61;
  public static final BigDecimal AMOUNT = new BigDecimal("2.5");
  public static final Byte[] IMAGE = {1, 0, 1, 1, 0, 1};
  public static final Difficulty DIFFICULTY = Difficulty.KIND_OF_HARD;
  
  // UOM's
  private static UnitOfMeasure getUOM() {
    UnitOfMeasure uom = new UnitOfMeasure();
    uom.setId(ID);
    uom.setDescription(DESCRIPTION);
    return uom;
  }
  
  public static final UnitOfMeasure UNIT_OF_MEASURE = getUOM();
  
  private static UnitOfMeasureCommand getUOMCommand() {
    UnitOfMeasureCommand uom = new UnitOfMeasureCommand();
    uom.setId(ID);
    uom.setDescription(DESCRIPTION);
    return uom;
  }
  
  public static final UnitOfMeasureCommand UNIT_OF_MEASURE_COMMAND = getUOMCommand();
  
  // NOTES
  private static Notes getNotes() {
    Notes notes = new Notes();
    notes.setId(ID);
    notes.setRecipeNotes(RECIPE_NOTES);
    
    return notes;
  }
  
  public static final Notes NOTES = getNotes();
  
  private static NotesCommand getNotesCommand() {
    NotesCommand notes = new NotesCommand();
    notes.setId(ID);
    notes.setRecipeNotes(RECIPE_NOTES);
    
    return notes;
  }
  
  public static final NotesCommand NOTES_COMMAND = getNotesCommand();
  
  // CATEGORIES
  private static Category getCategory() {
    Category category = new Category();
    category.setId(ID);
    category.setDescription(DESCRIPTION);
    
    return category;
  }
  
  public static final Category CATEGORY = getCategory();
  
  private static CategoryCommand getCategoryCommand() {
    CategoryCommand category = new CategoryCommand();
    category.setId(ID);
    category.setDescription(DESCRIPTION);
    
    return category;
  }
  
  public static final CategoryCommand CATEGORY_COMMAND = getCategoryCommand();
  
  // INGREDIENTS
  private static Ingredient getIngredient() {
    Ingredient ingredient = new Ingredient();
    ingredient.setId(ID);
    ingredient.setDescription(DESCRIPTION);
    ingredient.setAmount(AMOUNT);
    ingredient.setUom(UNIT_OF_MEASURE);
    
    return ingredient;
  }
  
  public static final Ingredient INGREDIENT = getIngredient();
  
  private static IngredientCommand getIngredientCommand() {
    IngredientCommand ingredient = new IngredientCommand();
    ingredient.setId(ID);
    ingredient.setDescription(DESCRIPTION);
    ingredient.setAmount(AMOUNT);
    ingredient.setUom(UNIT_OF_MEASURE_COMMAND);
    
    return ingredient;
  }
  
  public static final IngredientCommand INGREDIENT_COMMAND = getIngredientCommand();
  
  // RECIPES
  private static Recipe getRecipe() {
    Set<Category> categories = new HashSet<>();
    categories.add(CATEGORY);
    Set<Ingredient> ingredients = new HashSet<>();
    ingredients.add(INGREDIENT);
    
    Recipe recipe = new Recipe();
    recipe.setId(ID);
    recipe.setDirections(DIRECTIONS);
    recipe.setCookTime(COOK_TIME);
    recipe.setPrepTime(PREP_TIME);
    recipe.setServings(SERVINGS);
    recipe.setSource(SOURCE);
    recipe.setUrl(URL);
    recipe.setDescription(DESCRIPTION);
    recipe.setImage(IMAGE);
    recipe.setDifficulty(DIFFICULTY);
    recipe.setCategories(categories);
    recipe.setIngredients(ingredients);
    recipe.setNotes(NOTES);
  
    Set<Recipe> recipes = new HashSet<>();
    recipes.add(recipe);
  
    NOTES.setRecipe(recipe);
    INGREDIENT.setRecipe(recipe);
    CATEGORY.setRecipes(recipes);
    return recipe;
  }
  
  public static final Recipe RECIPE = getRecipe();
  
  private static RecipeCommand getRecipeCommand() {
    Set<CategoryCommand> categories = new HashSet<>();
    categories.add(CATEGORY_COMMAND);
    Set<IngredientCommand> ingredients = new HashSet<>();
    ingredients.add(INGREDIENT_COMMAND);
  
    RecipeCommand recipe = new RecipeCommand();
    recipe.setId(ID);
    recipe.setDirections(DIRECTIONS);
    recipe.setCookTime(COOK_TIME);
    recipe.setPrepTime(PREP_TIME);
    recipe.setServings(SERVINGS);
    recipe.setSource(SOURCE);
    recipe.setUrl(URL);
    recipe.setDescription(DESCRIPTION);
    recipe.setImage(IMAGE);
    recipe.setDifficulty(DIFFICULTY);
    recipe.setCategories(categories);
    recipe.setIngredients(ingredients);
    recipe.setNotes(NOTES_COMMAND);
  
    Set<RecipeCommand> recipes = new HashSet<>();
    recipes.add(recipe);
  
    NOTES_COMMAND.setRecipe(recipe);
    INGREDIENT_COMMAND.setRecipe(recipe);
    CATEGORY_COMMAND.setRecipes(recipes);
    return recipe;
  }
  
  public static final RecipeCommand RECIPE_COMMAND = getRecipeCommand();
  
}
