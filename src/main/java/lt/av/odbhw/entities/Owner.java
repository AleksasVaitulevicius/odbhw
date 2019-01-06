package lt.av.odbhw.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Entity
@Data
@Builder
public class Owner {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Set<Pet> pets;

}
