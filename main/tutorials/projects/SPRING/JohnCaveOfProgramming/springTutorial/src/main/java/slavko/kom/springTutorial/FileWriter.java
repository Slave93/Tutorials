package slavko.kom.springTutorial;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value="fileWriter")
public class FileWriter implements LogWriter {

	public void write(String text) {
		// Write to a file here.
		// Dummy implementation
		System.out.println("Write to file: " + text);
		
	}
	
	public void writeRandom() {
		System.out.println("Writing to file some random text...");		
	}

}
