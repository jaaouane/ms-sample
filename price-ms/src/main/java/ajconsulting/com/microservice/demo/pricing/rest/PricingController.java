package ajconsulting.com.microservice.demo.pricing.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController {

	@Value("${price:7.0}")
	private String price;

	private final Logger log = LoggerFactory.getLogger(PricingController.class);

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getHello(@RequestParam(value = "/price", required = false) String name) {
		log.debug("Pricing Controller");

		return this.price;
	}

}
