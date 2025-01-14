package hospital_managment_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Hospital {
	private String name;
	List<Patient> patients;
	private List<Staff> staff;
	private Map<String, Integer> inventory;
	Scanner scanner = new Scanner(System.in);

	public Hospital(String name) {
		this.name = name;
		this.patients = new ArrayList<>();
		this.staff = new ArrayList<>();
		this.inventory = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void registerPatient() {
		System.out.print("Enter patient name: ");
		String name = scanner.next();
		System.out.print("Enter patient age: ");
		int age = scanner.nextInt();
		System.out.print("Enter patient address: ");
		String address = scanner.next();
		Patient patient = new Patient(name, age, address);
		patients.add(patient);
		System.out.println("Patient registered successfully!");
	}

	public void scheduleAppointment() {
		System.out.print("Enter patient name for appointment: ");
		String patientName = scanner.next();
		System.out.print("Enter doctor name: ");
		String doctorName = scanner.next();
		System.out.print("Enter appointment date (yyyy-mm-dd): ");
		String date = scanner.next();
		System.out.println(
				"Appointment scheduled successfully for " + patientName + " with Dr. " + doctorName + " on " + date);
	}

	public void viewEHR() {
		System.out.print("Enter patient name to view EHR: ");
		String name = scanner.next();
		for (Patient patient : patients) {
			if (patient.getName().equalsIgnoreCase(name)) {
				System.out.println("EHR for " + name + ": " + patient);
				return;
			}
		}
		System.out.println("Patient not found.");
	}

	public void generateBill() {
		System.out.print("Enter patient name for billing: ");
		String name = scanner.next();
		System.out.print("Enter treatment cost: ");
		double cost = scanner.nextDouble();
		System.out.println("Invoice generated for " + name + ": $" + cost);
	}

	public void manageInventory() {
		System.out.println("Current inventory: " + inventory);
		System.out.print("Enter item name to update: ");
		String item = scanner.next();
		System.out.print("Enter quantity: ");
		int quantity = scanner.nextInt();
		inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
		System.out.println("Inventory updated.");
	}

	public void manageStaff() {
		System.out.print("Enter staff name to add: ");
		String name = scanner.next();
		System.out.print("Enter staff role: ");
		String role = scanner.next();
		Staff newStaff = new Staff(name, role);
		staff.add(newStaff);
		System.out.println("Staff added successfully.");
	}
}
