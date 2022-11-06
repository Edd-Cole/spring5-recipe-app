package guru.springframework.converters;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import org.springframework.core.convert.converter.Converter;

public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
  
  private final NotesCommandToNotes notesConverter;
  private final IngredientCommandToIngredient ingredientConverter;
  private final CategoryCommandToCategory categoryConverter;
  
  public RecipeCommandToRecipe(NotesCommandToNotes notesConverter,
                               IngredientCommandToIngredient ingredientConverter,
                               CategoryCommandToCategory categoryConverter) {
    this.notesConverter = notesConverter;
    this.ingredientConverter = ingredientConverter;
    this.categoryConverter = categoryConverter;
  }
  
  @Override
  public Recipe convert(RecipeCommand source) {
    if (source == null) return null;
    
    Recipe recipe = new Recipe();
    recipe.setId(source.getId());
    recipe.setDescription(source.getDescription());
    recipe.setPrepTime(source.getPrepTime());
    recipe.setCookTime(source.getCookTime());
    recipe.setServings(source.getServings());
    recipe.setSource(source.getSource());
    recipe.setUrl(source.getUrl());
    recipe.setImage(source.getImage());
    recipe.setNotes(notesConverter.convert(source.getNotes()));
    recipe.setDifficulty(source.getDifficulty());
    
    source.getIngredients().forEach(i -> recipe.getIngredients().add(ingredientConverter.convert(i)));
    source.getCategories().forEach(c -> recipe.getCategories().add(categoryConverter.convert(c)));
    
    recipe.getIngredients().forEach(i -> i.setRecipe(recipe));
    recipe.getCategories().forEach(c -> c.getRecipes().add(recipe));
    
    return recipe;
  }
}
