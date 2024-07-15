package me.ferrandis.SupermarketComparator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupermarketComparatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermarketComparatorApplication.class, args);
		System.out.println("APLICACION INICIADA. \n Consulta los metodos disponibles en: http://localhost:8080/swagger-ui.html\n");
	}

}
