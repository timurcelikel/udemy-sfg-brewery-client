package guru.springframework.breweryclient.web.client;

import guru.springframework.breweryclient.web.model.BeerDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class BreweryWebClient {

	public static final String BEER_PATH_V1 = "http://localhost:8080/api/v1/beer/";

	private final WebClient webClient = WebClient.create(BEER_PATH_V1);

	public Mono<BeerDto> getBeerById(UUID uuid) {

		return webClient.get()
				.uri(BEER_PATH_V1, uuid.toString())
				.retrieve()
				.bodyToMono(BeerDto.class);
	}
}
