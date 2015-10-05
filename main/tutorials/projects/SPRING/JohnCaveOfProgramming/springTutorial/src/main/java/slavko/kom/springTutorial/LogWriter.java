package slavko.kom.springTutorial;

import org.springframework.beans.factory.annotation.Qualifier;


public interface LogWriter {
	public void write(String text);

	public void writeRandom();
}
