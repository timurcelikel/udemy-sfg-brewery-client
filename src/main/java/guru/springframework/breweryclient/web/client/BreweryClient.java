package guru.springframework.breweryclient.web.client;

import guru.springframework.breweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
@EnableConfigurationProperties(BreweryClient.class)
public class BreweryClient {

	public static final String BEER_PATH_V1 = "/api/v1/beer/";
	private String apiHost;
	private final WebClient webClient = WebClient.create(apiHost);

	public Mono<BeerDto> getBeerById(UUID uuid) {

		return webClient.get()
				.uri(BEER_PATH_V1, uuid.toString())
				.retrieve()
				.bodyToMono(BeerDto.class);
	}

	public void setApiHost(final String apiHost) {
		this.apiHost = apiHost;
	}
}
