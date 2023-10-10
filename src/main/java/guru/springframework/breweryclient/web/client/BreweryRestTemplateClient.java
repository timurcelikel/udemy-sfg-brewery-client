package guru.springframework.breweryclient.web.client;

import guru.springframework.breweryclient.web.model.BeerDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class BreweryRestTemplateClient {

	public static final String BEER_PATH_V1 = "http://localhost:8080/api/v1/beer/";
	private final RestTemplate restTemplate;

	public BreweryRestTemplateClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public BeerDto getBeerById(UUID uuid) {
		return restTemplate.getForObject(BEER_PATH_V1 + uuid.toString(), BeerDto.class);
	}
}
