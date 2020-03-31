package food.service.demo.repository;

import food.service.demo.entity.Consumer;
import food.service.demo.entity.PersonName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends CrudRepository<Consumer, Long> {
    public Consumer findConsumerByName(PersonName personName);
}
