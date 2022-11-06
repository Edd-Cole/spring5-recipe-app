package guru.springframework.converters;

import guru.springframework.domain.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static guru.springframework.converters.testdata.TestData.AMOUNT;
import static guru.springframework.converters.testdata.TestData.DESCRIPTION;
import static guru.springframework.converters.testdata.TestData.ID;
import static guru.springframework.converters.testdata.TestData.INGREDIENT_COMMAND;
import static guru.springframework.converters.testdata.TestData.UNIT_OF_MEASURE;
import static guru.springframework.converters.testdata.TestData.UNIT_OF_MEASURE_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class IngredientCommandToIngredientTest {
  
  @Mock
  UnitOfMeasureCommandToUnitOfMeasure uomConverter;
  IngredientCommandToIngredient converter;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    converter = new IngredientCommandToIngredient(uomConverter);
    when(uomConverter.convert(UNIT_OF_MEASURE_COMMAND)).thenReturn(UNIT_OF_MEASURE);
  }
  
  @Test
  public void givenNull_whenConvertInvoked_thenReturnNull() {
    assertThat(converter.convert(null)).isNull();
  }

  @Test
  public void givenIngredientCommand_whenConvertInvoked_thenReturnIngredient() {
    assertThat(converter.convert(INGREDIENT_COMMAND))
        .returns(ID, Ingredient::getId)
        .returns(DESCRIPTION, Ingredient::getDescription)
        .returns(AMOUNT, Ingredient::getAmount)
        .returns(UNIT_OF_MEASURE, Ingredient::getUom);
  }
  
}