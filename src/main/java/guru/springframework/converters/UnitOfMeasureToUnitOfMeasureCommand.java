package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;

public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
  @Override
  public UnitOfMeasureCommand convert(UnitOfMeasure source) {
    if (source == null) return null;
    
    final UnitOfMeasureCommand uom = new UnitOfMeasureCommand();
    uom.setDescription(source.getDescription());
    uom.setId(source.getId());
    return uom;
  }
}
