package com.film;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.film.filter.CinemaFilter;


@Configuration
public class CinemaConfig implements WebMvcConfigurer {
	@Bean
	public CinemaFilter getFilter() {
		return new CinemaFilter();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(getFilter()).addPathPatterns("/*");
	}
}
