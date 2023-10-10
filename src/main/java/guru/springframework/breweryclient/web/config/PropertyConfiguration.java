package guru.springframework.breweryclient.web.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class PropertyConfiguration {

	private String apiHost;

	public void setApiHost(final String apiHost) {
		this.apiHost = apiHost;
	}
}
