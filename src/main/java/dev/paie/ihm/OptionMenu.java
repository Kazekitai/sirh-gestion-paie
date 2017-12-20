package dev.paie.ihm;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

/**
 * Abstract class for options of application menu 
 * @author Sandra Le Thiec
 *
 */
public abstract class OptionMenu {
	/* ATTRIBUTS */
	private final Logger LOGINFO = LoggerFactory.getLogger("logger1"); 
	
	@Autowired
	private CotisationRepository cotisationRepository;

	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public OptionMenu() {
	}

	/* METHODS */
	/**
	 * Method Execute
	 */
	public abstract boolean execute();

	/**
	 * Get label of option
	 * 
	 * @return
	 */
	public abstract String getLabel();

	/**
	 * Method to display list of pizza
	 */
	public boolean displayCotisationsList() {
		
		List<Cotisation> cotisations = cotisationRepository.findAll();
		LOGINFO.trace("\nListe des cotisations (" + cotisations.size() + " cotisations)\n");
		cotisations.stream().forEach(c -> LOGINFO.trace(c.toString()));
		return true;
	}
	
	/**
	 * Method to format string
	 * @param value
	 * @return
	 */
	public String upperCaseAllFirst(String value) {

        char[] array = value.toCharArray();
        // Uppercase first letter.
        array[0] = Character.toUpperCase(array[0]);

        // Uppercase all letters that follow a whitespace character.
        for (int i = 1; i < array.length; i++) {
            if (Character.isWhitespace(array[i - 1])) {
                array[i] = Character.toUpperCase(array[i]);
            }
        }

        // Result.
        return new String(array);
    }


}