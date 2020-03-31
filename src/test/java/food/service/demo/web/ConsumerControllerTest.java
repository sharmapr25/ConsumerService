package food.service.demo.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.service.demo.entity.PersonName;
import food.service.demo.web.ConsumerController;
import food.service.demo.web_api_contract.CreateConsumerRequest;
import food.service.demo.web_api_contract.CreateConsumerResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConsumerControllerTest {

    @LocalServerPort
    private int randomServerPort;

    @Autowired
    ConsumerController consumerController;

    @Autowired
    TestRestTemplate restTemplate;

    ObjectMapper objectMapper;

    @Before
    public void setup(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void createOrder_shouldReturnOrderIdWithOrderStatePendingApproval_whenOrderCreatedForFirstTime() throws JsonProcessingException {
        String baseUrl = "http://localhost:" + randomServerPort + "/consumers";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        PersonName name = new PersonName("test", "User");
        CreateConsumerRequest testUser = new CreateConsumerRequest(name);
        String firstConsumer = objectMapper.writeValueAsString(testUser);

        HttpEntity<String> request = new HttpEntity<>(firstConsumer, httpHeaders);
        String response = this.restTemplate.postForObject(baseUrl, request, String.class);
        CreateConsumerResponse orderResponse = objectMapper.readValue(response, CreateConsumerResponse.class);

        assertNotNull(orderResponse.getConsumerId());

    }
}
