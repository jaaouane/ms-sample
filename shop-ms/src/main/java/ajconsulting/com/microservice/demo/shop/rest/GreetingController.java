package ajconsulting.com.microservice.demo.shop.rest;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

	@Value("${message:Hello default}")
	private String message;

	private final Logger log = LoggerFactory.getLogger(ShopController.class);

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getHello(@RequestParam(value = "/message", required = false) String name) {
		log.debug("Greetings Controller");

		return this.message;
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> postHello(@RequestParam(value = "name", required = false) String name,
			Principal principal) {
		log.debug("saving Hello in DB");
		log.info("connected user={}", principal.getName());
		log.info("connected user eic={}", ((OAuth2Authentication) principal).getUserAuthentication().getDetails());

		return ResponseEntity.<String> ok("Hello " + name + " was saved");
	}

}
