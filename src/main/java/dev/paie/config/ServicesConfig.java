package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration des services
 * @author Sandra Le Thiec
 *
 */
@Configuration
@ComponentScan({"dev.paie.service", "dev.paie.spring","dev.paie.util"})
@EnableJpaRepositories("dev.paie.repository")
public class ServicesConfig {
	
}
