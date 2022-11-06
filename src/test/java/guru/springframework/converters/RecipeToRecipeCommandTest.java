package guru.springframework.converters;

import guru.springframework.commands.RecipeCommand;
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
import static guru.springframework.converters.testdata.TestData.DIRECTIONS;
import static guru.springframework.converters.testdata.TestData.ID;
import static guru.springframework.converters.testdata.TestData.IMAGE;
import static guru.springframework.converters.testdata.TestData.INGREDIENT;
import static guru.springframework.converters.testdata.TestData.INGREDIENT_COMMAND;
import static guru.springframework.converters.testdata.TestData.NOTES;
import static guru.springframework.converters.testdata.TestData.NOTES_COMMAND;
import static guru.springframework.converters.testdata.TestData.PREP_TIME;
import static guru.springframework.converters.testdata.TestData.RECIPE;
import static guru.springframework.converters.testdata.TestData.RECIPE_COMMAND;
import static guru.springframework.converters.testdata.TestData.SERVINGS;
import static guru.springframework.converters.testdata.TestData.SOURCE;
import static guru.springframework.converters.testdata.TestData.URL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class RecipeToRecipeCommandTest {
  @Mock
  NotesToNotesCommand notesConverter;
  @Mock
  IngredientToIngredientCommand ingredientConverter;
  @Mock
  CategoryToCategoryCommand categoryConverter;
  RecipeToRecipeCommand converter;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    converter = new RecipeToRecipeCommand(notesConverter, ingredientConverter, categoryConverter);
    when(notesConverter.convert(NOTES)).thenReturn(NOTES_COMMAND);
    when(ingredientConverter.convert(INGREDIENT)).thenReturn(INGREDIENT_COMMAND);
    when(categoryConverter.convert(CATEGORY)).thenReturn(CATEGORY_COMMAND);
  }
  
  @Test
  public void givenNull_whenConvertInvoked_thenReturnNull() {
    assertThat(converter.convert(null)).isNull();
  }
  
  @Test
  public void givenRecipe_whenConvertInvoked_thenReturnRecipeCommand() {
    RecipeCommand recipeCommand = converter.convert(RECIPE);
    assertThat(recipeCommand)
        .returns(ID, RecipeCommand::getId)
        .returns(DESCRIPTION, RecipeCommand::getDescription)
        .returns(PREP_TIME, RecipeCommand::getPrepTime)
        .returns(COOK_TIME, RecipeCommand::getCookTime)
        .returns(SERVINGS, RecipeCommand::getServings)
        .returns(SOURCE, RecipeCommand::getSource)
        .returns(URL, RecipeCommand::getUrl)
        .returns(DIRECTIONS, RecipeCommand::getDirections)
        .returns(IMAGE, RecipeCommand::getImage)
        .returns(DIFFICULTY, RecipeCommand::getDifficulty)
        .returns(NOTES_COMMAND, RecipeCommand::getNotes)
        .returns(Set.of(INGREDIENT_COMMAND), RecipeCommand::getIngredients)
        .returns(Set.of(CATEGORY_COMMAND), RecipeCommand::getCategories);
  }
  
  @Test
  public void givenRecipe_whenConvertInvoked_thenInitialiseMappedFieldsWithRecipeCommand() {
    RecipeCommand recipeCommand = converter.convert(RECIPE);
    assertThat(recipeCommand)
        .returns(RECIPE_COMMAND, r -> r.getNotes().getRecipe())
        .returns(true, r -> r.getIngredients().stream().allMatch(i -> i.getRecipe().equals(recipeCommand)))
        .returns(true, r -> r.getCategories().stream().allMatch(c -> c.getRecipes().contains(recipeCommand)));
  }
  
}