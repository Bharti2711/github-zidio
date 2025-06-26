package com.zidio.zidioconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.zidio.zidioconnect.entity")
@SpringBootApplication
public class ZidioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZidioApplication.class, args);
	}

}
