package dev.paie.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.github.lalyos.jfiglet.FigletFont;

import dev.paie.config.ServicesConfig;
import dev.paie.ihm.Menu;

@Configuration
@Import(ServicesConfig.class)
@ComponentScan("dev.paie.ihm")
public class SGPaieApp {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SGPaieApp.class)) {
			final Logger LOG = LoggerFactory.getLogger("logger1");
			Menu menu = context.getBean(Menu.class);
			String asciiArt = FigletFont.convertOneLine("Gestion des cotisations");
			LOG.trace(asciiArt);
			menu.afficher();

		}

	}

}
