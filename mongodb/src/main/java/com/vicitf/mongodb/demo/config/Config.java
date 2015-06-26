package com.vicitf.mongodb.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

@Configuration
public class Config {
	@SuppressWarnings("deprecation")
	public @Bean Mongo mongo() throws Exception {
		return new Mongo("localhost", 27017);
	}
	
	public @Bean MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "info");
	}
}
