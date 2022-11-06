package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static guru.springframework.converters.testdata.TestData.DESCRIPTION;
import static guru.springframework.converters.testdata.TestData.ID;
import static org.assertj.core.api.Assertions.assertThat;

class UnitOfMeasureCommandToUnitOfMeasureTest {
  UnitOfMeasureCommandToUnitOfMeasure uomcToUom = new UnitOfMeasureCommandToUnitOfMeasure();
  UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
  
  @BeforeEach
  public void setup() {
    uomc.setId(ID);
    uomc.setDescription(DESCRIPTION);
  }
  
  @Test
  public void givenNull_whenConvertInvoked_thenReturnNull() {
    assertThat(uomcToUom.convert(null)).isNull();
  }
  
  @Test
  public void givenUomc_whenConvertInvoked_thenReturnUom() {
    assertThat(uomcToUom.convert(uomc))
        .returns(ID, UnitOfMeasure::getId)
        .returns(DESCRIPTION, UnitOfMeasure::getDescription);
  }
}