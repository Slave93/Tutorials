package slavko.kom.springTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value="consolewriter")
public class ConsoleWriter implements LogWriter {

	private String randomOutput = "Random String";
	private String userName;
	private String password;
	
	public void write(String text) {
		System.out.println(text);
	}
	
	public void writeRandom(){
		System.out.println(this.randomOutput);
	}
	@Autowired
	public void setRandomOutput(@Value("#{randomString.getString()}") String randomOutput){
		this.randomOutput = randomOutput;
	}
	
	public String getRandomOutput(){
		return this.randomOutput;
	}

	public String getUserName() {
		return userName;
	}
	@Autowired
	public void setUserName(@Value("${jdbc.user}") String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
