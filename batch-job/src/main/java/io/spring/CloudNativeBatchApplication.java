package io.spring;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableBatchProcessing
@SpringBootApplication
public class CloudNativeBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativeBatchApplication.class, args);
	}
}
