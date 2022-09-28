package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

<<<<<<< HEAD
@Controller
public class IndexController {
        private CategoryRepository categoryRepository;
        private UnitOfMeasureRepository unitOfMeasureRepository;

        public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
                this.categoryRepository = categoryRepository;
                this.unitOfMeasureRepository = unitOfMeasureRepository;
        }

        @RequestMapping("/")
        public String getIndex() {
                Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
                Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

                System.out.println("Cat Id is: " + categoryOptional.get().getId());
                System.out.println("UOM ID is: " + unitOfMeasureOptional.get().getId());

                return "index";
        }
=======
/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        return "index";
    }
>>>>>>> 28aac476a3c62e53b8296bf1b1b60342f53c6e0b
}
