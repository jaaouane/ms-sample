package ajconsulting.com.microservice.demo.products.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ajconsulting.com.microservice.demo.products.domain.Product;

@RestController
public class ProductsController {

	private final Logger log = LoggerFactory.getLogger(ProductsController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(millis = 2000000000)
	public ResponseEntity<List<Product>> getProducts() throws URISyntaxException {
		System.out.println("REST request to get products");

		Product product = new Product();
		product.setId("235");
		product.setReference("wxy321");
		List<Product> products = Stream.of(product).collect(Collectors.toList());

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

}

// rajouter un filtre ZUUL
// tester si on appelle le filtre depuis un client REST classique