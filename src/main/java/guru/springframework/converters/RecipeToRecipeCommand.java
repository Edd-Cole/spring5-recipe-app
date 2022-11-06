package guru.springframework.converters;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import org.springframework.core.convert.converter.Converter;

public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
  
  private final NotesToNotesCommand notesConverter;
  private final IngredientToIngredientCommand ingredientConverter;
  private final CategoryToCategoryCommand categoryConverter;
  
  public RecipeToRecipeCommand(NotesToNotesCommand notesConverter,
                               IngredientToIngredientCommand ingredientConverter,
                               CategoryToCategoryCommand categoryConverter) {
    this.notesConverter = notesConverter;
    this.ingredientConverter = ingredientConverter;
    this.categoryConverter = categoryConverter;
  }
  
  @Override
  public RecipeCommand convert(Recipe source) {
    if (source == null) return null;
    
    final RecipeCommand recipe = new RecipeCommand();
    recipe.setId(source.getId());
    recipe.setDescription(source.getDescription());
    recipe.setPrepTime(source.getPrepTime());
    recipe.setCookTime(source.getCookTime());
    recipe.setServings(source.getServings());
    recipe.setSource(source.getSource());
    recipe.setUrl(source.getUrl());
    recipe.setDirections(source.getDirections());
    recipe.setImage(source.getImage());
    recipe.setDifficulty(source.getDifficulty());
    recipe.setNotes(notesConverter.convert(source.getNotes()));
    
    source.getIngredients()
        .forEach(i -> recipe.getIngredients().add(ingredientConverter.convert(i)));
    source.getCategories()
        .forEach(c -> recipe.getCategories().add(categoryConverter.convert(c)));
    
    recipe.getIngredients().forEach(i -> i.setRecipe(recipe));
    recipe.getCategories().forEach(c -> c.getRecipes().add(recipe));
    return recipe;
  }
}
