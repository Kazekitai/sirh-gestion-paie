package dev.paie.spring;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Configuration de la source de données
 * @author Sandra Le Thiec
 *
 */
@Configuration
public class DataSourceMySQLConfig {
	/**
	 *  Bean de configuration de la source des données
	 * @return dataSource
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sirh-paie?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("3hqddwi@");
		return dataSource;
	}

}
