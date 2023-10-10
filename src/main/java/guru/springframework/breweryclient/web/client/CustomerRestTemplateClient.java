package guru.springframework.breweryclient.web.client;

import guru.springframework.breweryclient.web.config.PropertyConfiguration;
import guru.springframework.breweryclient.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@EnableConfigurationProperties(PropertyConfiguration.class)
@Component
public class CustomerRestTemplateClient {

	public static final String CUSTOMER_PATH_V1 = "/api/v1/customer";
	private final RestTemplate restTemplate;

	private final String apiHost;

	@Autowired
	public CustomerRestTemplateClient(RestTemplateBuilder restTemplateBuilder,
			PropertyConfiguration propertyConfiguration) {
		this.restTemplate = restTemplateBuilder.build();
		this.apiHost = propertyConfiguration.getApiHost();
	}

	public CustomerDto getCustomerById(UUID uuid) {
		return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + "/" + uuid,
				CustomerDto.class);
	}

	public URI saveNewCustomer(CustomerDto customerDto) {
		return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
	}

	public void updateCustomer(UUID uuid, CustomerDto customerDto) {
		restTemplate.put(apiHost + CUSTOMER_PATH_V1 + "/" + uuid, customerDto);
	}

	public void deleteCustomer(UUID uuid) {
		restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + "/" + uuid);
	}
}
