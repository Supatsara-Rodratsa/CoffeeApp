package space.harbour.CoffeeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import space.harbour.CoffeeApp.controller.ProductController;

@SpringBootApplication
public class CoffeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeAppApplication.class, args);
	}

}
