package guru.springframework.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {
  Category category = new Category();
  Long testValue = 4L;
  String des = "This is a test";
  
  @Test
  public void getId() {
    category.setId(testValue);
    assertEquals(testValue, category.getId());
  }
  
  @Test
  public void getDescription() {
    category.setDescription(des);
    assertEquals(des, category.getDescription());
  }
}