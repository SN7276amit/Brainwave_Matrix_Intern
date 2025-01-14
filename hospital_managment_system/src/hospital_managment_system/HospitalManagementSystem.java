package hospital_managment_system;
import java.util.Scanner;
public class HospitalManagementSystem {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Hospital hospital = new Hospital("Rubi Hospital");
		int choice;

		do {
			System.out.println("\n--- Welcome to " + hospital.getName() + " ---");
			System.out.println(
					"Enter Choice \n1.Patient Registration \n2.Appointment Scheduling \n3.Electronic Health Records (EHR)"
							+ " \n4.Billing And Invoicing \n5.Inventory Management \n6.Staff Management \n7.View Registered Patients \n8.Exit");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				hospital.registerPatient();
				break;
			case 2:
				hospital.scheduleAppointment();
				break;
			case 3:
				hospital.viewEHR();
				break;
			case 4:
				hospital.generateBill();
				break;
			case 5:
				hospital.manageInventory();
				break;
			case 6:
				hospital.manageStaff();
				break;
			case 7:
				System.out.println("Exiting... Thank you for using the system!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 7);
	}
}
