package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryITest {
  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;

  @Test
  public void test() {
    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
    
    assertEquals("Teaspoon", uomOptional.orElseThrow(RuntimeException::new).getDescription());
  }

}