package food.service.demo.service;

import food.service.demo.entity.Consumer;
import food.service.demo.entity.PersonName;
import food.service.demo.exception.ConsumerAlreadyExistsException;
import food.service.demo.repository.ConsumerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConsumerServiceTest {

    @Mock
    ConsumerRepository consumerRepository;

    @InjectMocks
    ConsumerService consumerService;

    @Test
    public void create_shouldReturnCreatedConsumer_whenTryToCreateANewConsumer(){
        PersonName name = new PersonName("test", "user");

        Consumer expectedConsumer = new Consumer(name);
        when(consumerRepository.save(any(Consumer.class))).thenReturn(expectedConsumer);

        Consumer consumer = consumerService.create(name);
        assertTrue(consumer.equals(expectedConsumer));
    }

    @Test
    public void create_shouldThrowConsumerAlreadyExistsException_whenTryToCreateSameConsumerAgain(){
        PersonName name = new PersonName("test", "user");
        Consumer consumer = new Consumer(name);

        when(consumerRepository.findConsumerByName(name)).thenReturn(consumer);

        assertThrows(ConsumerAlreadyExistsException.class, ()->{
            consumerService.create(name);
        });
    }
}
