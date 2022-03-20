package com.as.eatservice.eatservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EatserviceApplication  extends SpringBootServletInitializer {

	private final static Logger logger = LogManager.getLogger(EatserviceApplication.class);



	public static void main(String[] args) {
		logger.info("Application Start Running...");
		logger.debug("Application Start Running...");
		logger.error("Application Start Running...");
		logger.warn("Application Start Running...");

		SpringApplication.run(EatserviceApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EatserviceApplication.class);
	}

}
