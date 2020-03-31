package food.service.demo.service;

import food.service.demo.exception.ConsumerAlreadyExistsException;
import food.service.demo.repository.ConsumerRepository;
import food.service.demo.entity.Consumer;
import food.service.demo.entity.PersonName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    public Consumer create(PersonName name) {
        Consumer consumerByName = consumerRepository.findConsumerByName(name);
        if(consumerByName != null){
            throw new ConsumerAlreadyExistsException();
        }

        Consumer consumer = new Consumer(name);
        return consumerRepository.save(consumer);
    }
}
