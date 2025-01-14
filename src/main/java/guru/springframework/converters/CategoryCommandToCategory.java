package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.springframework.core.convert.converter.Converter;

public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
  
  @Override
  public Category convert(CategoryCommand source) {
    if (source == null) {
      return null;
    }
    
    final Category category = new Category();
    category.setId(source.getId());
//    category.setRecipes(source.getRecipes());
    category.setDescription(source.getDescription());
    return category;
  }
}
