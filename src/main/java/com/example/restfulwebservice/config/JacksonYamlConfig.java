package com.example.restfulwebservice.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonYamlConfig {
    @Bean
    public MappingJackson2YamlHttpMessageConverter yamlHttpMessageConverter() {
        YAMLMapper mapper = new YAMLMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return new MappingJackson2YamlHttpMessageConverter(mapper);
    }
}