package hospital_management_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Hospital {
	private String name;
	List<Patient> patients;
	private List<Staff> staff;
	private Map<String, Integer> inventory;
	private int patientIdCounter=1;
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
		try {
			System.out.print("Enter patient name: ");
			String name = scanner.next().trim();
			scanner.nextLine();
			System.out.print("Enter patient age: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Age must be a number.");
				scanner.next();
				System.out.print("Enter patient age: ");
			}
			int age = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter patient address: ");
			String address = scanner.nextLine().trim();

			if (name.isEmpty() || address.isEmpty()) {
				System.out.println("Name and address cannot be empty.");
				return;
			}

			Patient patient = new Patient(patientIdCounter++, name, age, address);
			patients.add(patient);
			System.out.println("Patient registered successfully! Patient ID: " + patient.getId());
		} catch (Exception e) {
			System.out.println("An error occurred while registering the patient: " + e.getMessage());
		}
	}

	public void scheduleAppointment() {
		try {
			System.out.print("Enter patient ID for appointment: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. ID must be a number.");
				scanner.next();
				System.out.print("Enter patient ID for appointment: ");
			}
			int patientId = scanner.nextInt();
			scanner.nextLine();

			Patient patient = findPatientById(patientId);
			if (patient == null) {
				System.out.println("Patient not found.");
				return;
			}

			System.out.print("Enter doctor name: ");
			String doctorName = scanner.nextLine().trim();
			System.out.print("Enter appointment date (yyyy-mm-dd): ");
			String dateInput = scanner.nextLine().trim();

			LocalDate date;
			try {
				date = LocalDate.parse(dateInput);
			} catch (DateTimeParseException e) {
				System.out.println("Invalid date format. Please use yyyy-mm-dd.");
				return;
			}

			System.out.println("Appointment scheduled successfully for " + patient.getName() + " with Dr. " + doctorName
					+ " on " + date);
		} catch (Exception e) {
			System.out.println("An error occurred while scheduling the appointment: " + e.getMessage());
		}
	}

	public void viewEHR() {
		try {
			System.out.print("Enter patient ID to view EHR: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. ID must be a number.");
				scanner.next();
				System.out.print("Enter patient ID to view EHR: ");
			}
			int patientId = scanner.nextInt();

			Patient patient = findPatientById(patientId);
			if (patient == null) {
				System.out.println("Patient not found.");
				return;
			}

			System.out.println("EHR for Patient ID " + patientId + ": " + patient);
		} catch (Exception e) {
			System.out.println("An error occurred while viewing EHR: " + e.getMessage());
		}
	}

	public void generateBill() {
		try {
			System.out.print("Enter patient ID for billing: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. ID must be a number.");
				scanner.next();
				System.out.print("Enter patient ID for billing: ");
			}
			int patientId = scanner.nextInt();

			Patient patient = findPatientById(patientId);
			if (patient == null) {
				System.out.println("Patient not found.");
				return;
			}

			System.out.print("Enter treatment cost: ");
			while (!scanner.hasNextDouble()) {
				System.out.println("Invalid input. Cost must be a number.");
				scanner.next();
				System.out.print("Enter treatment cost: ");
			}
			double cost = scanner.nextDouble();

			System.out.println("Invoice generated for " + patient.getName() + ": $" + cost);
		} catch (Exception e) {
			System.out.println("An error occurred while generating the bill: " + e.getMessage());
		}
	}

	public void manageInventory() {
		try {
			System.out.println("Current inventory: " + inventory);
			System.out.print("Enter item name to update: ");
			String item = scanner.next().trim();
			System.out.print("Enter quantity: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Quantity must be a number.");
				scanner.next();
				System.out.print("Enter quantity: ");
			}
			int quantity = scanner.nextInt();

			if (quantity < 0) {
				System.out.println("Quantity cannot be negative.");
				return;
			}

			inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
			System.out.println("Inventory updated.");
		} catch (Exception e) {
			System.out.println("An error occurred while managing inventory: " + e.getMessage());
		}
	}

	public void manageStaff() {
		try {
			System.out.println("1. Add Staff");
			System.out.println("2. View Staff");
			System.out.println("3. Remove Staff");
			System.out.print("Enter your choice: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next();
				System.out.print("Enter your choice: ");
			}
			int choice = scanner.nextInt();
			scanner.nextLine(); // Clear the buffer

			switch (choice) {
			case 1:
				System.out.print("Enter staff name: ");
				String name = scanner.nextLine().trim();
				System.out.print("Enter staff role: ");
				String role = scanner.nextLine().trim();

				if (name.isEmpty() || role.isEmpty()) {
					System.out.println("Name and role cannot be empty.");
					return;
				}

				staff.add(new Staff(name, role));
				System.out.println("Staff added successfully!");
				break;
			case 2:
				if (staff.isEmpty()) {
					System.out.println("No staff found.");
				} else {
					System.out.println("Staff List:");
					for (Staff s : staff) {
						System.out.println(s);
					}
				}
				break;
			case 3:
				System.out.print("Enter staff name to remove: ");
				String staffName = scanner.nextLine().trim();
				boolean removed = staff.removeIf(s -> s.getName().equalsIgnoreCase(staffName));
				if (removed) {
					System.out.println("Staff removed successfully!");
				} else {
					System.out.println("Staff not found.");
				}
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} catch (Exception e) {
			System.out.println("An error occurred while managing staff: " + e.getMessage());
		}
	}

	private Patient findPatientById(int id) {
		for (Patient patient : patients) {
			if (patient.getId() == id) {
				return patient;
			}
		}
		return null;
	}

}
