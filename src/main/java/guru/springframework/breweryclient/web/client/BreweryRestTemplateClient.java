package guru.springframework.breweryclient.web.client;

import guru.springframework.breweryclient.web.config.PropertyConfiguration;
import guru.springframework.breweryclient.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@EnableConfigurationProperties(PropertyConfiguration.class)
@Component
public class BreweryRestTemplateClient {

	public static final String BEER_PATH_V1 = "/api/v1/beer";
	private final RestTemplate restTemplate;

	private final String apiHost;

	@Autowired
	public BreweryRestTemplateClient(RestTemplateBuilder restTemplateBuilder,
			PropertyConfiguration propertyConfiguration) {
		this.restTemplate = restTemplateBuilder.build();
		this.apiHost = propertyConfiguration.getApiHost();
	}

	public BeerDto getBeerById(UUID uuid) {
		return restTemplate.getForObject(apiHost + BEER_PATH_V1 + "/" + uuid.toString(),
				BeerDto.class);
	}

	public URI saveNewBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
	}

	public void updateBeer(UUID uuid, BeerDto beerDto) {
		restTemplate.put(apiHost + BEER_PATH_V1 + "/" + uuid, beerDto);
	}

	public void deleteBeer(UUID uuid) {
		restTemplate.delete(apiHost + BEER_PATH_V1 + "/" + uuid);
	}
}
