package hospital_managment_system;

public class Staff {
	private String name;
	private String role;
	
	public Staff(String name, String role) {
		this.name = name;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Role: " + role;
	}
	
}
