package Robot;

public class Robot {

	// variable
	private String name;
	private String serialNumber;
	
	// constructor
	Robot(String name, String serialNumber){
		this.name = name;
		this.serialNumber = serialNumber;
	}
	
	// getter and setter
	public String getSerialNumber() {
		
		return serialNumber;
		
	}
	
	public void setSerialNumber(String serialNumber) {
		
		this.serialNumber = serialNumber;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
}
