package guru.springframework.breweryclient.web.client;

import guru.springframework.breweryclient.web.model.BeerDto;
import guru.springframework.breweryclient.web.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient
@Slf4j
class BreweryRestTemplateClientTest {

	@Autowired
	BreweryRestTemplateClient breweryRestTemplateClient;

	@Test
	void getBeerById() {
		BeerDto beerDto = breweryRestTemplateClient.getBeerById(UUID.randomUUID());
		assertNotNull(beerDto);
		assertEquals("Galaxy Cat", beerDto.getBeerName());
	}

	@Test
	void saveNewBeer() {
		URI uri =
				breweryRestTemplateClient.saveNewBeer(BeerDto.builder().beerName("California Honey").beerStyle(
						BeerStyle.LAGER).upc(1234L).build());
		assertNotNull(uri);
	}

	@Test
	void updateBeer() {
		breweryRestTemplateClient.updateBeer(UUID.randomUUID(),
				BeerDto.builder().beerName("Chronic Ale").beerStyle(
						BeerStyle.ALE).upc(1111L).build());
	}

	@Test
	void deleteBeer() {
		UUID uuid = UUID.randomUUID();
		log.info("Delete UUID: " + uuid);
		breweryRestTemplateClient.deleteBeer(uuid);
	}
}