package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static guru.springframework.converters.testdata.TestData.AMOUNT;
import static guru.springframework.converters.testdata.TestData.DESCRIPTION;
import static guru.springframework.converters.testdata.TestData.ID;
import static guru.springframework.converters.testdata.TestData.INGREDIENT;
import static guru.springframework.converters.testdata.TestData.UNIT_OF_MEASURE;
import static guru.springframework.converters.testdata.TestData.UNIT_OF_MEASURE_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class IngredientToIngredientCommandTest {
  @Mock
  UnitOfMeasureToUnitOfMeasureCommand uomConverter;
  
  IngredientToIngredientCommand converter;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    converter = new IngredientToIngredientCommand(uomConverter);
    when(uomConverter.convert(UNIT_OF_MEASURE)).thenReturn(UNIT_OF_MEASURE_COMMAND);
  }
  
  @Test
  public void givenNull_whenConvertInvoked_thenReturnNull() {
    assertThat(converter.convert(null)).isNull();
  }
  
  @Test
  public void givenIngredient_whenConvertInvoked_thenReturnIngredientCommand() {
    assertThat(converter.convert(INGREDIENT))
        .returns(ID, IngredientCommand::getId)
        .returns(DESCRIPTION, IngredientCommand::getDescription)
        .returns(AMOUNT, IngredientCommand::getAmount)
        .returns(UNIT_OF_MEASURE_COMMAND, IngredientCommand::getUom);
  }
  
}