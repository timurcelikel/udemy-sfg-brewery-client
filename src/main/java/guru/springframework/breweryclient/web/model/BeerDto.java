package guru.springframework.breweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

	private UUID id;
	private String beerName;
	private BeerStyle beerStyle;
	private Long upc;
}
