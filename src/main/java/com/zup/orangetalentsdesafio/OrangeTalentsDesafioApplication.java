package com.zup.orangetalentsdesafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrangeTalentsDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangeTalentsDesafioApplication.class, args);
	}

}
