package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.abc.config.AuditorAwareImpl;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableEurekaClient
public class JavaBrainsMovieInfoSrvcApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaBrainsMovieInfoSrvcApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

	@Bean
	// @LoadBalanced // ************** WHEN USING Eureka DISCOVERY SERVER **************
	public RestTemplate restTemplate() { // (RestTemplateBuilder builder)
		return new RestTemplate();
	}
}
