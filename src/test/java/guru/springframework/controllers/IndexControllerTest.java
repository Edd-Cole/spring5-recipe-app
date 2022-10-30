package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {
  
  RecipeRepository recipeRepository = mock(RecipeRepository.class);
  IndexController indexController = new IndexController(recipeRepository);
  Model model = mock(Model.class);
  
  @Test
  void whenGetIndexPageIsInvoked_returnsDesiredString() {
    Set<Recipe> recipes = new HashSet<>();
    recipes.add(new Recipe());
    recipes.add(new Recipe());
    
    when(recipeRepository.findAll()).thenReturn(recipes);
    when(model.addAttribute(eq("recipes"), anySet())).thenReturn(model);
    
    ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
    
    assertEquals("index", indexController.getIndexPage(model));
    verify(recipeRepository, times(1)).findAll();
    verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
    Set<Recipe> setInController = argumentCaptor.getValue();
    assertEquals(2, setInController.size());
  }
  
  @Test
  public void mockMVC() throws Exception {
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    
    mockMvc.perform(get("/")).andExpect(status().is(200)).andExpect(view().name("index"));
  }
  
}