package guru.springframework.breweryclient.web.client;

import guru.springframework.breweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class BreweryRestTemplateClientTest {

	@Autowired
	BreweryRestTemplateClient breweryRestTemplateClient;

	@Test
	void getBeerById() {
		BeerDto dto = breweryRestTemplateClient.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
	}
}