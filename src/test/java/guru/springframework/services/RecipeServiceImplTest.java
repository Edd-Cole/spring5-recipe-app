package guru.springframework.services;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {
  @Mock
  RecipeRepository recipeRepository;
  RecipeServiceImpl recipeService;
  
  Recipe recipe = new Recipe();
  
  @BeforeEach
  public void setup() throws Exception {
    MockitoAnnotations.initMocks(this);
    recipeService = new RecipeServiceImpl(recipeRepository);
    recipe.setId(1L);
    recipe.setDescription("Test");
    recipe.setDirections("Test Directions");
    recipe.setDifficulty(Difficulty.EASY);
    recipe.setCookTime(10);
    recipe.setCategories(Set.of(new Category()));
  }
  
  @Test
  public void getRecipeById() {
    when(recipeRepository.findById(any())).thenReturn(Optional.of(recipe));
    
    assertThat(recipeService)
        .returns(recipe, recipeService -> recipeService.findById(1L));
  }
  
  @Test
  public void getRecipeById_givenIdDoesNotExist_returnNull() {
    when(recipeRepository.findById(any())).thenReturn(Optional.empty());
    
    assertThat(recipeService)
        .returns(null, recipeService -> recipeService.findById(1L));
  }
  
  @Test
  public void getRecipes() {
    Set<Recipe> recipesData = new HashSet<>();
    recipesData.add(recipe);
    
    when(recipeRepository.findAll()).thenReturn(recipesData);
    
    Set<Recipe> recipes = recipeService.getRecipes();
    
    assertEquals(1, recipes.size());
    verify(recipeRepository, times(1)).findAll();
  }
  
}