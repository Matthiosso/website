package com.matthieuclement.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.matthieuclement.backend.property.FileDownloadProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileDownloadProperties.class
})
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
