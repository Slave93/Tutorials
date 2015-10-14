package kom.slavko.testJAR;

import kom.slavko.testJAR.entities.Student;

import org.apache.log4j.Logger;

public class App {
	
	final static Logger logger = Logger.getLogger(App.class);
	
	public static void main(String[] args) {
		logger.info("Main started");
		Student st1 = new Student("Slavko","Komarica",(short)1412);
		st1.pozrav();
		logger.debug("Main over");
		
		
	}
}
