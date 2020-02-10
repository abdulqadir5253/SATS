package bean;

import java.io.Serializable;

public class LoggedInBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoggedInBean(){
		
	}
	
	private String Id;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
	
}
