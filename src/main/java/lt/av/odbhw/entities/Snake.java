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
public class Snake extends Pet {

    private Boolean isSkinShedding;

    @Builder
    public Snake(Long id, String name, Boolean isSkinShedding) {
        super(id, name);
        this.isSkinShedding = isSkinShedding;
    }

}


