package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {
  
  RecipeServiceImpl recipeService;
  
  @Mock
  RecipeRepository recipeRepository;
  
  @BeforeEach
  public void setup() throws Exception {
    MockitoAnnotations.initMocks(this);
    recipeService = new RecipeServiceImpl(recipeRepository);
  }
  
  @Test
  public void getRecipes() {
    Recipe recipe = new Recipe();
    Set<Recipe> recipesData = new HashSet<>();
    recipesData.add(recipe);
    
    when(recipeRepository.findAll()).thenReturn(recipesData);
    
    Set<Recipe> recipes = recipeService.getRecipes();
    
    assertEquals(1, recipes.size());
    verify(recipeRepository, times(1)).findAll();
  }
  
}