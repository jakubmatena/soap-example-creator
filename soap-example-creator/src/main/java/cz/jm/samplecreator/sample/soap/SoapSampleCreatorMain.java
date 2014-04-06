package cz.jm.samplecreator.sample.soap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class for creation example messages from command line.
 * 
 * @author jakubmatena
 * 
 */
public class SoapSampleCreatorMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}
