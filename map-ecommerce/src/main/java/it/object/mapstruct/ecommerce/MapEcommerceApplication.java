package it.object.mapstruct.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MapEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapEcommerceApplication.class, args);
	}

}
