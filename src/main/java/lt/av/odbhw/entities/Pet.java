package lt.av.odbhw.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pet {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
