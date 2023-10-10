package guru.springframework.breweryclient.web.client;

import guru.springframework.breweryclient.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient
@Slf4j
class CustomerRestTemplateClientTest {

	@Autowired
	CustomerRestTemplateClient customerRestTemplateClient;

	@Test
	void getCustomerById() {
		CustomerDto dto = customerRestTemplateClient.getCustomerById(UUID.randomUUID());
		assertNotNull(dto);
	}

	@Test
	void saveNewCustomer() {
		URI uri = customerRestTemplateClient.saveNewCustomer(CustomerDto.builder().name("Mark Adams").build());
		assertNotNull(uri);
	}

	@Test
	void updateCustomer() {
		customerRestTemplateClient.updateCustomer(UUID.randomUUID(),
				CustomerDto.builder().name("Ben Johnson").build());
	}

	@Test
	void deleteCustomer() {
		UUID uuid = UUID.randomUUID();
		log.info("Delete UUID: " + uuid);
		customerRestTemplateClient.deleteCustomer(uuid);
	}
}