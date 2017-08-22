package ajconsulting.com.microservice.demo.pricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Spring Cloud Netflix Zuul uses Netflix’s Ribbon to perform client-side load balancing, and by default, Ribbon would
 * use Netflix Eureka for service discovery.
 * 
 * @author thales
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class PriceMsApp {

	public static void main(String[] args) {
		SpringApplication.run(PriceMsApp.class, args);
	}
}
