package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;

public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
  
  private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;
  
  public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
    this.uomConverter = uomConverter;
  }
  
  @Override
  public Ingredient convert(IngredientCommand source) {
    if (source == null) return null;
    
    final Ingredient ingredient = new Ingredient();
    ingredient.setId(source.getId());
    ingredient.setDescription(source.getDescription());
    ingredient.setAmount(source.getAmount());
    ingredient.setUom(uomConverter.convert(source.getUom()));
    return ingredient;
  }
}
