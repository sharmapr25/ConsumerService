package food.service.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class PersonName {
    private String firstName;
    private String lastName;
}
