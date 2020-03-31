package food.service.demo.web_api_contract;

import food.service.demo.entity.PersonName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class CreateConsumerRequest {
    private PersonName name;
}
