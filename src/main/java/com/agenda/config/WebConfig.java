package com.agenda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;
@Configuration
@EnableSpringDataWebSupport
public class WebConfig {
	
	@Bean
	public TemplateEngine templateEngine(SpringTemplateEngine engine) {
		
		engine.addDialect(new DataAttributeDialect());

		return engine;
	}

}
