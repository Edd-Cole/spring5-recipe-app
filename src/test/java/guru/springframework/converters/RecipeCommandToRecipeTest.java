package guru.springframework.converters;

import guru.springframework.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static guru.springframework.converters.testdata.TestData.CATEGORY;
import static guru.springframework.converters.testdata.TestData.CATEGORY_COMMAND;
import static guru.springframework.converters.testdata.TestData.COOK_TIME;
import static guru.springframework.converters.testdata.TestData.DESCRIPTION;
import static guru.springframework.converters.testdata.TestData.DIFFICULTY;
import static guru.springframework.converters.testdata.TestData.ID;
import static guru.springframework.converters.testdata.TestData.IMAGE;
import static guru.springframework.converters.testdata.TestData.INGREDIENT;
import static guru.springframework.converters.testdata.TestData.INGREDIENT_COMMAND;
import static guru.springframework.converters.testdata.TestData.NOTES;
import static guru.springframework.converters.testdata.TestData.NOTES_COMMAND;
import static guru.springframework.converters.testdata.TestData.PREP_TIME;
import static guru.springframework.converters.testdata.TestData.RECIPE_COMMAND;
import static guru.springframework.converters.testdata.TestData.SERVINGS;
import static guru.springframework.converters.testdata.TestData.SOURCE;
import static guru.springframework.converters.testdata.TestData.URL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class RecipeCommandToRecipeTest {
  @Mock
  NotesCommandToNotes notesConverter;
  @Mock
  IngredientCommandToIngredient ingredientConverter;
  @Mock
  CategoryCommandToCategory categoryConverter;
  RecipeCommandToRecipe converter;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    converter = new RecipeCommandToRecipe(notesConverter, ingredientConverter, categoryConverter);
    when(notesConverter.convert(NOTES_COMMAND)).thenReturn(NOTES);
    when(ingredientConverter.convert(INGREDIENT_COMMAND)).thenReturn(INGREDIENT);
    when(categoryConverter.convert(CATEGORY_COMMAND)).thenReturn(CATEGORY);
  }
  
  @Test
  public void givenNull_whenConvertInvoked_thenReturnNull() {
    assertThat(converter.convert(null)).isNull();
  }
  
  @Test
  public void givenRecipeCommand_whenConvertInvoked_thenReturnRecipe() {
    assertThat(converter.convert(RECIPE_COMMAND))
        .returns(ID, Recipe::getId)
        .returns(DESCRIPTION, Recipe::getDescription)
        .returns(PREP_TIME, Recipe::getPrepTime)
        .returns(COOK_TIME, Recipe::getCookTime)
        .returns(SERVINGS, Recipe::getServings)
        .returns(SOURCE, Recipe::getSource)
        .returns(URL, Recipe::getUrl)
        .returns(Set.of(INGREDIENT), Recipe::getIngredients)
        .returns(IMAGE, Recipe::getImage)
        .returns(NOTES, Recipe::getNotes)
        .returns(Set.of(CATEGORY), Recipe::getCategories)
        .returns(DIFFICULTY, Recipe::getDifficulty);
  }
  
  @Test
  public void givenRecipeCommand_whenConvertInvoked_thenInitialiseRecipeInsideMappedProperties() {
    Recipe recipe = converter.convert(RECIPE_COMMAND);
    assertThat(recipe)
        .returns(recipe, r -> r.getNotes().getRecipe());
    assertThat(recipe)
        .returns(true, r -> r.getIngredients().stream().allMatch(i -> i.getRecipe().equals(recipe)))
        .returns(true, r -> r.getCategories().stream().allMatch(c -> c.getRecipes().contains(recipe)));
  }
  
}