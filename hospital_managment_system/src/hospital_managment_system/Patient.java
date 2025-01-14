package hospital_managment_system;

public class Patient {

	 private String name;
	    private int age;
	    private String address;

	    public Patient(String name, int age, String address) {
	        this.name = name;
	        this.age = age;
	        this.address = address;
	    }

	    public String getName() {
	        return name;
	    }

	    @Override
	    public String toString() {
	        return "Name: " + name + ", Age: " + age + ", Address: " + address;
	    }
}
