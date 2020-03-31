package food.service.demo.web;

import food.service.demo.entity.Consumer;
import food.service.demo.service.ConsumerService;
import food.service.demo.web_api_contract.CreateConsumerRequest;
import food.service.demo.web_api_contract.CreateConsumerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/consumers")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @PostMapping
    public CreateConsumerResponse create(@RequestBody CreateConsumerRequest consumerRequest){
        Consumer consumer = consumerService.create(consumerRequest.getName());
        return new CreateConsumerResponse(consumer.getId());
    }
}
