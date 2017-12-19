package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration des services
 * @author Sandra Le Thiec
 *
 */
@Configuration
@ComponentScan({"dev.paie.service", "dev.paie.spring","dev.paie.util"})
public class ServicesConfig {
	
}
