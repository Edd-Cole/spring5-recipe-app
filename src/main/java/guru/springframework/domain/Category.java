package guru.springframework.domain;

import javax.persistence.*;
import java.util.Set;

<<<<<<< HEAD
@Entity
public class Category {
=======
/**
 * Created by jt on 6/13/17.
 */
@Entity
public class Category {

>>>>>>> 28aac476a3c62e53b8296bf1b1b60342f53c6e0b
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
<<<<<<< HEAD
=======

>>>>>>> 28aac476a3c62e53b8296bf1b1b60342f53c6e0b
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
