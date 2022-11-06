package guru.springframework.converters;

import guru.springframework.domain.Category;
import org.junit.jupiter.api.Test;

import static guru.springframework.converters.testdata.TestData.CATEGORY_COMMAND;
import static guru.springframework.converters.testdata.TestData.DESCRIPTION;
import static guru.springframework.converters.testdata.TestData.ID;
import static org.assertj.core.api.Assertions.assertThat;

class CategoryCommandToCategoryTest {
  
  CategoryCommandToCategory converter = new CategoryCommandToCategory();
  
  @Test
  public void givenNull_whenConvertInvoked_thenReturnNull() {
    assertThat(converter.convert(null)).isNull();
  }
  
  @Test
  public void givenCategoryCommand_whenConvertInvoked_thenReturnCategory() {
    assertThat(converter.convert(CATEGORY_COMMAND))
        .returns(ID, Category::getId).returns(DESCRIPTION, Category::getDescription)
        .returns(DESCRIPTION, Category::getDescription);
  }
  
}