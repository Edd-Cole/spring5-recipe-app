package guru.springframework.domain;

<<<<<<< HEAD
import javax.persistence.*;

@Entity
public class UnitOfMeasure {
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jt on 6/13/17.
 */
@Entity
public class UnitOfMeasure {

>>>>>>> 28aac476a3c62e53b8296bf1b1b60342f53c6e0b
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

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
}
