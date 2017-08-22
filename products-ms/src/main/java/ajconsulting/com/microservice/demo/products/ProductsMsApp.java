package ajconsulting.com.microservice.demo.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCircuitBreaker // inter-service communication
@EnableEurekaClient
public class ProductsMsApp {

	public static void main(String[] args) {
		SpringApplication.run(ProductsMsApp.class, args);
	}
}
