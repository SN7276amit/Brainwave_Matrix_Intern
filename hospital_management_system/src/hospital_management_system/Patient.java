package hospital_management_system;

public class Patient {
	 private int id;
	    private String name;
	    private int age;
	    private String address;

	    public Patient(int id, String name, int age, String address) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.address = address;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    @Override
	    public String toString() {
	        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Address: " + address;
	    }
}
