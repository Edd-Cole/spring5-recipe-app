package guru.springframework.domain;

import javax.persistence.*;
import java.math.BigDecimal;

<<<<<<< HEAD
@Entity
public class Ingredient {
=======
/**
 * Created by jt on 6/13/17.
 */
@Entity
public class Ingredient {

>>>>>>> 28aac476a3c62e53b8296bf1b1b60342f53c6e0b
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
<<<<<<< HEAD
    //private UOM unitOfMeasure;
    @ManyToOne
    private Recipe recipe;
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

=======

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;

>>>>>>> 28aac476a3c62e53b8296bf1b1b60342f53c6e0b
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
    }
}
