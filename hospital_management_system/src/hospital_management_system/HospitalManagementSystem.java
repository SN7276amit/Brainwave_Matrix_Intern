package hospital_management_system;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalManagementSystem {
	 public static void main(String[] args) {
			Hospital hospital = new Hospital("Rubi Hospital");
			Scanner scanner = new Scanner(System.in);	
			int choice;
			try{
				do {
				try{
					System.out.println("\n--- Welcome to " + hospital.getName() + " ---");
				System.out.println(
						"Enter Choice \n1.Patient Registration \n2.Appointment Scheduling \n3.Electronic Health Records (EHR)"
								+ " \n4.Billing And Invoicing \n5.Inventory Management \n6.Staff Management \n7.Exit");
							if (!scanner.hasNextInt()) {
	                        System.out.println("Invalid input. Please enter a number.");
	                        scanner.next(); 
	                        continue;
	                    }
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
				}
				 catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.nextLine(); 
	            } catch (Exception e) {
	                System.out.println("An error occurred: " + e.getMessage());
	            }
			} while (true);
			}
	            finally {
	            scanner.close();
	        }
			
		}


}
