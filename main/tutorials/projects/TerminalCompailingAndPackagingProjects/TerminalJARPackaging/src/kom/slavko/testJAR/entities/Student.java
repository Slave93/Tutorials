package kom.slavko.testJAR.entities;

import org.apache.log4j.Logger;

public class Student {
	private String ime;
	private String prezime;
	private short brInd;

	public Student(String ime, String prezime, short brInd) {
		this.ime = ime;
		this.prezime = prezime;
		this.brInd = brInd;
	}

	final static Logger logger = Logger.getLogger(Student.class);

	public void pozrav() {
		logger.info("Student ce se upravo predstaviti");
		System.out.println("Zdravo ja sam " + ime + " " + prezime
				+ ", broj indeksa: " + brInd);
		logger.fatal("Studnet bacio fataliti");
	}
}
