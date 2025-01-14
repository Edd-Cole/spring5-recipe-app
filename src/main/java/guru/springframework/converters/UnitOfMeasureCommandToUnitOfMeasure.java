package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;

public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {
  @Override
  public UnitOfMeasure convert(UnitOfMeasureCommand source) {
    if (source == null) return null;
    
    UnitOfMeasure uom = new UnitOfMeasure();
    uom.setId(source.getId());
    uom.setDescription(source.getDescription());
    return uom;
  }
}
