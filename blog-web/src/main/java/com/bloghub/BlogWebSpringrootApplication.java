package com.bloghub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;

import com.bloghub.markdown.MarkdownViewResolver;

@SpringBootApplication
public class BlogWebSpringrootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogWebSpringrootApplication.class, args);
	}

	@Bean
	public ViewResolver getViewResolver() {
		MarkdownViewResolver resolver = new MarkdownViewResolver();
		resolver.setSuffix(".md");
		return resolver;
	}
	
}
