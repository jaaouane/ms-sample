package ajconsulting.com.microservice.demo.shop.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ajconsulting.com.microservice.demo.shop.domain.Product;

@RestController
public class ShopController {

	private static final String PATH = "/products";

	private static final String PRODUCTS_MS = "http://product-ms";

	private final Logger log = LoggerFactory.getLogger(ShopController.class);

	@LoadBalanced
	@Autowired
	private RestTemplate restTemplate;

	@Value("${message:Hello default}")
	private String message;

	@RequestMapping("/message")
	String getMessage() {
		return message;
	}

	@HystrixCommand(fallbackMethod = "defaultProducts")
	@RequestMapping(value = "/references", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(millis = 2000000000)
	public List<String> getReferences() throws URISyntaxException {
		log.debug("REST request to get References");

		String url = PRODUCTS_MS + PATH;

		ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});

		return responseEntity.getBody().stream().map(u -> u.getReference()).collect(Collectors.toList());
	}

	public List<String> defaultProducts() {
		System.out.println("defaultProducts");
		return Stream.<Product> of().map(u -> u.getReference()).collect(Collectors.toList());
	}

}
