package food.service.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "consumers")
@NoArgsConstructor @Getter
public class Consumer {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private PersonName name;

    public Consumer(PersonName name) {
        this.name = name;
    }
}
