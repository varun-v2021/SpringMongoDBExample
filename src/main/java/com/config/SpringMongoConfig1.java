package main.java.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig1 {

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "yourdb");
	}

	@Bean
	public MongoClient mongo() throws Exception {
		return new MongoClient("localhost");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		// Both the ways work below

		// MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		MongoTemplate mongoTemplate = new MongoTemplate(mongo(), "yourdb");

		return mongoTemplate;

	}

}
