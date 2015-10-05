package slavko.kom.springTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * Dummy implementation of logger.
 */
@Component
public class Logger {

	private LogWriter consoleWriter;
	private LogWriter fileWriter;
	
	/*public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}*/
	@Autowired
	@Qualifier(value="consolewriter")
	public void setConsoleWriter(LogWriter writer) {
		this.consoleWriter = writer;
	}
	
	@Autowired(required=false)
	@Qualifier(value="fileWriter")
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text) {
		if(fileWriter!=null)
			fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
		consoleWriter.write(text);
	}
	public void writeRandomConsole() {
		consoleWriter.writeRandom();
	}
	public void writeUserName(){
		ConsoleWriter cw = (ConsoleWriter)consoleWriter;
		System.out.println(cw.getUserName());
	}

}
