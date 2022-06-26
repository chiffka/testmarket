package com.testmarket;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
@ComponentScan(basePackages = {"com.testmarket"})
@EnableNeo4jRepositories("com.testmarket.repositories")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

    @Bean
    public Module javaTimeModule() {
        return new JavaTimeModule();
    }
}