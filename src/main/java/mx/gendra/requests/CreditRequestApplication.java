package mx.gendra.requests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CreditRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditRequestApplication.class, args);
	}

}
