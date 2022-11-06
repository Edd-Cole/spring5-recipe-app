package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;

public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
  
  private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;
  
  public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
    this.uomConverter = uomConverter;
  }
  
  @Override
  public IngredientCommand convert(Ingredient source) {
    if (source == null) {
      return null;
    }
    final IngredientCommand ingredient = new IngredientCommand();
    ingredient.setId(source.getId());
    ingredient.setDescription(source.getDescription());
    ingredient.setAmount(source.getAmount());
    ingredient.setUom(uomConverter.convert(source.getUom()));
    return ingredient;
  }
}
