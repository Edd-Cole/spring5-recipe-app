package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import org.junit.jupiter.api.Test;

import static guru.springframework.converters.testdata.TestData.CATEGORY;
import static guru.springframework.converters.testdata.TestData.DESCRIPTION;
import static guru.springframework.converters.testdata.TestData.ID;
import static org.assertj.core.api.Assertions.assertThat;

class CategoryToCategoryCommandTest {
  
  CategoryToCategoryCommand converter = new CategoryToCategoryCommand();
  
  @Test
  public void givenNull_whenConvertInvoked_thenReturnNull() {
    assertThat(converter.convert(null)).isNull();
  }
  
  @Test
  public void givenCategory_whenConverterInvoked_thenReturnCategoryCommand() {
    assertThat(converter.convert(CATEGORY))
        .returns(ID, CategoryCommand::getId)
        .returns(DESCRIPTION, CategoryCommand::getDescription);
  }
  
}