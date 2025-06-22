package br.com.fiap.FarmaNear_Receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FarmaNearReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmaNearReceiverApplication.class, args);
	}

}
