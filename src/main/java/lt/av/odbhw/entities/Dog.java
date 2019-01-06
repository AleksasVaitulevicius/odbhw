package lt.av.odbhw.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Dog extends Pet {

    private Integer timesFetchedStick;

    @Builder
    public Dog(Long id, String name, Integer timesFetchedStick, Owner owner) {
        super(id, name, owner);
        this.timesFetchedStick = timesFetchedStick;
    }

}
