package templateapp.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String error;
	
	
	public ErrorMessage() {
		
	}
		
	public ErrorMessage(String errorMessage) {
		this.error = errorMessage;		
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
