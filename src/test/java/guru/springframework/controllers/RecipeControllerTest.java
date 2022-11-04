package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class RecipeControllerTest {
  
  @Mock
  RecipeService recipeService;
  RecipeController recipeController;
  MockMvc mockMvc;
  
  Recipe recipe = new Recipe();
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    recipeController = new RecipeController(recipeService);
    mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
  
    recipe.setId(1L);
    recipe.setDescription("Test");
    recipe.setDirections("Test Directions");
    recipe.setDifficulty(Difficulty.EASY);
    recipe.setCookTime(10);
    recipe.setCategories(Set.of(new Category()));
  }
  
  @Test
  void showById() throws Exception {
    when(recipeService.findById(any())).thenReturn(recipe);
    
    mockMvc.perform(get("/recipe/show/1"))
        .andExpect(status().isOk())
        .andExpect(view().name("recipe/show"));
    verify(recipeService).findById(1L);
  }
}