package guru.springframework.commands;

public class NotesCommand {
  private Long id;
  private RecipeCommand recipe;
  private String recipeNotes;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public RecipeCommand getRecipe() {
    return recipe;
  }
  
  public void setRecipe(RecipeCommand recipe) {
    this.recipe = recipe;
  }
  
  public String getRecipeNotes() {
    return recipeNotes;
  }
  
  public void setRecipeNotes(String recipeNotes) {
    this.recipeNotes = recipeNotes;
  }
}
