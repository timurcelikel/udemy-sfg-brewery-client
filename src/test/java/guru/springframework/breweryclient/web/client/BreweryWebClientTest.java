package guru.springframework.breweryclient.web.client;

import guru.springframework.breweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient
class BreweryWebClientTest {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void getBeerById() {
		final BeerDto beerDto =
				webTestClient.get().uri(BreweryWebClient.BEER_PATH_V1 + UUID.randomUUID(), 1)
						.exchange()
						.expectStatus().isOk()
						.expectHeader().valueEquals("Content-type", "application/json")
						.expectBody(BeerDto.class)
						.returnResult()
						.getResponseBody();
		assertNotNull(beerDto);
		assertEquals("Galaxy Cat", beerDto.getBeerName());
	}
}