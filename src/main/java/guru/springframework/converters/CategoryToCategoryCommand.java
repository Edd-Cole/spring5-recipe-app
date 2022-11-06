package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.springframework.core.convert.converter.Converter;

public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
  @Override
  public CategoryCommand convert(Category source) {
    if (source == null) {
      return null;
    }
    
    final CategoryCommand category = new CategoryCommand();
    category.setId(source.getId());
    category.setDescription(source.getDescription());
    return category;
  }
  
}
