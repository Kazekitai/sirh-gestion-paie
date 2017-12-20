package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Configuration de la partie web (spring web-mvc)
 * @author Sandra Le Thiec
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("dev.paie.web.controller")
public class WebAppConfig {
	@Bean
	public ViewResolver viewResolver() {
	return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
}
