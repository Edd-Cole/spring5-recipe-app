package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static guru.springframework.converters.testdata.TestData.DESCRIPTION;
import static guru.springframework.converters.testdata.TestData.ID;
import static org.assertj.core.api.Assertions.assertThat;

class UnitOfMeasureToUnitOfMeasureCommandTest {
  UnitOfMeasureToUnitOfMeasureCommand uomToUomc = new UnitOfMeasureToUnitOfMeasureCommand();
  UnitOfMeasure uom = new UnitOfMeasure();
  
  @BeforeEach
  public void setup() {
    uom.setId(ID);
    uom.setDescription(DESCRIPTION);
  }
  
  @Test
  public void givenNull_whenConvertInvoked_thenReturnNull() {
    assertThat(uomToUomc.convert(null)).isNull();
  }
  
  @Test
  public void givenUOM_whenConvertInvoked_thenReturnUOMC() {
    assertThat(uomToUomc.convert(uom))
        .returns(ID, UnitOfMeasureCommand::getId)
        .returns(DESCRIPTION, UnitOfMeasureCommand::getDescription);
  }
}