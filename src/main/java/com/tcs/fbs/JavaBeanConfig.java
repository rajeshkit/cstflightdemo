package com.tcs.fbs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBeanConfig {
    @Bean
    ModelMapper modelMapper() {
		return new ModelMapper();
	}
}	
